public class Equipamento
{
    private String nome;
    private String mobilidade;
    private String qualidade;
    private int número;
    
    public Equipamento(int p, String w, String r, String a){
        número = p;
        mobilidade = w;
        qualidade = r;
        nome = a;
       this.qualidade = qualidade; 
       this.mobilidade = mobilidade;
       this.nome = nome;
    }
    
    public void modificar(String nome2){
           nome = nome2;
    }
    
    public String getNome(){ return nome;}
    public int getNúmero(){ return número; }
    public String getMobilidade(){ return mobilidade; }
    public String getQualidade(){ return qualidade; }
    
    
    public String toString(){
        return " Nome: " + nome + "\t Número: " + número + "\t Qualidade: " + qualidade + "\t Mobilidade: " + mobilidade;
    }
}
