import java.util.Scanner;

public class CadastroEquipamento {
    private Equipamento[] equipamentos = new Equipamento[10];
    private int total = 0;
    private Scanner entrada = new Scanner(System.in);

    // Construtor que cadastra 6 equipamentos iniciais
    public CadastroEquipamento() {
        equipamentos[total++] = new Equipamento(1, "Barra Olímpica", "barra", 3, 200.0, false);
        equipamentos[total++] = new Equipamento(2, "Barra Curva", "barra", 2, 180.0, true);
        equipamentos[total++] = new Equipamento(3, "Kettlebell 12kg", "kettlebell", 4, 120.0, false);
        equipamentos[total++] = new Equipamento(4, "Kettlebell 16kg", "kettlebell", 3, 150.0, true);
        equipamentos[total++] = new Equipamento(5, "Corda Naval Média", "corda naval", 2, 250.0, false);
        equipamentos[total++] = new Equipamento(6, "Corda Naval Pesada", "corda naval", 1, 300.0, true);
    }

    // Adiciona novo equipamento, se houver espaço
    public void adicionaEquipamento() {
        if (total < equipamentos.length) {
            System.out.print("\fDigite o código do equipamento: ");
            int codigo = entrada.nextInt();
            entrada.nextLine(); // Limpa o buffer
            System.out.print("\fDigite o nome do equipamento: ");
            String nome = entrada.nextLine();
            System.out.print("\fDigite o tipo (barra, kettlebell ou corda naval): ");
            String tipo = entrada.nextLine();
            System.out.print("\fDigite a quantidade disponível: ");
            int quantidade = entrada.nextInt();
            System.out.print("\fDigite o valor base da locação: ");
            double valorBase = entrada.nextDouble();
            System.out.print("\fDeseja contratar seguro? (true/false): ");
            boolean seguro = entrada.nextBoolean();

            equipamentos[total++] = new Equipamento(codigo, nome, tipo, quantidade, valorBase, seguro);
            System.out.println("\fEquipamento cadastrado com sucesso!\n");
        } else {
            System.out.println("\fLimite máximo de equipamentos atingido.\n");
        }
    }

    // Remove equipamento pelo nome (primeira ocorrência)
    public void removeEquipamento(String nome) {
        int posicao = totalEquipamentos(nome);
        if (posicao == -1) {
            System.out.println("\fEquipamento não encontrado.\n");
            return;
        }
        for (int i = posicao; i < total - 1; i++) {
            equipamentos[i] = equipamentos[i + 1];
        }
        equipamentos[--total] = null;
        System.out.println("\fEquipamento removido com sucesso.\n");
    }

    // Busca equipamento pelo nome
    public Equipamento buscaEquipamentoPeloNome(String nome) {
        for (int i = 0; i < total; i++) {
            if (equipamentos[i].getNome().equalsIgnoreCase(nome)) {
                return equipamentos[i];
            }
        }
        return null;
    }

    // Retorna a posição do equipamento no array, se existir
    public int totalEquipamentos(String nome) {
        for (int i = 0; i < total; i++) {
            if (equipamentos[i].getNome().equalsIgnoreCase(nome)) {
                return i;
            }
        }
        return -1;
    }

    // Mostra todos os equipamentos cadastrados
    public void mostraEquipamentos() {
        if (total == 0) {
            System.out.println("\fNenhum equipamento cadastrado.");
            return;
        }

        System.out.println("\fLista de Equipamentos:");
        for (int i = 0; i < total; i++) {
            System.out.println(equipamentos[i]);
        }
    }
    
    // Retorna o equipamento na posição i
    public Equipamento buscaPorIndice(int i) {
        if (i >= 0 && i < total) {
            return equipamentos[i];
        }
        return null;
    }

    
    public void preAlugarEquipamento() {
        Scanner entrada = new Scanner(System.in);
    
        System.out.print("\fDigite o nome do equipamento: ");
        String nome = entrada.nextLine();
    
        Equipamento equipamento = buscaEquipamentoPeloNome(nome);
    
        if (equipamento == null) {
            System.out.println("\fEquipamento não encontrado.");
            return;
        }
    
        if (equipamento.getQuantidadeDisponivel() == 0) {
            System.out.println("\fEquipamento atualmente sem disponibilidade.");
            return;
        }
    
        System.out.print("\fPor quantos dias deseja alugar? (7, 15 ou 30): ");
        int dias = entrada.nextInt();

        System.out.print("\fDeseja contratar seguro? (true/false): ");
        boolean contratarSeguro = entrada.nextBoolean();

        // Simular sem alterar o atributo real
        boolean seguroOriginal = equipamento.isSeguro();
        equipamento.setSeguro(contratarSeguro);
    
        double valor = equipamento.calcularValorAluguel(dias);
    
        // Restaurar valor original do seguro
        equipamento.setSeguro(seguroOriginal);

        System.out.println("\fValor estimado do aluguel: R$ " + String.format("%.2f", valor));
        System.out.println("\fDeseja confirmar o aluguel agora? (1 - Sim / 2 - Não): ");
        int opcao = entrada.nextInt();
    
        if (opcao == 1) {
            if (equipamento.retirar()) {
                System.out.println("\fAluguel confirmado. Estoque atualizado.");
            } else {
                System.out.println("\fErro ao retirar equipamento. Verifique disponibilidade.");
            }
        } else {
            System.out.println("\fPré-aluguel cancelado.");
        }
    }
}
