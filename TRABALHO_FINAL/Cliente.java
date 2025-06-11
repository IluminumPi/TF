
/**
 * Escreva uma descrição da classe Cliente aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cliente
{
    private String nome;
    private int idade;
    private int número;
    
    Cliente(int n, int x, String y){
        número = n;
        idade = x;
        nome = y;
    }
    
    public Cliente(String nome, int idade, int número){
        this.nome = nome;
        this.idade = idade;
        this.número = número;
    }
    
    public String getNome(){ return nome;}
    public int getIdade(){ return idade; }
    public int getNúmero(){ return número; }
    
    public void setNome(){ String nome;}
    public void setIdade(){ int idade; }
    public void setNúmero(){ int número; }
    
    public String toString(){
        return " Nome: " + nome + "\n Idade: " + idade + "\n Número: " + número;
    }
}
