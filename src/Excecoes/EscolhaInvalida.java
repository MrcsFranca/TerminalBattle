package Excecoes;

public class EscolhaInvalida extends RuntimeException {
    int escolha;
    public EscolhaInvalida(int escolha) {
        this.escolha = escolha;
    }

    @Override
    public String toString() {
        return escolha + " nao e uma escolha valida";
    }
}
