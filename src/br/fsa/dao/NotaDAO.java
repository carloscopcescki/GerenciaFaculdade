package br.fsa.dao;

import br.fsa.faculdade.Nota;

import java.util.List;

/**
 * Classe responsável por ler e escrever os dados das notas
 */

public class NotaDAO implements LeitorArquivo {

    /**
     * Método que define o nome do arquivo notas
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
     * @param notas
     */
    public void salvarNotas(List<Nota> notas){
    }
}
