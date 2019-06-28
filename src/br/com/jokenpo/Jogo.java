package br.com.jokenpo;

public class Jogo {
    private Adversario adversario;
    private Computador computador;
    private int adversarioScore;
    private int computadorScore;
    private int numeroDeJogadas;

    public Jogo() {
        adversario = new Adversario();
        computador = new Computador();
        adversarioScore = 0;
        computadorScore = 0;
        numeroDeJogadas = 0;
    }

    public void iniciar() {
        try {
            System.out.println("PEDRA, PAPEL, TESOURA !");

            Escolha adversarioEscolha = adversario.getJogada();
            Escolha computadorEscolha = computador.getJogada();

            System.out.println("\nVocê escolheu " + adversarioEscolha);
            System.out.println("O computador escolheu " + computadorEscolha);

            verificarGanhador(adversarioEscolha, computadorEscolha);

            incrementarJogadas();

            jogarOuFinalizar();
        } catch (Exception ex) {
            System.out.println("Erro durante a leitura, tente novamente!");
            iniciar();
        }
    }

    private void jogarOuFinalizar() {
        if (adversario.jogarNovamente()) {
            System.out.println();
            iniciar();
        } else {
            imprimirResultados();
        }
    }

    private void incrementarJogadas() {
        numeroDeJogadas++;
    }

    private void verificarGanhador(Escolha adversarioEscolha, Escolha computadorEscolha) {
        int resultado = adversarioEscolha.compareEscolhas(computadorEscolha);

        switch (resultado) {
            case 0:
                System.out.println("Empate");
                break;
            case 1:
                System.out.println(adversarioEscolha + " ganha de " + computadorEscolha + ". Você venceu !");
                adversarioScore++;
                break;
            case -1:
                System.out.println(computadorEscolha + " ganha de " + adversarioEscolha + ". Você perdeu !");
                computadorScore++;
                break;
        }
    }

    private void imprimirResultados() {
        int vitorias = adversarioScore;
        int derrotas = computadorScore;
        int empates = numeroDeJogadas - adversarioScore - computadorScore;
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
