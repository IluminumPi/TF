public class CadastroEquipamento
{
    private Carro [] vetor;
    private int index;

    public CadastroCarros(int tamanho){
        vetor = new Carro[tamanho];
        index = 0;
    }

    public boolean adicionaNoVetor(Carro c){
        if(index >= vetor.length){
            return false;
        } else {
            vetor[index] = c;
            index++;
            return true;
        }
    }

    //pesquisar no vetor
    public Carro pesquisaNoVetor(String placa){        
        int i = pesquisarPosicao(placa);
        if(i >= 0){
            return vetor[i];
        } else {  
            return null;
        }
    }

    //pesquisar no vetor
    public int pesquisarPosicao(String placa){        
        for(int i=0; i<index; i++){
            if(vetor[i].getPlaca().equalsIgnoreCase(placa)){
                return i;
            }            
        } 
        return -1;
    }

    //remover do vetor
    public boolean removeDoVetor(String placa){
        int posicao = pesquisarPosicao(placa);                
        if(posicao == -1) { return false; }
        for(int i=posicao; i<index-1; i++){
            vetor[i] = vetor[i+1];
        }
        vetor[index-1] = null;      
        index--;        
        return true; 
    }

    public void imprimeVetor(){
        for(int i=0; i<index; i++){
            System.out.println("\nCADASTRO " + i + ":\n");            
            System.out.println(vetor[i].toString());
        }        
    }

    public Carro[] getCarro(){ return vetor; }

    public int contaFabricadosAzuis(Carro [] v){
        int conta = 0;        
        for(int i=0; i<v.length; i++){
            if(v[i].getCor().equalsIgnoreCase("azul")){                
                conta++;
            }
        }
        return conta;
    }

    public Carro[] fabricadosAzuis(Carro [] v){
        int tamanho = contaFabricadosAzuis(v);        
        Carro [] resultado = new Carro[tamanho];
        int proxPosicao = 0;        
        for(int i=0; i<v.length; i++){
            if(v[i].getCor().equalsIgnoreCase("azul")){
                resultado[proxPosicao] = v[i];
                proxPosicao++;
            }
        }
        return resultado;     
    }

    public int contaFabricadosAPartirDe2000(Carro [] v){
        int conta = 0;        
        for(int i=0; i<v.length; i++){
            if(v[i].getAno() >= 2000){                
                conta++;
            }
        }
        return conta;
    }

    public Carro[] fabricadosAPartir2000_2(Carro [] v){
        int tamanho = contaFabricadosAPartirDe2000(v);        
        Carro [] resultado = new Carro[tamanho];
        int proxPosicao = 0;        
        for(int i=0; i<v.length; i++){
            if(v[i].getAno() >= 2000){
                resultado[proxPosicao] = v[i];
                proxPosicao++;
            }
        }
        return resultado;     
    }

    //Solução criando 2 vetores
    public Carro[] fabricadosAPartir2000(Carro [] v){
        Carro [] resultado = new Carro[v.length];
        int proxPosicao = 0;        
        for(int i=0; i<v.length; i++){
            if(v[i].getAno() >= 2000){
                resultado[proxPosicao] = v[i];
                proxPosicao++;
            }
        }
        //Cria um novo vetor com o tamanho correto        
        Carro[] resultadoL = new Carro[proxPosicao-1];
        for(int i=0; i<resultadoL.length; i++){
            resultadoL[i] = resultado[i];
        }
        return resultadoL;        
    }

}