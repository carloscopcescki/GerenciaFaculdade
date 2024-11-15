package br.fsa.util;

public class Utilitarios {
    public static boolean verificaCPF(String cpf) {

        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11) {
            return false;
        }

        if (cpf.chars().distinct().count() == 1) {
            return false;
        }

        int soma;
        int sobra;
        soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (Character.getNumericValue(cpf.charAt(i)) * (10 - i));
        }

        sobra = 11 - (soma % 11);
        if (sobra >= 10) {
            sobra = 0;
        }

        if (sobra != Character.getNumericValue(cpf.charAt(9))) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (Character.getNumericValue(cpf.charAt(i)) * (11 - i));
        }
        sobra = 11 - (soma % 11);
        if (sobra >= 10) {
            sobra = 0;
        }
        return sobra == Character.getNumericValue(cpf.charAt(10));
    }

    public static boolean verificaTel(String tel) {
        tel = tel.replaceAll("[^0-9]", "");

        return tel.length() == 10 || tel.length() == 11;
    }
}
