package br.fsa.faculdade;

import br.fsa.pessoa.Aluno;

/**
 * Recebe as notas de um aluno (P1, P2 e trabalho)
 * A classe contém métodos para acessar e modificar os valores das notas
 */

public class Nota {
    protected Aluno aluno;
    protected Materia materia;
    protected double P1;
    protected double P2;
    protected double trabalho;

    /**
     * Construtor que inicializa todos os atributos da classe
     * @param aluno
     * @param materia
     * @param p1
     * @param p2
     * @param trabalho
     */
    public Nota(Aluno aluno, Materia materia, double p1, double p2, double trabalho){
        this.aluno = aluno;
        this.materia = materia;
        this.P1 = p1;
        this.P2 = p2;
        this.trabalho = trabalho;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getP1(){
        return P1;
    }

    public void setP1(double P1){
        this.P1 = P1;
    }

    public double getP2(){
        return P2;
    }

    public void setP2(double P2){
        this.P2 = P2;
    }

    public double getTrabalho(){
        return trabalho;
    }

    public void setTrabalho(double Trabalho){
        this.trabalho = Trabalho;
    }

}
