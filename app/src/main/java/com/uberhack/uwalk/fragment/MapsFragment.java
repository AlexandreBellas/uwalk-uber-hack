package com.uberhack.uwalk.fragment;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.uberhack.uwalk.R;
import com.uberhack.uwalk.activity.PrincipalActivity;
import com.uberhack.uwalk.helper.Permissoes;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapsFragment extends Fragment {

    MapView mMapView;
    private GoogleMap googleMap;
    private String[] permissoes = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private LocationManager locationManager;
    private LocationListener locationListener;

    private double latInit;
    private double longInit;

    private int i = 0;

    private TextView textoDistancia, textoPassos;

    public MapsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_maps, container, false);

        textoDistancia = rootView.findViewById(R.id.textoDistancia);
        textoPassos = rootView.findViewById(R.id.textoPassos);

        mMapView = rootView.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // For showing a move to my location button
                //Validar permissões
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    //Validar permissões
                    Permissoes.validarPermissoes(permissoes, getActivity(), 1);
                    return;
                }
                googleMap.setMyLocationEnabled(true);
            }
        });

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //Caso a localização do usuário mude
                if (i == 0){
                    latInit = location.getLatitude();
                    longInit = location.getLongitude();
                    i = 1;
                }
                else{
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    double distLatLong = distance(latitude, longitude, latInit, longInit);

                    textoDistancia.setText(String.valueOf(distLatLong) + " m");
                    textoPassos.setText(String.valueOf((int) distLatLong/1.5));

                    googleMap.clear();
                    LatLng localUsuario = new LatLng(latitude, longitude);

                    // For zooming automatically to the location of the marker
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(localUsuario).zoom(12).build();
                    googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                //Caso o usuário ative/desative o serviço de localização do usuário
            }

            @Override
            public void onProviderEnabled(String provider) {
                //Caso o usuário habilite o serviço de localização
            }

            @Override
            public void onProviderDisabled(String provider) {
                //Caso o usuário desabilite o serviço de localização
            }
        };

        return rootView;
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1))
                * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1))
                * Math.cos(deg2rad(lat2))
                * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        return 1000*(dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
