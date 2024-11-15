package br.fsa.pessoa;

import java.util.Date;

public class Aluno extends Pessoa {
    protected String curso;
    protected int codUnico;

    public Aluno(){
    }

    public Aluno(String nome, Date dataNasc, String cep, String rua,
                 String numero, String cidade, String estado, String telefone,
                 String genero, String rg, String cpf, String curso) {

        this.nome = nome;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.genero = genero;
        this.rg = rg;
        this.cpf = cpf;

        this.curso = curso;
        this.codUnico = codUnico;
    }

    public Aluno(String nome, Date dataNasc, String endereco, String cep, String rua, String numero, String cidade, String estado, String telefone, String genero, String rg, String cpf, String curso, int codUnico) {
        super();
    }

    public String getCurso(){
        return curso;
    }

    public void setCurso(String curso){
        this.curso = curso;
    }

    public int getCodUnico(){
        return codUnico;
    }

    public void setCodUnico(int codUnico){
        this.codUnico = codUnico;
    }

}
