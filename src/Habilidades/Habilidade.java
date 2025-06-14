package Habilidades;

import Personagem.Personagem;
/**
 * Interface que define os métodos basicos de uma habilidade
 */
public interface Habilidade {
     /**
      * @author Caua Monteiro
      * Método da utilização de uma habilidade
      * @param dono Quem esta usando a habilidade
      * @param alvo Quem vai receber a habilidade
      */
     void usaHab(Personagem dono, Personagem alvo);
     /**
      * Exibe as informações sobre o personagem que esta recendo a habilidade
      * @param alvo O objeto personagem em quem esta sendo exibido a habilidade sendo usada
      */
     void exibe(Personagem dono, Personagem alvo);
     /**
      * Metodo que retorna um enum que possui os nomes das habilidades
      * @return Retorna o nome da habilidade
      */
     Enum getNome();
}
