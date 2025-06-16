import java.util.*;
public class CadastroCliente
{
    private Cliente[] contas = new Cliente[10];
    CadastroEquipamento equip = new CadastroEquipamento();
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
    
    public Cliente buscarConta(int número) {
        for (int i = 0; i < total; i++) {
            if (contas[i].getNúmero() == número) {
                return contas[i];
            }
        }
        return null; // retorna null se nao encontrar
    }
    
    public void vincularConta() {
        System.out.print("\fDigite o número da conta para vincular equipamento: ");
        int número = entrada.nextInt();
        Cliente conta = buscarConta(número);
        if (conta != null) {
            System.out.print("Digite o número da máquina que será alugada: ");
            System.out.print("Digite por quantos dias será feito o empréstimo: ");
            int dias = entrada.nextInt();
            conta.vincularConta(""); // usa o metodo da classe Conta
        } else {
            System.out.println("Conta nao encontrada.");
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
                System.out.print("\f");
                System.out.println("A empresa XFit Equipamentos foi criada em abril de 2008 pelos sócios Davi, João e Daniel. \nSendo um projeto dedicado todos os dias há mais de 15 anos com o objetivo de atender a demanda \npor equipamentos de Crossfit de alta qualidade no mercado, providenciando que academias \nusufruem do melhor da tecnologia para poder proporcionar saúde, conforto e acessibilidade as pessoas.");
                break;
            case 2:
                System.out.print("\f");
                System.out.println("Email oficial da empresa para contato e esclarecimento de dúvidas: \nequipaxfit@gmail.com \nHorário de funcionamento: \nSegunda a sexta: 8:30 às 17:30 \nSábado: 9:00 às 13:00");
                break;
            case 3:
                System.out.print("\f");
                System.out.println("Redes sociais da empresa: \nInstagram @crossxfit \nFacebook: XFit Crossfit \nWhatsApp: 51 99999-9999");
                break;
            case 4:
                System.out.print("\f");
                System.out.println("Para eventuais feedbacks e avaliações sobre nosso serviço: \nhttps://docs.google.com/forms/d/e/avaliacao");
                break;
            case 5:
                System.out.print("\f");
                System.out.println("\fVoltando ao menu inicial...");
                break;
        }
        return op;
    }
}
