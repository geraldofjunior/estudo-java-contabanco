package conta_terminal;

import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {    
        Scanner entrada = new Scanner(System.in);
        Cliente atendido = abrirConta(entrada);
        String opcao = "";
        do {
            opcao = mostrarMenu(atendido, entrada);
            if (opcao.equals("s")) {
                atendido = sacar(atendido, entrada);
            } else if (opcao.equals("d")) {
                atendido = depositar(atendido, entrada);
            }
        } while (!opcao.equals("x"));
        System.out.println("Obrigado por usar o banco Pix Robot.");
        entrada.close();
    }

    public static Cliente abrirConta(Scanner entrada) {
        Cliente novoCliente = new Cliente();
        System.out.print("Prazer em conhecer você. \nPor favor, digite o seu nome: ");
        novoCliente.setNomeCliente(entrada.nextLine());
        System.out.print("\nAgora digite o número de sua agência: ");
        novoCliente.setAgencia(entrada.nextLine());
        System.out.print("\nDigite o número da conta: ");
        novoCliente.setConta(Integer.parseInt(entrada.nextLine()));
        novoCliente.setSaldo(0.00f);

        System.out.printf("\n\nOlá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo de R$ %.2f já está disponível para saque.", 
            novoCliente.getNomeCliente(), 
            novoCliente.getAgencia(), 
            novoCliente.getConta(), 
            novoCliente.getSaldo());

        return novoCliente;
    }

    public static String mostrarMenu(Cliente atendido, Scanner entrada) {        
        System.out.printf("\n\nPrezado %s, seu saldo é de R$ %.2f. O que você deseja fazer?\n\n", atendido.getNomeCliente(), atendido.getSaldo());
        System.out.println("S - Sacar");
        System.out.println("D - Depositar");
        System.out.println("X - Sair do sistema\n");
        System.out.print("Opção: ");
        return entrada.nextLine().toLowerCase();
    }

    public static Cliente sacar(Cliente atendido, Scanner entrada) {
        System.out.printf("Você pode sacar até R$ %.2f. Quanto deseja resgatar?\n", atendido.getSaldo());
        System.out.print("R$ ");

        float valor = Float.parseFloat(entrada.nextLine());

        atendido.sacar(valor);
        System.out.printf("Pronto. Agora você tem R$ %.2f em sua conta. \n\n", atendido.getSaldo());
        return atendido;
    }

    public static Cliente depositar(Cliente atendido, Scanner entrada) {
        System.out.println("Quanto deseja depositar?");
        System.out.print("R$ ");

        float valor = Float.parseFloat(entrada.nextLine());

        atendido.depositar(valor);
        System.out.printf("Pronto. Agora você tem R$ %.2f em sua conta. \n\n", atendido.getSaldo());
        return atendido;
    }
}
