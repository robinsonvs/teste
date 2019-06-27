package br.com.jokenpo;

public enum Movimento {
    PEDRA, PAPEL, TESOURA;

    public int compareMovimentos(Movimento movimento) {
        if (this == movimento) return 0;

        switch (this) {
            case PEDRA: return (movimento == TESOURA ? 1 : -1);
            case PAPEL: return (movimento == PEDRA ? 1 : -1);
            case TESOURA: return (movimento == PAPEL ? 1 : -1);
        }

        return 0;
    }
}
