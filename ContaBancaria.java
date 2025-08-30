import java.util.Scanner;

public class ContaBancaria {
    private String titular;
    private int numeroConta;
    private double saldo;

    public ContaBancaria(String titular, int numeroConta) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$ " + valor + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }

    public void mostrarDados() {
        System.out.println("Titular: " + titular);
        System.out.println("Número da Conta: " + numeroConta);
        consultarSaldo();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Bem-vindo ao Banco ===");
        System.out.print("Digite o nome do titular: ");
        String nome = sc.nextLine();

        System.out.print("Digite o número da conta: ");
        int numero = sc.nextInt();

        ContaBancaria conta = new ContaBancaria(nome, numero);

        int opcao;
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Consultar dados da conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Consultar saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    conta.mostrarDados();
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: ");
                    double deposito = sc.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: ");
                    double saque = sc.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    conta.consultarSaldo();
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado por usar o Banco!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}
