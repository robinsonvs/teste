package br.com.jokenpo;

public class Jogo {
    private Usuario usuario;
    private Computador computador;
    private int usuarioScore;
    private int computadorScore;
    private int numeroDeJogadas;

    public Jogo() {
        usuario = new Usuario();
        computador = new Computador();
        usuarioScore = 0;
        computadorScore = 0;
        numeroDeJogadas = 0;
    }

    public void iniciar() {
        try {
            System.out.println("PEDRA, PAPEL, TESOURA !");

            Escolha usuarioEscolha = usuario.getJogada();
            Escolha computadorEscolha = computador.getJogada();

            System.out.println("\nVocê escolheu " + usuarioEscolha);
            System.out.println("O computador escolheu " + computadorEscolha);

            verificarGanhador(usuarioEscolha, computadorEscolha);

            incrementarJogadas();

            jogarOuFinalizar();
        } catch (Exception ex) {
            System.out.println("Erro durante a leitura, tente novamente!");
            iniciar();
        }
    }

    private void jogarOuFinalizar() {
        if (usuario.jogarNovamente()) {
            System.out.println();
            iniciar();
        } else {
            imprimirResultados();
        }
    }

    private void incrementarJogadas() {
        numeroDeJogadas++;
    }

    private void verificarGanhador(Escolha usuarioEscolha, Escolha computadorEscolha) {
        int resultado = usuarioEscolha.compareEscolhas(computadorEscolha);

        switch (resultado) {
            case 0:
                System.out.println("Empate");
                break;
            case 1:
                System.out.println(usuarioEscolha + " ganha de " + computadorEscolha + ". Você venceu !");
                usuarioScore++;
                break;
            case -1:
                System.out.println(computadorEscolha + " ganha de " + usuarioEscolha + ". Você perdeu !");
                computadorScore++;
                break;
        }
    }

    private void imprimirResultados() {
        int vitorias = usuarioScore;
        int derrotas = computadorScore;
        int empates = numeroDeJogadas - usuarioScore - computadorScore;
        double percentagemVitorias = (vitorias + ((double) empates) / 2) / numeroDeJogadas;

        System.out.print("+");
        imprimirTracos(95);
        System.out.println("+");

        System.out.printf("|   %6s    |   %6s   |   %6s   |   %12s   |    %14s    |\n",
                "VITÓRIAS", "DERROTAS", "EMPATES", "JOGOS REALIZADOS", "PORCENTAGEM VITÓRIA");

        System.out.print("|");
        imprimirTracos(10);
        System.out.print("+");
        imprimirTracos(10);
        System.out.print("+");
        imprimirTracos(10);
        System.out.print("+");
        imprimirTracos(16);
        System.out.print("+");
        imprimirTracos(38);
        System.out.println("|");

        System.out.printf("|   %6d    |    %6d    |    %6d    |    %12d    |   %14.2f%%  |\n",
                vitorias, derrotas, empates, numeroDeJogadas, percentagemVitorias * 100);

        System.out.print("+");
        imprimirTracos(95);
        System.out.println("+");


    }

    private void imprimirTracos(int numeroDeTracos) {
        for (int i = 0; i < numeroDeTracos; i++) {
            System.out.print("-");
        }
    }

}
