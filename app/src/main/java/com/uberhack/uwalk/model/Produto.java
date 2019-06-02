package com.uberhack.uwalk.model;

public class Produto {
    private int imagem;
    private String nome;
    private String preco;

    public Produto(int imagem, String nome, String preco) {
        this.imagem = imagem;
        this.nome = nome;
        this.preco = preco;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
