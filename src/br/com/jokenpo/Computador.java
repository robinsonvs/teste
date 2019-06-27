package br.com.jokenpo;

import java.util.Random;

public class Computador {
    public Movimento getMovimento() {
        Movimento[] escolhas = Movimento.values();
        Random random = new Random();
        int index = random.nextInt(escolhas.length);
        return escolhas[index];
    }
}
