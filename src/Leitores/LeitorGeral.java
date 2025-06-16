package Leitores;

import Excecoes.ArquivoVazio;
import Excecoes.EscolhaInvalida;
import Excecoes.PersonagemSemHab;
import Habilidades.Buff.HabilidadeBuffDebuff;
import Habilidades.Habilidade;
import Habilidades.HabilidadeDanoCura;
import Personagem.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.*;

public class LeitorGeral<T> {
    static Map<String, Habilidade> catalogo = new HashMap<>();
    static boolean catalogoCarregado = false;

    public List<T> Carrega(String Arquivo, Gson gson, Type tipoDado){
        List<T> saida = new ArrayList<>();

        try(FileReader reader = new FileReader(Arquivo)){
            saida = gson.fromJson(reader, tipoDado);
            if(saida.isEmpty()) throw new ArquivoVazio();
        }
        catch (ArquivoVazio e){
            e.toString();
        }
        catch (IOException e){
            System.out.println("Erro na leitura de arquivos");
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Erro inesperado");
            e.printStackTrace();
        }
        return saida;
    }

    public static Gson CriaLeitorHab(){
        RuntimeTypeAdapterFactory<Habilidade> typeFactory = RuntimeTypeAdapterFactory.of(Habilidade.class, "tipoHab")
                .registerSubtype(HabilidadeDanoCura.class, "DanoCura")
                .registerSubtype(HabilidadeBuffDebuff.class,"BuffDebuff");

        return new GsonBuilder().registerTypeAdapterFactory(typeFactory).setPrettyPrinting().create();
    }

    public static void criaCatalogo(List<Habilidade> habJson){
        if (catalogoCarregado) return;
        for(Habilidade h: habJson){
            catalogo.put(h.getNome().toString(), h);
        }
        catalogoCarregado = true;
    }

    public static Habilidade getHabFromJson(String nome){
        return catalogo.get(nome);
    }

    public static List<Personagem> PersSaveToPers(List<PersonagemSave> personagemAux){
        List<Personagem> PersonagensPossiveis = new ArrayList<>();
        for(PersonagemSave ps: personagemAux){
            ArrayList<Habilidade> habilidadesReais = new ArrayList<>();

            for(String nomeHab: ps.getHabilidades()){
                Habilidade hab = getHabFromJson(nomeHab);
                if(hab != null){
                    habilidadesReais.add(hab);
                }
                else{
                    throw new EscolhaInvalida(nomeHab);
                }
            }
            Personagem aux = new Npc(ps.getNome(), ps.getVidaMax(), ps.getDefesa(), ps.getAgilidade(), ps.getQuantAtaques(), ps.getVidaAtual(), ps.getMultDano(), ps.getMultAgil(), ps.getMultDef(), habilidadesReais, ps.getTipo(), ps.isBoolBuffCarac(), ps.isBoolBuffDano());
            if(aux.getHabilidades().isEmpty()){
                throw new PersonagemSemHab();
            }
            PersonagensPossiveis.add(aux);
        }
        return PersonagensPossiveis;
    }

    public static List<Personagem> PersonagensGerais(){
        LeitorGeral<Habilidade> Habs = new LeitorGeral<>();
        Gson leHabs = CriaLeitorHab();
        Type a = new TypeToken<ArrayList<Habilidade>>() {}.getType();
        List<Habilidade> habs = Habs.Carrega("src/Arquivos/Habilidades.json", leHabs, a);
        criaCatalogo(habs);

        LeitorGeral<PersonagemSave> Pers = new LeitorGeral<>();
        Gson lePers = new Gson();
        Type b = new TypeToken<ArrayList<PersonagemSave>>() {}.getType();
        List<PersonagemSave> personasAux = Pers.Carrega("src/Arquivos/Personagem.json", lePers, b);

        List<Personagem> personas = PersSaveToPers(personasAux);

        return personas;
    }

}
