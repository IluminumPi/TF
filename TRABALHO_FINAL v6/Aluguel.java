import java.util.Scanner;

public class Aluguel {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        CadastroCliente cadastroCliente = new CadastroCliente();
        CadastroEquipamento cadastroEquipamento = new CadastroEquipamento();
        System.out.print("\f");
        int opcao;

        do {
            System.out.println("\n--- MENU XFit Equipamentos ---");
            System.out.println("1 – Incluir Cliente");
            System.out.println("2 – Mostrar clientes cadastrados");
            System.out.println("3 – Pesquisar cliente por nome");
            System.out.println("4 – Incluir equipamento");
            System.out.println("5 – Mostrar equipamentos");
            System.out.println("6 – Pesquisar equipamento por nome");
            System.out.println("7 – Retirar equipamento");
            System.out.println("8 – Devolver equipamento");
            System.out.println("9 – Mostrar quantidade de equipamentos");
            System.out.println("10 – Pré-aluguel de equipamentos");
            System.out.println("11 – Sair");
            System.out.println("-------------------------------");
            System.out.print("\nEscolha uma opção: ");
            opcao = entrada.nextInt();
            entrada.nextLine(); // limpar buffer

            switch (opcao) {
                case 1: // Incluir Cliente
                    System.out.print("\fDigite o nome do equipamento a ser alugado: ");
                    String nomeEquip = entrada.nextLine();
                    Equipamento equipamento = cadastroEquipamento.buscaEquipamentoPeloNome(nomeEquip);
                    if (equipamento != null) {
                        cadastroCliente.adicionaCliente(equipamento);
                    } else {
                        System.out.println("\fEquipamento não encontrado.");
                    }
                    break;

                case 2: // Mostrar clientes
                    cadastroCliente.mostraClientes();
                    break;

                case 3: // Pesquisar cliente por nome
                    System.out.print("\fDigite o nome do cliente: ");
                    String nomeCli = entrada.nextLine();
                    Cliente cliente = cadastroCliente.buscaClientePeloNome(nomeCli);
                    if (cliente != null) {
                        System.out.println("\fCliente encontrado: " + cliente);
                    } else {
                        System.out.println("\fCliente não encontrado.");
                    }
                    break;

                case 4: // Incluir equipamento
                    cadastroEquipamento.adicionaEquipamento();
                    break;

                case 5: // Mostrar equipamentos
                    cadastroEquipamento.mostraEquipamentos();
                    break;

                case 6: // Pesquisar equipamento por nome
                    System.out.print("\fDigite o nome do equipamento: ");
                    String nomeEquipamento = entrada.nextLine();
                    Equipamento eq = cadastroEquipamento.buscaEquipamentoPeloNome(nomeEquipamento);
                    if (eq != null) {
                        System.out.println("\fEquipamento encontrado: " + eq);
                    } else {
                        System.out.println("\fEquipamento não encontrado.");
                    }
                    break;

                case 7: // Retirar equipamento
                    System.out.print("\fDigite o nome do equipamento para retirada: ");
                    String retira = entrada.nextLine();
                    Equipamento eqRetira = cadastroEquipamento.buscaEquipamentoPeloNome(retira);
                    if (eqRetira != null && eqRetira.retirar()) {
                        System.out.println("\fEquipamento retirado com sucesso.");
                    } else {
                        System.out.println("\fEquipamento não disponível.");
                    }
                    break;

                case 8: // Devolver equipamento
                    System.out.print("\fDigite o nome do equipamento para devolução: ");
                    String devolve = entrada.nextLine();
                    Equipamento eqDevolve = cadastroEquipamento.buscaEquipamentoPeloNome(devolve);
                    if (eqDevolve != null) {
                        eqDevolve.devolver();
                        System.out.println("\fEquipamento devolvido com sucesso.");
                    } else {
                        System.out.println("\fEquipamento não encontrado.");
                    }
                    break;

                case 9: // Mostrar total de equipamentos disponíveis
                    int totalDisponivel = 0;
                    for (int i = 0; i < 10; i++) {
                        Equipamento e = cadastroEquipamento.buscaPorIndice(i);
                        if (e != null) {
                            totalDisponivel += e.getQuantidadeDisponivel();
                        }
                    }
                    System.out.println("\fTotal de equipamentos disponíveis: " + totalDisponivel);
                    break;
                
                case 10:
                    cadastroEquipamento.preAlugarEquipamento();
                    break;
                    
                case 11:
                    System.out.println("\fSaindo do sistema...");
                    break;

                default:
                    System.out.println("\fOpção inválida. Tente novamente.");
            }
        } while (opcao != 11);

        entrada.close();
    }
}

