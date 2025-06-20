 

import java.util.*;
public class Aluguel
{
    public static void main(String [] args)
    {
        Scanner entrada = new Scanner(System.in);
        CadastroCliente cadastro = new CadastroCliente();
        CadastroEquipamento equip = new CadastroEquipamento();
        System.out.print("\f");
        int opcao;
        do{
            System.out.println("\n===== MENU XFit Equipamentos =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Mostrar todos os clientes");
            System.out.println("3 - Cadastrar equipamento");
            System.out.println("4 - Mostrar todos equipamentos");
            System.out.println("5 - Fechar conta do cliente");
            System.out.println("6 - Remover equipamento");
            System.out.println("7 - Alterar cadastro do equipamento");
            System.out.println("8 - Alterar cadastro do cliente");
            System.out.println("9 - Consultar período restante de aluguel");
            System.out.println("10 - Ajuda");
            System.out.println("11 - Sair");
            System.out.println("====================================");
            System.out.println("\nEscolha uma opção: ");
            opcao = entrada.nextInt();
        
            switch(opcao) {
                case 1:
                    cadastro.cadastrarConta();
                    break;
                case 2:
                    cadastro.mostrarContas();
                    break;
                case 3:
                    equip.cadastrarEquipamento();
                    break;
                case 4:
                    equip.mostrarEquipamentos();
                    break;
                case 5:
                    //cadastro.transferir();
                    break;
                case 6:
                    //cadastro.mostrarContas();
                    break;
                case 7:
                    //cadastro.mostrarContas();
                    break;
                case 8:
                    //cadastro.mostrarContas();
                    break;
                case 9:
                    //equip.mostrarEquipamentos();
                    break;
                case 10:
                    cadastro.menu();
                    break;
                case 11:
                    System.out.println("\fEncerrando o programa...\nObrigado por usar!");
                    break;
                default:
                    System.out.println("\fOpção inválida!\n");
            }
        }while(opcao != 11);
    }
}
