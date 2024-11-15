package br.fsa.dao;

import java.util.List;

/**
 * A interface LeitorArquivo define um contrato para classes que desejam
 * realizar operações de leitura e escrita em arquivos
 */

public interface LeitorArquivo {

    /**
     * Define o nome do arquivo a ser utilizado
     * @param fileName
     */
    void setArquivo(String fileName);

    /**
     * Escreve as linhas no arquivo
     * @param linhas
     */
    void escreveArquivo(List<String> linhas);

    /**
     * Realiza a leitura do arquivo
     * @return
     */
    List<String> leArquivo();
}
