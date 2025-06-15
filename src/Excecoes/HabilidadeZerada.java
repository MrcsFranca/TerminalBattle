package Excecoes;

import Habilidades.NomeHabilidadeDano;

public class HabilidadeZerada extends RuntimeException {
    @Override
    public String toString() {
        return "Voce não tem mais usos dessa habilidade";
    }
}
