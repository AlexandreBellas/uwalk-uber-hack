package com.uberhack.uwalk.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uberhack.uwalk.R;
import com.uberhack.uwalk.model.Produto;

import java.util.List;

public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.MyViewHolder> {

    private List<Produto> listaProduto;
    private Context context;

    public ProdutoAdapter(List<Produto> listaProduto, Context context) {
        this.listaProduto = listaProduto;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout_adapter_produto, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Produto produto = listaProduto.get(i);

        myViewHolder.textNome.setText(produto.getNome());
        myViewHolder.textPreco.setText(produto.getPreco());
        myViewHolder.imagemProduto.setImageResource(R.drawable.logo2);

    }

    @Override
    public int getItemCount() {
        return listaProduto.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textNome, textPreco;
        ImageView imagemProduto;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textNome = itemView.findViewById(R.id.textoNome);
            textPreco = itemView.findViewById(R.id.textoValor);
            imagemProduto = itemView.findViewById(R.id.imagemProduto);
        }
    }
}
