package br.com.jokenpo;

import java.util.Scanner;

public class Usuario {
    private Scanner scanner;

    public Usuario() {
        scanner = new Scanner(System.in);
    }

    public Movimento getMovimento() {
        System.out.println("Pedra, Papel ou Tesoura ?");

        String usuarioInput = scanner.nextLine();
        usuarioInput = usuarioInput.toUpperCase();
        char primeiraLetra = usuarioInput.charAt(0);
        char segunndaLetra = usuarioInput.charAt(1);

        if (primeiraLetra == 'P' && (segunndaLetra == 'E' || segunndaLetra == 'A') || primeiraLetra == 'T') {
            switch (primeiraLetra) {
                case 'P': return segunndaLetra == 'E' ? Movimento.PEDRA : Movimento.TESOURA;
                case 'T': return Movimento.TESOURA;
            }
        }

        return getMovimento();
    }

    public boolean jogarNovamente() {
        System.out.println("Jogar novamente ?");
        String usuarioInput = scanner.nextLine();
        usuarioInput = usuarioInput.toUpperCase();
        return usuarioInput.charAt(0) == 'S';
    }
}
