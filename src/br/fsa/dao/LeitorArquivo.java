package br.fsa.dao;

import java.util.List;

public interface LeitorArquivo {
    void setArquivo(String fileName);

    void escreveArquivo(List<String> linhas);

    List<String> leArquivo();
}
