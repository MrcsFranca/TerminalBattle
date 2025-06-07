package Habilidades;

import Personagem.Personagem;

public interface Habilidade {
     void usaHab(Personagem dono, Personagem alvo);

     void exibe(Personagem alvo);
}
