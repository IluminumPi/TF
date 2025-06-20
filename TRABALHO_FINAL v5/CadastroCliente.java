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
            for (int i = 0; i < total; i++) {
                if (contas[i].getNúmero() == número) {
                    System.out.println("\fErro: Já existe uma conta com esse número.");
                    return;
                }
            }
            contas[total] = new Cliente(número, idade, nome); // cria nova conta no vetor
            System.out.println("\fConta cadastrada com sucesso!");
            total++; // incrementa a quantidade de contas
        } else {
            System.out.println("\fLimite de contas atingido.");
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
    
    public void removerConta(){
        System.out.print("\fPara remover o cliente dos registros, insira o nome abaixo");
        System.out.println("\n\nNome: ");
        String nome = entrada.next();
        if(removerDoVetor(nome)){
            System.out.print("\fCADASTRO EXCLUÍDO COM SUCESSO\n");           
        } else {
            System.out.print("\fERRO AO EFETUAR EXCLUSÃO: VERIFIQUE SE O NOME INFORMADO ENCONTRA-SE CADASTRADO\n");           
        }
    }
    
    public void modificarNome(){
        System.out.print("\fPara modificar o nome do cliente, insira o número de cadastro do atual: ");
        int número = entrada.nextInt();
        Cliente conta = buscarConta(número);
        if (conta != null) {
            System.out.print("\fAgora, digite o novo nome do cliente: ");
            String nome2 = entrada.next();
            conta.modificar(nome2);
            System.out.print("\fNOME DO CLIENTE MODIFICADO COM SUCESSO\n");
        } else {
            System.out.println("\fCliente não encontrado\n");
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
    
    public Cliente buscarConta(int número) {
        for (int i = 0; i < total; i++) {
            if (contas[i].getNúmero() == número) {
                return contas[i];
            }
        }
        return null; // retorna null se nao encontrar
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
        System.out.println("4 - Nossas redes");
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
                System.out.println("Email oficial da empresa para contato e esclarecimento de dúvidas: equipaxfit@gmail.com \nHorário de funcionamento: \nSegunda a sexta: 8:30 às 17:30 \nSábado: 9:00 às 13:00");
                break;
            case 3:
                System.out.print("\f");
                System.out.println("Para eventuais feedbacks e avaliações sobre nosso serviço: \nhttps://docs.google.com/forms/d/e/avaliacao");
                break;
            case 4:
                System.out.print("\f");
                System.out.println("Redes sociais da empresa: \nInstagram @crossxfit \nFacebook: XFit Crossfit \nWhatsApp: 51 99999-9999");
                break;
            case 5:
                System.out.print("\f");
                System.out.println("Voltando ao menu inicial...");
                break;
        }
        return op;
    }
}
