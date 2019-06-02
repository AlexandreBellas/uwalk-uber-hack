package com.uberhack.uwalk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.model.Conversa;

import java.util.List;

public class AdapterConversas extends RecyclerView.Adapter<AdapterConversas.MyViewHolder> {

    private List<Conversa> listaConversas;
    private Context context;

    public AdapterConversas(List<Conversa> listaConversas, Context context) {
        this.listaConversas = listaConversas;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_conversas_adapter, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Conversa conversa = listaConversas.get(i);
        System.out.println(myViewHolder);

        myViewHolder.textoNome.setText(conversa.getNome());
        myViewHolder.textoPontos.setText(String.valueOf(conversa.getPontos()) + " pontos");

    }

    @Override
    public int getItemCount() {
        return listaConversas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textoNome;
        TextView textoPontos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textoNome = itemView.findViewById(R.id.textoNome);
            textoPontos = itemView.findViewById(R.id.textoPontos);
        }
    }
}
