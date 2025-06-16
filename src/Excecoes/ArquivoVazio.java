package Excecoes;

public class ArquivoVazio extends RuntimeException {
    @Override
    public String toString() {
        return "O Arquivo que voce esta lendo esta vazio";
    }
}
