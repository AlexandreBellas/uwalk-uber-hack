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
import android.widget.TextView;
import android.widget.Toast;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.RecyclerItemClickListener;
import com.uberhack.uwalk.adapter.CaminhadaAdapter;
import com.uberhack.uwalk.adapter.ProdutoAdapter;
import com.uberhack.uwalk.model.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResgatePontosFragment extends Fragment {

    private TextView textoPontos;
    private RecyclerView recyclerProdutos;
    private List<Produto> listaProduto = new ArrayList<>();
    private ProdutoAdapter produtoAdapter;

    public ResgatePontosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resgate_pontos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerProdutos = getView().findViewById(R.id.recyclerProdutos);
        textoPontos = getView().findViewById(R.id.textoPontos);

        //Configurando RecyclerView
        recuperarDadosListaDeProdutos();
        configurarRecyclerView();
        textoPontos.setText(String.valueOf("6072"));
    }

    private void configurarRecyclerView(){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerProdutos.setLayoutManager(layoutManager);

        produtoAdapter = new ProdutoAdapter(listaProduto, getContext());
        recyclerProdutos.setAdapter(produtoAdapter);

        recyclerProdutos.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getContext(),
                        recyclerProdutos,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Intent i
                                Toast.makeText(getContext(), "Potato", Toast.LENGTH_SHORT).show();
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

    private void recuperarDadosListaDeProdutos(){
        Produto produto;

        produto = new Produto(
                R.drawable.logo2,
                "Voucher de R$0,10 no Bilhete único",
                "50000 pontos"
        );
        listaProduto.add(produto);

        produto = new Produto(
                R.drawable.logo2,
                "Desconto de 20% no açaí",
                "20000 pontos"
        );
        listaProduto.add(produto);

        produto = new Produto(
                R.drawable.logo2,
                "Voucher R$10,00 na loja de produtos naturais",
                "130000 pontos"
        );
        listaProduto.add(produto);

    }

}
