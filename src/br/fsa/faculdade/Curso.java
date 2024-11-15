package br.fsa.faculdade;

import java.util.List;

public class Curso {
    private String nome;
    protected int codUnico;
    protected List<String> listaMaterias;

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(String nome, List<String> listaMaterias, int codigoUnico) {
        this.nome = nome;
        this.listaMaterias = listaMaterias;
        this.codUnico = codigoUnico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getMaterias() {
        return listaMaterias;
    }

    public int getCodigoUnico() {
        return codUnico;
    }

    public void setCodigoUnico(int codigoUnico) {
        this.codUnico = codigoUnico;
    }
}