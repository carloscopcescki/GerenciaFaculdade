package br.fsa.dao;

import br.fsa.pessoa.Professor;

import java.util.List;

/**
 * Classe responsável por ler e escrever os dados dos professores
 */

public class ProfessorDAO implements LeitorArquivo {

    /**
     * Método que define o nome do arquivo professores
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
     * Salva a lista de objetos Notas, no arquivo
     * @param professores
     */
    public void salvarProfessores(List<Professor> professores){
    }
}
