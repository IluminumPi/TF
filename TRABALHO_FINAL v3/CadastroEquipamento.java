 

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
            System.out.println("\fLimite de contas atingido.");
        }
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
