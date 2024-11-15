package br.fsa.util;

import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private String nomeArq;

    public Log(String nomeArq){
        this.nomeArq = nomeArq;
    }

    public void logErro(String mensagem){
        try (FileWriter writer = new FileWriter(nomeArq, true)) {
            writer.write("ERRO - " + mensagem + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logInfo(String mensagem){
        try (FileWriter writer = new FileWriter(nomeArq, true)) {
            writer.write("INFO - " + mensagem + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
