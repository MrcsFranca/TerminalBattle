package Habilidades;

public abstract class HabilidadeDanoCura implements Habilidade {
    private String nome;
    private int valor;
    private int turnos;
    private boolean isCura;
    private TipoHabilidade elemento;

    public HabilidadeDanoCura(int valor, int turnos, String nome, boolean isCura, TipoHabilidade elemento ){
        this.valor = valor;
        this.turnos = turnos;
        this.nome = nome;
        this.isCura = isCura;
        this.elemento = elemento;
    }

    public int getDano(){
        return valor;
    }
    public int getTurnos(){
        return turnos;
    }
    public void setTurnos(int t){
        this.turnos = t;
    }
    public TipoHabilidade getElemento(){return elemento;}
    @Override
    public void usaHab(Personagem alvo, float adicional) {
        if(!isCura) {
            alvo.setVidaAtual(alvo.getVidaAtual() - (valor + adicional));
        }
        else{
            alvo.setVidaAtual(alvo.getVidaAtual() + valor + adicional);

        }
    }

    @Override
    public void exibe(Personagem alvo) {
        System.out.println("Usando " + nome + " em " + alvo.getNome());
    }
}
