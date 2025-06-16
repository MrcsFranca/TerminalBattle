package Excecoes;

public class EscolhaInvalida extends RuntimeException {
    Object escolha;
    public EscolhaInvalida(Object escolha) {
        this.escolha = escolha;
    }

    @Override
    public String toString() {
        return escolha + " nao e uma escolha valida";
    }
}
