import java.util.Scanner;

public class CadastroCliente {
    private Cliente[] clientes = new Cliente[10];
    private int total = 0;
    private Scanner entrada = new Scanner(System.in);

    // Adiciona cliente (com equipamento alugado passado como parâmetro)
    public void adicionaCliente(Equipamento equipamentoAlugado) {
        if (total >= clientes.length) {
            System.out.println("\fLimite de clientes atingido.");
            return;
        }

        System.out.print("\fDigite a matrícula do cliente: ");
        int matricula = entrada.nextInt();
        entrada.nextLine(); // limpa o buffer
        System.out.print("\fDigite o nome do cliente: ");
        String nome = entrada.nextLine();
        System.out.print("\fDigite o nome da academia: ");
        String academia = entrada.nextLine();

        // Verifica se há estoque do equipamento
        if (equipamentoAlugado.retirar()) {
            clientes[total++] = new Cliente(matricula, nome, academia, equipamentoAlugado);
            System.out.println("\fCliente cadastrado com sucesso e equipamento alugado!");
        } else {
            System.out.println("\fNão há unidades disponíveis para este equipamento.");
        }
    }

    // Busca cliente pelo nome
    public Cliente buscaClientePeloNome(String nome) {
        for (int i = 0; i < total; i++) {
            if (clientes[i].getNome().equalsIgnoreCase(nome)) {
                return clientes[i];
            }
        }
        return null;
    }

    // Mostra todos os clientes
    public void mostraClientes() {
        if (total == 0) {
            System.out.println("\fNenhum cliente cadastrado.");
            return;
        }

        System.out.println("\fLista de Clientes:");
        for (int i = 0; i < total; i++) {
            System.out.println(clientes[i]);
        }
    }
}

