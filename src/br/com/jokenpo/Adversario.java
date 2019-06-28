package br.com.jokenpo;

import java.util.Scanner;

public class Adversario {
    private Scanner scanner;

    public Adversario() {
        scanner = new Scanner(System.in);
    }

    public Escolha getJogada() {
        System.out.println("Pedra, Papel ou Tesoura ?");

        String adversarioInput = scanner.nextLine();
        adversarioInput = adversarioInput.toUpperCase();
        char primeiraLetra = adversarioInput.charAt(0);
        char segunndaLetra = adversarioInput.charAt(1);

        if ((primeiraLetra == 'P' && (segunndaLetra == 'E' || segunndaLetra == 'A')) || primeiraLetra == 'T') {
            switch (primeiraLetra) {
                case 'P': return segunndaLetra == 'E' ? Escolha.PEDRA : Escolha.PAPEL;
                case 'T': return Escolha.TESOURA;
            }
        }

        return getJogada();
    }

    public boolean jogarNovamente() {
        System.out.println("Jogar novamente ?");
        String adversarioInput = scanner.nextLine();
        adversarioInput = adversarioInput.toUpperCase();
        return adversarioInput.charAt(0) == 'S';
    }
}
