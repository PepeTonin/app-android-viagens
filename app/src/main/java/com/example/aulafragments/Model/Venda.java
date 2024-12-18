package com.example.aulafragments.Model;

public class Venda {
    private String nome;
    private String datanascimento;
    private String email;
    private String telefone;
    private String origem;
    private String destino;
    private String dataIda;
    private String dataVolta;
    private int pessoas;
    private float valor;

    public Venda(String nome, String datanascimento, String email, String telefone, String origem, String destino, String dataIda, String dataVolta, int pessoas, float valor) {
        this.nome = nome;
        this.datanascimento = datanascimento;
        this.email = email;
        this.telefone = telefone;
        this.origem = origem;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.pessoas = pessoas;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getDataIda() {
        return dataIda;
    }

    public String getDataVolta() {
        return dataVolta;
    }

    public int getPessoas() {
        return pessoas;
    }

    public float getValor() {
        return valor;
    }
}
