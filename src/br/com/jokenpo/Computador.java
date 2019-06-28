package br.com.jokenpo;

import java.util.Random;

public class Computador {
    public Escolha getJogada() {
        Escolha[] escolhas = Escolha.values();
        Random random = new Random();
        int index = random.nextInt(escolhas.length);
        return escolhas[index];
    }
}
