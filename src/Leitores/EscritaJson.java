package Leitores;

import Personagem.*;
import Habilidades.*;
import Habilidades.Buff.HabilidadeBuffDebuff;
import Leitores.RuntimeTypeAdapterFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Habilidades.Habilidade;
import Personagem.*;

import java.util.ArrayList;
import java.util.List;

public class EscritaJson {
    private static final String path = "src/Arquivos/Personagem.json";

    public static void SalvaPersonagem(List<Personagem> personas, Personagem player){
        List<PersonagemSave> aux = criaListaSave(personas, player);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try(FileWriter writter = new FileWriter(path)){
            gson.toJson(aux, writter);
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static List<PersonagemSave> criaListaSave(List<Personagem> personas, Personagem player){
        List<PersonagemSave> DadosParaSalvar = new ArrayList<>();

        for(Personagem p: personas){
            ArrayList<String> saves = ConverteHabs(p.getHabilidades());
            PersonagemSave aux = new PersonagemSave(p.getNome(), p.getVidaMax(),p.getDefesa(), p.getAgilidade(), p.getQuantAtaques(), p.getVidaAtual(), p.getMultDano(), p.getMultAgil(), p.getMultDef(), saves ,p.getTipo(), p.isBoolBuffCarac(), p.isBoolBuffDano());
            DadosParaSalvar.add(aux);
        }

        DadosParaSalvar.add(PlayerToPersSave(player));

        return DadosParaSalvar;
    }

    public static ArrayList<String> ConverteHabs(List<Habilidade> habilidades){
        ArrayList<String> saida = new ArrayList<>();
        for(Habilidade h: habilidades){
            saida.add(h.getNome());
        }
        return saida;
    }

    public static PersonagemSave PlayerToPersSave(Personagem p){
        ArrayList<String> saves = ConverteHabs(p.getHabilidades());
        PersonagemSave aux = new PersonagemSave(p.getNome() + " (Sombra)", p.getVidaMax(),p.getDefesa(), p.getAgilidade(), p.getQuantAtaques(), p.getVidaMax()*1.0, p.getMultDano(), p.getMultAgil(), p.getMultDef(), saves ,p.getTipo(), p.isBoolBuffCarac(), p.isBoolBuffDano());
        return aux;
    }
}
