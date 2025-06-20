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
    
    public int menu(){
        Scanner in = new Scanner(System.in);
        System.out.println("\f\n===== MENU Ajuda =====");
        System.out.println("1 - Quem somos?");
        System.out.println("2 - Contatos oficiais");
        System.out.println("3 - Deixe um feedback");
        System.out.println("4 - Nosso website");
        System.out.println("5 - Sair");
        System.out.println("==========================");
        System.out.println("\nEscolha uma opção: ");
        int op = in.nextInt();
        switch(op) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                System.out.println("\fVoltando ao menu inicial...");
                break;
        }
        return op;
    }
}
