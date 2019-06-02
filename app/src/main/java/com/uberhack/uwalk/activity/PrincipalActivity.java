package com.uberhack.uwalk.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.fragment.AjudaFragment;
import com.uberhack.uwalk.fragment.MapsFragment;
import com.uberhack.uwalk.fragment.ObjetivosFragment;
import com.uberhack.uwalk.fragment.ResgatePontosFragment;
import com.uberhack.uwalk.fragment.UltimasCaminhadasFragment;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private UltimasCaminhadasFragment ultimasCaminhadasFragment = new UltimasCaminhadasFragment();
    private MapsFragment mapsFragment = new MapsFragment();
    private ResgatePontosFragment resgatePontosFragment = new ResgatePontosFragment();
    private ObjetivosFragment objetivosFragment = new ObjetivosFragment();
    private AjudaFragment ajudaFragment = new AjudaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Início");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Colocando o primeiro item do Navigation Drawer como selecionado
        navigationView.setCheckedItem(R.id.lista_caminhadas);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, ultimasCaminhadasFragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.lista_caminhadas) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutMain, ultimasCaminhadasFragment);
            ft.commit();
            getSupportActionBar().setTitle("Início");
        } else if (id == R.id.nav_gallery) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutMain, mapsFragment);
            ft.commit();
            getSupportActionBar().setTitle("Caminhar");
        } else if (id == R.id.nav_slideshow) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutMain, resgatePontosFragment);
            ft.commit();
            getSupportActionBar().setTitle("Resgatar");
        } else if (id == R.id.nav_missoes) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutMain, objetivosFragment);
            ft.commit();
            getSupportActionBar().setTitle("Objetivos");
        } else if (id == R.id.nav_ajuda) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutMain, ajudaFragment);
            ft.commit();
            getSupportActionBar().setTitle("Ajuda");
        } else if (id == R.id.nav_sair) {
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
