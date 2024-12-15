package com.example.aulafragments.Model;

public class PacoteViagem {
    private String origem;
    private String destino;
    private String dataIda;
    private String dataVolta;
    private int pessoasInclusas;
    private float valor;

    public PacoteViagem(String origem, String destino, String dataIda, String dataVolta, int pessoasInclusas, float valor) {
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.pessoasInclusas = pessoasInclusas;
        this.valor = valor;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDataIda() {
        return dataIda;
    }

    public void setDataIda(String dataIda) {
        this.dataIda = dataIda;
    }

    public int getPessoasInclusas() {
        return pessoasInclusas;
    }

    public void setPessoasInclusas(int pessoasInclusas) {
        this.pessoasInclusas = pessoasInclusas;
    }

    public String getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(String dataVolta) {
        this.dataVolta = dataVolta;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
