import java.util.*;
public class CadastroEquipamento
{
    private Equipamento[] contas = new Equipamento[50];
    private int total = 0;
    Scanner entrada = new Scanner(System.in);
    
    public void cadastrarEquipamento() 
    {// cria nova conta no vetor
        System.out.print("\f");
        if (total < contas.length) {
            System.out.print("Digite o nome do equipamento: ");
            String nome = entrada.next();
            System.out.print("Digite qual é a mobilidade do equipamento: ");
            String mobilidade = entrada.next();
            System.out.print("Digite qual é a qualidade do equipamento: ");
            String qualidade = entrada.next();
            System.out.print("Digite o número do equipamento: ");
            int número = entrada.nextInt();
            contas[total] = new Equipamento(número, mobilidade, qualidade, nome); // cria nova conta no vetor
            System.out.println("\fEquipamento cadastrado com sucesso!");
            total++; // incrementa a quantidade de contas
        } else {
            System.out.println("\fLimite de contas atingido.\n");
        }
    }
    
    public boolean removerDoVetor(String nome){
        int posicao = pesquisarPosicao(nome);                
        if(posicao == -1) { return false; }
        for(int i=posicao; i<total-1; i++){
            contas[i] = contas[i+1];
        }
        contas[total-1] = null;      
        total--;        
        return true; 
    }
    
    public void removerEquipamento(){
        System.out.print("\fPara remover o equipamento dos registros, insira o nome abaixo");
        System.out.println("\n\nNome: ");
        String nome = entrada.next();
        if(removerDoVetor(nome)){
            System.out.print("\fEQUIPAMENTO EXCLUÍDO COM SUCESSO\n");           
        } else {
            System.out.print("\fERRO AO EFETUAR EXCLUSÃO: VERIFIQUE SE O NOME INFORMADO ENCONTRA-SE CADASTRADO\n");           
        }
    }
    
    public void modificarNome(){
        System.out.print("\fPara modificar o nome do equipamento, insira o número cadastrado atual: ");
        int número = entrada.nextInt();
        Equipamento conta = buscarEquipamento(número);
        if (conta != null) {
            System.out.print("\fAgora, digite o novo nome do equipamento: ");
            String nome2 = entrada.next();
            conta.modificar(nome2);
            System.out.print("\fNOME DO EQUIPAMENTO MODIFICADO COM SUCESSO");
        } else {
            System.out.println("Equipamento nao encontrado");
        }
    }
    
    public int pesquisarPosicao(String nome){        
        for(int i=0; i<total; i++){
            if(contas[i].getNome().equalsIgnoreCase(nome)){
                return i;
            }            
        } 
        return -1;
    }
    
    public Equipamento buscarEquipamento(int número) {
        for (int i = 0; i < total; i++) {
            if (contas[i].getNúmero() == número) {
                return contas[i];
            }
        }
        return null; // retorna null se nao encontrar
    }
    
    public void mostrarEquipamentos() {
        System.out.print("\f");
        for (int i = 0; i < total; i++) {
            System.out.println(contas[i]); // usa toString da classe Conta
        }
    }
}
