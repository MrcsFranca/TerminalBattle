package Personagem;

import Habilidades.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Gerador {
    Random random = new Random();
    double mult = 0, valorCura = 5, valorDano = 10;

    public Personagem geraPlayer() {
        String nome;
        int qntdHab, defesa, agilidade;

        System.out.print("Entre com o nome do jogador: ");
        Scanner scanner = new Scanner(System.in);
        nome = scanner.nextLine();

        Habilidade hab = new HabilidadeDanoCura(10, 1, NomeHabilidadeDano.Fireball, false, TipoHabilidade.fogo);
        Habilidade hab1 = new HabilidadeDanoCura(5, 1, NomeHabilidadeCura.WaterHeal, true, TipoHabilidade.agua);

        ArrayList<Habilidade> habilidade = new ArrayList<Habilidade>();
        habilidade.add(hab);
        habilidade.add(hab1);

        return new Player(nome, 50, 50, 2, 10, 5, habilidade, TipoHabilidade.fogo, 0);

    }
    
    public Personagem geraNPC() {
        boolean isCura;
        isCura = random.nextBoolean();
        ArrayList<Habilidade> habilidade = new ArrayList<>();
        Habilidade hab;

        NomeHabilidadeDano[] valoresDano = NomeHabilidadeDano.values();
        NomeHabilidadeDano habilidadeDanoAleatoria = valoresDano[random.nextInt(valoresDano.length)];
        NomeHabilidadeCura[] valoresCura = NomeHabilidadeCura.values();
        NomeHabilidadeCura habilidadeCuraAleatoria = valoresCura[random.nextInt(valoresCura.length)];
        if(isCura) {
            mult = random.nextDouble(0.5);
            valorCura += (valorCura * mult);
            hab = new HabilidadeDanoCura(valorCura, 1, habilidadeCuraAleatoria, true, TipoHabilidade.fogo);
        } else {
            mult = random.nextDouble(1.5);
            valorDano += (valorDano * mult);
            hab = new HabilidadeDanoCura(valorDano, 1, habilidadeDanoAleatoria, false, TipoHabilidade.agua);
        }
        habilidade.add(hab);

        return new Npc("NPC", 10, 10, 3 , 10, 10, habilidade, TipoHabilidade.agua);
    }
}
