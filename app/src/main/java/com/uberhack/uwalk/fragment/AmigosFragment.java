package com.uberhack.uwalk.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.RecyclerItemClickListener;
import com.uberhack.uwalk.adapter.AdapterConversas;
import com.uberhack.uwalk.adapter.ProdutoAdapter;
import com.uberhack.uwalk.model.Conversa;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmigosFragment extends Fragment {

    private RecyclerView recyclerConversas;
    private List<Conversa> listaConversa = new ArrayList<>();
    private AdapterConversas adapterConversas;

    public AmigosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amigos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerConversas = view.findViewById(R.id.recyclerConversas);
        adicionaConversas();
        configurarRecyclerView();

    }

    private void configurarRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerConversas.setLayoutManager(layoutManager);

        adapterConversas = new AdapterConversas(listaConversa, getContext());
        recyclerConversas.setAdapter(adapterConversas);

        recyclerConversas.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerConversas,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Intent i
                                Toast.makeText(getContext(), "Abrir conversa", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }

    private void adicionaConversas(){
        Conversa conversa;

        conversa = new Conversa(
                "Péricles da Silva",
                1500
        );
        listaConversa.add(conversa);

        conversa = new Conversa(
                "Antônio arregalado",
                3700
        );
        listaConversa.add(conversa);

        conversa = new Conversa(
                "Mariana do destino",
                4200
        );
        listaConversa.add(conversa);
    }
}
