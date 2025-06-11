
/**
 * Escreva uma descrição da classe Equipamento aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Equipamento
{
    private String nome;
    private int mobilidade;
    private int estado;
    private int número;
    
    public Equipamento(int p, int w, int r, String a){
        número = p;
        mobilidade = w;
        estado = r;
        nome = a;
       this.estado = estado; 
       this.mobilidade = mobilidade;
       this.número = número;
       this.nome = nome;
    }
    
    public String getNome(){ return nome;}
    public int getNúmero(){ return número; }
    public int getMobilidade(){ return mobilidade; }
    public int getEstado(){ return estado; }
    
    
    public String toString(){
        String aux = "";
        String aux2= "";
        switch (estado) {
            case 1:
                aux = "novo";
                break;
            case 2:
                aux = "usado";
                break;
            default:
                break;
        }
        switch (mobilidade) {
            case 1:
                aux2 = "móvel";
                break;
            case 2:
                aux2 = "máquina(fixo)";
                break;
            default:
                break;
        }
        return " Nome: " + nome + "\n Número: " + número + " Estado: " + aux + "\n Mobilidade: " + aux2;
    }
}
