import java.util.*;
public class Aluguel
{
    Scanner entrada = new Scanner(System.in);
    CadastroCliente cadastro = new CadastroCliente();
    CadastroEquipamento equip = new CadastroEquipamento();
    public void main(String [] args)
    {
        System.out.print("\f");
        int opcao;
        do{
            System.out.println("\n===== MENU XFit Equipamentos =====");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Mostrar todos os clientes");
            System.out.println("3 - Cadastrar equipamento no estoque");
            System.out.println("4 - Mostrar todos equipamentos");
            System.out.println("5 - Fechar conta do cliente");
            System.out.println("6 - Remover equipamento do estoque");
            System.out.println("7 - Alterar nome cadastrado do equipamento");
            System.out.println("8 - Alterar nome cadastrado do cliente");
            System.out.println("9 - Obter ajuda e mais informações");
            System.out.println("10 - Alugar equipamento ao cliente");
            System.out.println("11 - Sair do programa");
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
                    cadastro.removerConta();
                    break;
                case 6:
                    equip.removerEquipamento();
                    break;
                case 7:
                    equip.modificarNome();
                    break;
                case 8:
                    cadastro.modificarNome();
                    break;
                case 9:
                    cadastro.menu();
                    break;
                case 10:
                    alugarEquipamento();
                    break;
                case 11:
                    System.out.println("\fEncerrando o programa...\nObrigado por usar!");
                    break;
                default:
                    System.out.println("\fOpção inválida!\n");
            }
        }while(opcao != 11);
    }
    
    private void alugarEquipamento(){
        System.out.print("\fPara alugar um equipamento, digite o número de cadastro do cliente associado: ");
        int número = entrada.nextInt();
        Cliente conta = cadastro.buscarConta(número);
        if (conta != null) {
            System.out.print("\fAgora, digite o número registrado do equipamento que será alugado: ");
            int número1 = entrada.nextInt();
            Equipamento conta1 = equip.buscarEquipamento(número);
            if (conta1 != null) {
                System.out.print("\fAgora, digite a quantidade de dias pelo qual ficará alugado: ");
                int dias = entrada.nextInt();
                conta.aluguel(dias);
                System.out.print("\fEQUIPAMENTO ALUGADO COM SUCESSO\n");
            } else {
                System.out.println("\fEquipamento não encontrado\n");
                }
        } else {
            System.out.println("\fCliente não encontrado\n");
        }
    }
}