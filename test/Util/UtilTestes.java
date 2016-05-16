package Util;

import java.sql.Date;
import java.util.Random;

public class UtilTestes {

    public static int criaIdAleatorio() {

        Random gerador = new Random();
        int numeroGerado = gerador.nextInt(1001);
        return numeroGerado;
    }

    public static Date criaDataCorrente() {

        Date data = new Date(System.currentTimeMillis());
        return data;
    }

    public static String criaPalavraAleatoria() {

        @SuppressWarnings("UnusedAssignment")
        int index = -1;
        String letras = "ABC";
        String aleatoria = new String();
        Random gerador = new Random();
        for (int i = 0; i < 3; i++) {
            index = gerador.nextInt(letras.length());
            aleatoria += letras.substring(index, index + 1);
        }

        return aleatoria;
    }

}
