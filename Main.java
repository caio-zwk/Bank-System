import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
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
			int senhaDigitada = leitor.nextInt();

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
