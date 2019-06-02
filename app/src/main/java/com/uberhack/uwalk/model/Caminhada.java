package com.uberhack.uwalk.model;

public class Caminhada {

    private String tempo;
    private float distancia; //metros
    private String data;
    private int passos;
    private int caloriasGastas;

    public Caminhada(String tempo, float distancia, String data, int passos, int caloriasGastas) {
        this.tempo = tempo;
        this.distancia = distancia;
        this.data = data;
        this.passos = passos;
        this.caloriasGastas = caloriasGastas;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCaloriasGastas() {
        return caloriasGastas;
    }

    public void setCaloriasGastas(int caloriasGastas) {
        this.caloriasGastas = caloriasGastas;
    }

    public int getPassos() {
        return passos;
    }

    public void setPassos(int passos) {
        this.passos = passos;
    }
}
