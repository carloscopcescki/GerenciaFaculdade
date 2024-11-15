package br.fsa.dao;

import br.fsa.pessoa.Aluno;

import java.util.List;

/**
 * Classe responsável por ler e escrever os dados dos alunos
 */

public class AlunoDAO implements LeitorArquivo{

    /**
     * Método que define o nome do arquivo alunos
     * @param fileName
     */
    public void setArquivo(String fileName){
    }

    /**
     * Escreve as linhas no arquivo
     * @param linhas
     */
    public void escreveArquivo(List<String> linhas){
    }

    /**
     * Efetua a leitura do arquivo
     * @return
     */
    public List<String> leArquivo(){
        return null;
    }

    /**
     * Salva a lista de objetos Alunos, no arquivo
     * @param alunos
     */
    public void salvarAluno(List<Aluno> alunos){
    }

}
