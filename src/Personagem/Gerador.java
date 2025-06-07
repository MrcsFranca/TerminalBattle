package Personagem;

import Habilidades.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerador {
    public Personagem geraPlayer() {
        String nome;
        int qntdHab, defesa, agilidade;

        Scanner scanner = new Scanner(System.in);
        nome = scanner.nextLine();

        ArrayList<NomeHabilidade> habilidade = new ArrayList<NomeHabilidade>();
        habilidade.add(NomeHabilidade.Fireball);
        habilidade.add(NomeHabilidade.Esquiva);

        return new Player(nome, 50, 50, 2, 10, 5, habilidade, TipoHabilidade.fogo, 0);

    }
    
    public Personagem geraNPC() {
        ArrayList<NomeHabilidade> habilidade = new ArrayList<NomeHabilidade>();
        habilidade.add(NomeHabilidade.Fireball);
        habilidade.add(NomeHabilidade.Esquiva);

        return new Npc("NPC", 100, 100, 3 , 10, 10, habilidade, TipoHabilidade.agua);
    }
}
