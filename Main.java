import java.util.HashMap;
import java.util.Scanner;

public class Main {	public static void main(String[] args) throws InterruptedException {
		Scanner leitor = new Scanner(System.in);
		HashMap<String, ContaBanco> bancoDeDados = new HashMap<>();

		//Contas
		ContaBanco account1 = new ContaBanco("Fulano", 1463, 726.97);
		ContaBanco account2 = new ContaBanco("Cicrano", 5367, 854.43);

		//convertendo os caracteres para minúsculos para uma melhor verificação
		bancoDeDados.put(account1.nome.toLowerCase(), account1);
		bancoDeDados.put(account2.nome.toLowerCase(), account2);

		System.out.println("--- Sistema Bancário ---");
		System.out.print("Digite seu nome de usuáio: ");
		String nomeDigitado = leitor.nextLine();

		if (bancoDeDados.containsKey(nomeDigitado.toLowerCase())) {
			ContaBanco contaEncontrada = bancoDeDados.get(nomeDigitado.toLowerCase());

			System.out.print("Usuário encontrado. \nDigite sua senha: ");
			String senhaDigitadaTXT = leitor.nextLine();
			int senhaDigitada = Integer.parseInt(senhaDigitadaTXT);

			if (senhaDigitada == contaEncontrada.senha) {
			    Thread.sleep(1000);
				System.out.println("\n--- Entrando na conta...");
				Thread.sleep(1000);
				System.out.println("\n--- Entrando na conta.");
				Thread.sleep(1000);
				System.out.println("\n--- Entrando na conta..");
				Thread.sleep(1000);
				System.out.println("\n--- Entrando na conta...");
				Thread.sleep(2000);

				System.out.println("Bem-vindo de volta " + contaEncontrada.nome + ".");
				System.out.println("Saldo atual: " + contaEncontrada.saldo);
				//Opções para o usuário
				System.out.println("Oque deseja fazer? (digite o número da opção)");
				System.out.println("1 - Depositar");
				System.out.println("2 - Sacar");
				System.out.println("3 - Sair");
				
				String opcaoTXT = leitor.nextLine();
				int opcao = Integer.parseInt(opcaoTXT);

				if (opcao == 1) {
					System.out.print("Insira o valor a ser depositado: ");
					String valorDepositadoTXT = leitor.nextLine();
					double valorDepositado = Double.parseDouble(valorDepositadoTXT);
					contaEncontrada.saldo += valorDepositado;
					System.out.println("Depósito realizado com sucesso.\nValor depositado: " + valorDepositado + "\nSaldo atual: " + contaEncontrada.saldo);
				} else if (opcao == 2) {
					System.out.print("Insira o valor a ser sacado: ");
					String valorSacadoTXT = leitor.nextLine();
					double valorSacado = Double.parseDouble(valorSacadoTXT);
					if (valorSacado <= contaEncontrada.saldo) {
						contaEncontrada.saldo -= valorSacado;
						System.out.println("Saque realizado com sucesso.\nValor sacado: " + valorSacado + "\nSaldo atual: " + contaEncontrada.saldo);
					} else {
						System.out.println("Saldo insuficiente para realizar o saque.");
					}
				} else if (opcao == 3 ) {
					System.out.println("Saindo...");
				} else {
					System.out.println("Opção inválida. Saindo...");
				}

			} else {
				System.out.println("ERRO 002: Senha incorreta.");
			}
		} else {
			System.out.println("ERRO 001: Usuário não encontrado.");
		}
		leitor.close();
	}
}

//Cria as contas
class ContaBanco {
    String nome;
    int senha;
    double saldo;

    public ContaBanco(String nome, int senha, double saldo) {
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
	}
}
