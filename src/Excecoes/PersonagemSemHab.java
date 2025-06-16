package Excecoes;

public class PersonagemSemHab extends RuntimeException {
    @Override
    public String toString() {
        return "O Personagem nao tem habilidades";
    }
}
