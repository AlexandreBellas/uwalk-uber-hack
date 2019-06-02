package com.uberhack.uwalk.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.RecyclerItemClickListener;
import com.uberhack.uwalk.adapter.CaminhadaAdapter;
import com.uberhack.uwalk.model.Caminhada;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UltimasCaminhadasFragment extends Fragment {

    private RecyclerView recyclerCaminhadas;
    private List<Caminhada> listaCaminhadas = new ArrayList<>();
    private CaminhadaAdapter caminhadaAdapter;
    private TextView textoPassos;

    public UltimasCaminhadasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ultimas_caminhadas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerCaminhadas = getView().findViewById(R.id.recyclerCaminhadas);
        textoPassos = getView().findViewById(R.id.textoPassos);

        //Configurando RecyclerView
        recuperarDadosListaDeCaminhadas();
        configurarRecyclerView();
        textoPassos.setText(String.valueOf(contarPassos()));
    }

    void configurarRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerCaminhadas.setLayoutManager(layoutManager);

        caminhadaAdapter = new CaminhadaAdapter(listaCaminhadas, getContext());
        recyclerCaminhadas.setAdapter(caminhadaAdapter);
    }

    void recuperarDadosListaDeCaminhadas(){
        listaCaminhadas.clear();
        Caminhada caminhada;

        caminhada = new Caminhada(
                "15s",
                10,
                "20/05/2019",
                12,
                10
        );
        listaCaminhadas.add(caminhada);

        caminhada = new Caminhada(
                "2h",
                10000,
                "04/04/2019",
                4000,
                300
        );
        listaCaminhadas.add(caminhada);

        caminhada = new Caminhada(
                "3 min",
                400,
                "01/04/2019",
                500,
                12
        );
        listaCaminhadas.add(caminhada);

        caminhada = new Caminhada(
                "1h",
                1200,
                "20/03/2019",
                123,
                2
        );
        listaCaminhadas.add(caminhada);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    private int contarPassos(){
        if (listaCaminhadas.isEmpty()){
            return 0;
        }

        int passos = 0;
        for(Caminhada caminhada : listaCaminhadas){
            passos += caminhada.getPassos();
        }

        return passos;
    }
}
