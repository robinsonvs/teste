package br.com.jokenpo;

public enum Escolha {
    PEDRA, PAPEL, TESOURA;

    public int compareEscolhas(Escolha escolha) {
        if (this == escolha) return 0;

        switch (this) {
            case PEDRA: return (escolha == TESOURA ? 1 : -1);
            case PAPEL: return (escolha == PEDRA ? 1 : -1);
            case TESOURA: return (escolha == PAPEL ? 1 : -1);
        }

        return 0;
    }
}
