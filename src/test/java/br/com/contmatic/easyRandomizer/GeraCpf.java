package br.com.contmatic.easyRandomizer;

import java.util.Arrays;
import java.util.Random;

public class GeraCpf {
    public static String GeraCpf() {
        Random random = new Random();
        int numeros[] = new int[9];
        for(int i = 0 ; i < numeros.length ; i++) {
            numeros[i] = random.nextInt(9);
        }
        int calculoDigito1 = (((numeros[0] * 10) + (numeros[1] * 9) + (numeros[2] * 8) + (numeros[3] * 7) + (numeros[4] * 6) + (numeros[5] * 5) + (numeros[6] * 4) + (numeros[7] * 3) +
            (numeros[8] * 2)));
        int divisaoDigito1 = calculoDigito1 / 11;
        int multiplicacaoDigito1 = 11 * divisaoDigito1;
        int subtracaoDigito1 = calculoDigito1 - multiplicacaoDigito1;
        int Digito1 = 11 - subtracaoDigito1;
        String aux = Integer.toString(Digito1);

        if (Digito1 >= 11) {
            Digito1 += -Digito1;
        } else if (aux.length() >= 2) {
            Digito1 += -10;
        }
        int calculoDigito2 = (((numeros[0] * 11) + (numeros[1] * 10) + (numeros[2] * 9) + (numeros[3] * 8) + (numeros[4] * 7) + (numeros[5] * 6) + (numeros[6] * 5) + (numeros[7] * 4) +
            (numeros[8] * 3) + (Digito1 * 2)));
        int divisaoDigito2 = calculoDigito2 / 11;
        int multiplicacaoDigito2 = 11 * divisaoDigito2;
        int subtracaoDigito2 = calculoDigito2 - multiplicacaoDigito2;
        int Digito2 = 11 - subtracaoDigito2;
        String aux2 = Integer.toString(Digito2);

        if (Digito2 >= 11) {
            Digito2 += -Digito2;
        } else if (aux2.length() >= 2) {
            Digito2 += -10;
        }

        return Arrays.toString(numeros).replace("[", "").replace(",", "").replace("]", "").replace(" ", "") + Digito1 + Digito2;
    }
}
