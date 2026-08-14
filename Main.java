import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Main {    
    public static void main(String[] args) throws InterruptedException {
        Scanner leitor = new Scanner(System.in);
        HashMap<String, ContaBanco> bancoDeDados = new HashMap<>();

        // Contas iniciais
        ContaBanco account1 = new ContaBanco("Fulano", 1463, 726.97);
        ContaBanco account2 = new ContaBanco("Cicrano", 5367, 854.43);
        ContaBanco account3 = new ContaBanco("Caio", 1234, 74.90);

        // convertendo os caracteres para minúsculos para uma melhor verificação
        bancoDeDados.put(account1.getNome().toLowerCase(), account1);
        bancoDeDados.put(account2.getNome().toLowerCase(), account2);
        bancoDeDados.put(account3.getNome().toLowerCase(), account3);

        System.out.println("--- Sistema Bancário ---");
        System.out.print("Digite seu nome de usuário: ");
        String nomeDigitado = leitor.nextLine();

        if (bancoDeDados.containsKey(nomeDigitado.toLowerCase())) {
            ContaBanco contaEncontrada = bancoDeDados.get(nomeDigitado.toLowerCase());

            int tentativas = 0;
            boolean autenticado = false;
            while (tentativas < 3 && !autenticado) {
                System.out.print("Usuário encontrado. \nDigite sua senha: ");
                String senhaDigitadaTXT = leitor.nextLine();
                try {
                    int senhaDigitada = Integer.parseInt(senhaDigitadaTXT);
                    if (contaEncontrada.checkSenha(senhaDigitada)) {
                        autenticado = true;
                        Thread.sleep(500);
                        System.out.println("\n--- Entrando na conta.");
                        Thread.sleep(500);
                        System.out.println("\n--- Entrando na conta..");
                        Thread.sleep(500);
                        System.out.println("\n--- Entrando na conta...");
                        Thread.sleep(500);
                        pagInicial(contaEncontrada, leitor, bancoDeDados);
                    } else {
                        tentativas++;
                        System.out.println("ERRO 002: Senha incorreta. Tentativa " + tentativas + " de 3.");
                    }
                } catch (NumberFormatException e) {
                    tentativas++;
                    System.out.println("ERRO: a senha deve ser numérica. Tentativa " + tentativas + " de 3.");
                }
            }

            if (!autenticado) {
                System.out.println("ERRO: número máximo de tentativas atingido.");
            }

        } else {
            System.out.println("ERRO 001: Usuário não encontrado.");
        }
        leitor.close();
    } 

    public static void pagInicial(ContaBanco contaEncontrada, Scanner leitor, HashMap<String, ContaBanco> bancoDeDados) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"));
        while (true) {
            System.out.println("\n=================================");
            System.out.println("Bem-vindo de volta, " + contaEncontrada.getNome() + ".");
            System.out.println("Saldo atual: " + nf.format(contaEncontrada.getSaldo()));
            System.out.println("Total de depósitos feitos: " + contaEncontrada.getDepositos());
            System.out.println("Total de saques feitos: " + contaEncontrada.getSaques());
            System.out.println("=================================");

            System.out.println("O que deseja fazer? (Digite o número da ação)");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Sair");
            System.out.println("4 - Criar nova conta");
        
            String opcaoTXT = leitor.nextLine();
            int opcao;
            try {
                opcao = Integer.parseInt(opcaoTXT);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite 1, 2, 3 ou 4.");
                continue;
            }

            if (opcao == 1) {
                System.out.print("\nDigite o valor a ser depositado: R$");
                String valorDepositadoTXT = leitor.nextLine();
                try {
                    double valorDepositado = Double.parseDouble(valorDepositadoTXT);
                    if (valorDepositado > 0) {
                        contaEncontrada.depositar(valorDepositado);
                        System.out.println("Depósito realizado.");
                    } else {
                        System.out.println("Valor de depósito inválido (deve ser maior que zero).");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Você não digitou um número válido!");
                }
            } else if (opcao == 2) {
                System.out.print("\nDigite o valor a ser sacado: R$");
                String valorSacadoTXT = leitor.nextLine();
                try {
                    double valorSacado = Double.parseDouble(valorSacadoTXT);
                    if (valorSacado > 0) {
                        boolean sucesso = contaEncontrada.sacar(valorSacado);
                        if (sucesso) {
                            System.out.println("Saque realizado.");
                        } else {
                            System.out.println("Saldo insuficiente ou valor inválido.");
                        }
                    } else {
                        System.out.println("Saldo insuficiente ou valor inválido.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ERRO: Você não digitou um valor numérico válido!");
                }
            } else if (opcao == 3) {
                System.out.println("\nObrigado por utilizar nosso sistema bancário, tenha um bom dia.");
                break;
            } else if (opcao == 4) {
                System.out.println("\n--- Criação de nova conta ---");
                System.out.print("Digite o nome do novo usuário: ");
                String novoNome = leitor.nextLine().trim();
                if (novoNome.isEmpty()) {
                    System.out.println("Nome inválido.");
                    continue;
                }
                if (bancoDeDados.containsKey(novoNome.toLowerCase())) {
                    System.out.println("Já existe uma conta com esse nome.");
                    continue;
                }
                System.out.print("Digite uma senha numérica para a conta: ");
                String novaSenhaTXT = leitor.nextLine();
                int novaSenha;
                try {
                    novaSenha = Integer.parseInt(novaSenhaTXT);
                } catch (NumberFormatException e) {
                    System.out.println("Senha inválida. Deve ser numérica.");
                    continue;
                }
                System.out.print("Digite o depósito inicial (ou deixe em branco para 0): R$");
                String depositoInicialTXT = leitor.nextLine();
                double depositoInicial = 0.0;
                if (!depositoInicialTXT.trim().isEmpty()) {
                    try {
                        depositoInicial = Double.parseDouble(depositoInicialTXT);
                        if (depositoInicial < 0) {
                            System.out.println("Valor inicial inválido.");
                            continue;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Valor inicial inválido.");
                        continue;
                    }
                }
                ContaBanco novaConta = new ContaBanco(novoNome, novaSenha, depositoInicial);
                bancoDeDados.put(novoNome.toLowerCase(), novaConta);
                System.out.println("Conta criada com sucesso para usuário: " + novoNome + ".");

            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}
