package com.example.aulafragments.Model;

public class PerfilUsuario {
    private String nome;
    private String dataNascimento;
    private String genero;
    private String email;
    private String telefone;
    private String[] lugaresVisitados;

    public PerfilUsuario(String nome, String dataNascimento, String genero, String email, String telefone) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLugaresVisitados(String[] lugaresVisitados) {
        this.lugaresVisitados = lugaresVisitados;
    }

    public String[] getLugaresVisitados() {
        return lugaresVisitados;
    }
}
