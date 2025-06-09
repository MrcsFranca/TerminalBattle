package Personagem;

import Habilidades.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Gerador {
    Random random = new Random();
    private double valorCura = 5, valorDano = 10;
    private int valorVida = 10, valorDefesa = 10, valorAgilidade = 2, auxVida = 0, auxDefesa = 0, auxAgilidade = 0, quantHab = 0;

    public Personagem geraPlayer() {
        String nome;
        int qntdHab, defesa, agilidade;

        System.out.print("Entre com o nome do jogador: ");
        Scanner scanner = new Scanner(System.in);
        nome = scanner.nextLine();

        Habilidade hab = new HabilidadeDanoCura(10, 1, NomeHabilidadeDano.Fireball, false, TipoHabilidade.fogo, 5);
        Habilidade hab1 = new HabilidadeDanoCura(5, 1, NomeHabilidadeCura.WaterHeal, true, TipoHabilidade.agua, 5);

        ArrayList<Habilidade> habilidade = new ArrayList<Habilidade>();
        habilidade.add(hab);
        habilidade.add(hab1);

        return new Player(nome, 50, 50, 2, 10, 5, habilidade, TipoHabilidade.fogo, 0);

    }
    
    public Personagem geraNPC() {
        double mult = 0;
        boolean isCura;

        ArrayList<Habilidade> habilidade = new ArrayList<>();
        Habilidade hab;
        quantHab = random.nextInt(4) + 1;
        do {
            isCura = random.nextBoolean();
            NomeHabilidadeDano[] valoresDano = NomeHabilidadeDano.values();
            NomeHabilidadeDano habilidadeDanoAleatoria = valoresDano[random.nextInt(valoresDano.length)];
            NomeHabilidadeCura[] valoresCura = NomeHabilidadeCura.values();
            NomeHabilidadeCura habilidadeCuraAleatoria = valoresCura[random.nextInt(valoresCura.length)];
            TipoHabilidade[] valoresTipo = TipoHabilidade.values();
            TipoHabilidade tipoAleatorio = valoresTipo[random.nextInt(valoresTipo.length)];
            if(isCura) {
                mult = random.nextDouble(0.4);
                valorCura += (valorCura * mult);
                hab = new HabilidadeDanoCura(valorCura, 1, habilidadeCuraAleatoria, true, tipoAleatorio, 5);
            } else {
                mult = random.nextDouble(0.2);
                valorDano += (valorDano * mult);
                hab = new HabilidadeDanoCura(valorDano, 1, habilidadeDanoAleatoria, false, tipoAleatorio, 5);
            }
            habilidade.add(hab);
            quantHab--;
        } while(quantHab > 0);

        mult = random.nextDouble(1.6);
        valorVida += (int) (auxVida * mult);
        auxVida = valorVida;
        mult = random.nextDouble(0.5);
        valorDefesa += (int) (auxDefesa * mult);
        auxDefesa = valorDefesa;
        mult = random.nextDouble(1.3);
        valorAgilidade += (int) (auxAgilidade * mult);
        auxAgilidade = valorAgilidade;
        TipoHabilidade[] valoresTipo = TipoHabilidade.values();
        TipoHabilidade tipoAleatorio = valoresTipo[random.nextInt(valoresTipo.length)];
        return new Npc("NPC", valorVida, valorVida, quantHab, valorDefesa, valorAgilidade, habilidade, tipoAleatorio);
    }
}
