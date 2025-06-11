import java.util.*;
public class CadastroCliente
{
    private Cliente[] contas = new Cliente[10];
    private int total = 0;
    Scanner entrada = new Scanner(System.in);
    
    public void cadastrarConta() 
    {// cria nova conta no vetor
        System.out.print("\f");
        if (total < contas.length) {
            System.out.print("Digite o nome do usuário: ");
            String nome = entrada.next();
            System.out.print("Digite a idade do usuário: ");
            int idade = entrada.nextInt();
            System.out.print("Digite o número da nova conta: ");
            int número = entrada.nextInt();
            contas[total] = new Cliente(número, idade, nome); // cria nova conta no vetor
            System.out.println("\fConta cadastrada com sucesso!");
            total++; // incrementa a quantidade de contas
        } else {
            System.out.println("\fLimite de contas atingido.");
        }
    }
    
    public void mostrarContas() {
        System.out.print("\f");
        for (int i = 0; i < total; i++) {
            System.out.println(contas[i]); // usa toString da classe Conta
        }
    }
}
