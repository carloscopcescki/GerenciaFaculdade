package br.fsa.faculdade;

public class Materia {

    private int codUnico;

    private String nome;

    private static int proximo = 1;

    public Materia(String nome) {
        this.codUnico = proximo++;
        this.nome = nome;
    }

    public int getCodigoUnico() {
        return codUnico;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Código: " + codUnico + " | Nome: " + nome;
    }
}
