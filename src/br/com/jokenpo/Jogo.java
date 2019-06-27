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
        System.out.println("PEDRA, PAPEL ou TESOURA !");

        Movimento usuarioMovimento = usuario.getMovimento();
        Movimento computadorMovimento = computador.getMovimento();

        System.out.println("\nVocê escolheu " + usuarioMovimento);
        System.out.println("O computador escolheu " + computadorMovimento);

        int compareMovimentos = usuarioMovimento.compareMovimentos(computadorMovimento);
        switch (compareMovimentos) {
            case 0:
                System.out.println("Empate");
                break;
            case 1:
                System.out.println(usuarioMovimento + " ganha de " + computadorMovimento + ". Você venceu !");
                usuarioScore++;
                break;
            case -1:
                System.out.println(computadorMovimento + " ganha de " + usuarioMovimento + ". Você perdeu.");
                computadorScore++;
                break;
        }

        numeroDeJogadas++;

        if (usuario.jogarNovamente()) {
            System.out.println();
            iniciar();
        } else {

        }

    }

    public void imprimirResultados() {
        int
    }

}
