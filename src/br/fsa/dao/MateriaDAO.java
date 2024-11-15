package br.fsa.dao;

import br.fsa.faculdade.Materia;

import java.util.List;

/**
 * Classe responsável por ler e escrever os dados das matérias
 */

public class MateriaDAO implements LeitorArquivo {

    /**
     * Método que define o nome do arquivo matérias
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
     * Salva a lista de objetos Materias, no arquivo
     * @param materias
     */
    public void salvarMaterias(List<Materia> materias){
    }
}
