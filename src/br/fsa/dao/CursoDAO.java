package br.fsa.dao;

import br.fsa.faculdade.Curso;

import java.util.List;

/**
 * Classe responsável por ler e escrever os dados dos cursos
 */

public class CursoDAO implements LeitorArquivo {

    /**
     * Método que define o nome do arquivo cursos
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
     * Salva a lista de objetos Cursos, no arquivo
     * @param cursos
     */
    public void salvarCursos(List<Curso> cursos){
    }
}
