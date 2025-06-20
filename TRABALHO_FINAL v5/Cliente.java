public class Cliente
{
    private String nome;
    private int idade;
    private int número;
    private int tempo;
    
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
    
    public void modificar(String nome2){
           nome = nome2;
    }
    
    public void aluguel(int dias){
           tempo = tempo + dias;
    }
    
    public String getNome(){ return nome;}
    public int getIdade(){ return idade; }
    public int getNúmero(){ return número; }
    
    public void setNome(){ String nome;}
    public void setIdade(){ int idade; }
    public void setNúmero(){ int número; }
    
    public String toString(){
        return " Nome: " + nome + "\t Idade: " + idade + "\t Número: " + número + "\t Tempo restante de aluguel: " + tempo + " dias";
    }
}
