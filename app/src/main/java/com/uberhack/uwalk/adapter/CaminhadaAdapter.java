package com.uberhack.uwalk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.model.Caminhada;

import java.util.List;

public class CaminhadaAdapter extends RecyclerView.Adapter<CaminhadaAdapter.MyViewHolder> {

    private List<Caminhada> listaCaminhadas;
    private Context context;

    public CaminhadaAdapter(List<Caminhada> listaCaminhadas, Context context) {
        this.listaCaminhadas = listaCaminhadas;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_caminhada_adapter, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Caminhada caminhada = listaCaminhadas.get(i);

        myViewHolder.textData.setText(caminhada.getData());
        myViewHolder.textCaloriasGastas.setText(caminhada.getCaloriasGastas() + " kcal");
        myViewHolder.textDistancia.setText(String.valueOf(caminhada.getDistancia()) + " m");
        myViewHolder.textTempo.setText(caminhada.getTempo());
        myViewHolder.textPassos.setText(caminhada.getPassos() + " passos");

    }

    @Override
    public int getItemCount() {
        return listaCaminhadas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textCaloriasGastas, textDistancia, textTempo, textData, textPassos;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textCaloriasGastas = itemView.findViewById(R.id.textCaloriasGastas);
            textDistancia = itemView.findViewById(R.id.textDistancia);
            textData = itemView.findViewById(R.id.textData);
            textTempo = itemView.findViewById(R.id.textTempo);
            textPassos = itemView.findViewById(R.id.textoPassos);
        }
    }
}
