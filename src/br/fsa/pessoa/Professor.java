package br.fsa.pessoa;

import java.util.Date;
import java.util.List;

public class Professor extends Pessoa{
    protected List<String> listaMaterias;
    protected int codUnico;

    public Professor(){
    }

    public Professor(String nome, Date dataNasc, String endereco, String cep, String rua, String numero,
                     String cidade, String estado, String telefone, String genero, String rg, String cpf,
                     List<String> listaMaterias, int codUnico){

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
        this.listaMaterias = listaMaterias;
        this.codUnico = codUnico;
    }

    public List<String> getListaMaterias(){
        return listaMaterias;
    }

    public void setListaMaterias(List<String> listaMaterias){
        this.listaMaterias = listaMaterias;
    }

    public int getCodUnico(){
        return codUnico;
    }

    public void setCodUnico(int codUnico){
        this.codUnico = codUnico;
    }
}
