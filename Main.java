import java.util.HashMap;
import java.util.Scanner;

public class Main {	
    public static void main(String[] args) throws InterruptedException {
		Scanner leitor = new Scanner(System.in);
		HashMap<String, ContaBanco> bancoDeDados = new HashMap<>();

		//Contas
		ContaBanco account1 = new ContaBanco("Fulano", 1463, 726.97);
		ContaBanco account2 = new ContaBanco("Cicrano", 5367, 854.43);
		ContaBanco account3 = new ContaBanco("Caio", 1234, 74.90);

		//convertendo os caracteres para minúsculos para uma melhor verificação
		bancoDeDados.put(account1.nome.toLowerCase(), account1);
		bancoDeDados.put(account2.nome.toLowerCase(), account2);
		bancoDeDados.put(account3.nome.toLowerCase(), account3);

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
				System.out.println("\n--- Entrando na conta.");
				Thread.sleep(1000);
				System.out.println("\n--- Entrando na conta..");
				Thread.sleep(1000);
				System.out.println("\n--- Entrando na conta...");
				Thread.sleep(1000);
				pagInicial(contaEncontrada, leitor);

			} else {
				System.out.println("ERRO 002: Senha incorreta.");
			}
		} else {
			System.out.println("ERRO 001: Usuário não encontrado.");
		}
		leitor.close();
	} 
	public static void pagInicial(ContaBanco contaEncontrada, Scanner leitor) {
	    while (true) {
	        System.out.println("\n=================================");
            System.out.println("Bem-vindo de volta, " + contaEncontrada.nome + ".");
            System.out.println("Saldo atual: R$" + contaEncontrada.saldo);
            System.out.println("Total de depósitos feitos: " + contaEncontrada.depositos);
            System.out.println("Total de saques feitos: " + contaEncontrada.saques);
            System.out.println("=================================");
        
            System.out.println("O que deseja fazer? (Digite o número da ação)");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Sair");
	    
	        String opcaoTXT = leitor.nextLine();
	        int opcao = Integer.parseInt(opcaoTXT);
	        
	        if (opcao == 1) {
	            System.out.print("\nDigite o valor a ser depositado: R$");
                String valorDepositadoTXT = leitor.nextLine();
            
                // O 'try' tenta executar o código que pode dar erro
                try {
                    double valorDepositado = Double.parseDouble(valorDepositadoTXT);
                
                    // Se chegou aqui, o Java confirmou que é um Double válido!
                    if (valorDepositado > 0) {
                        contaEncontrada.saldo += valorDepositado;
                        contaEncontrada.depositos++;
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Valor de depósito inválido (deve ser maior que zero).");
                    }
                
                } catch (NumberFormatException e) {
                    // O 'catch' captura o erro se o usuário digitou letras/símbolos inválidos
                    System.out.println("ERRO: Você não digitou um número válido!");
                }
	        } else if (opcao == 2) {
	            System.out.print("\nDigite o valor a ser sacado: R$");
                String valorSacadoTXT = leitor.nextLine();
            
                try {
                    // Tenta converter o texto para double
                    double valorSacado = Double.parseDouble(valorSacadoTXT);
                    
                // Se o Java converteu com sucesso, faz as validações numéricas
                    if (valorSacado > 0 && valorSacado <= contaEncontrada.saldo) {
                        contaEncontrada.saldo -= valorSacado;
                        contaEncontrada.saques++;
                        System.out.println("Saque realizado.");
                    } else {
                        System.out.println("Saldo insuficiente ou valor inválido.");
                    }
                
                } catch (NumberFormatException e) {
                    // Captura o erro caso o usuário digite letras no saque
                    System.out.println("ERRO: Você não digitou um valor numérico válido!");
            }
	        } else if (opcao == 3) {
	            System.out.println("\nObrigado por utilizar nosso sitema bancário, tenha um bom dia.");
	            break;
	        } else {
	            System.out.println("Opção inválida. Tente novamente.");
	        }
	    }
	    
	}
}

//Cria as contas
class ContaBanco {
    String nome;
    int senha;
    double saldo;
    int depositos; //Quantidade de depositos e saques
    int saques;

    public ContaBanco(String nome, int senha, double saldo) {
		this.nome = nome;
		this.senha = senha;
		this.saldo = saldo;
	}
}
