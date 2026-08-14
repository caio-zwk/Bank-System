# Bank-System

Pequeno sistema bancário em Java para demonstração e aprendizado.  
Permite login em contas pré-criadas, depósitos, saques e criação de novas contas via menu.

## Funcionalidades
- Login com limite de 3 tentativas.
- Depositar e sacar com validação de entrada.
- Criação de nova conta pelo menu (senha numérica e depósito inicial opcional).
- Saldo exibido no formato de moeda pt-BR.
- Classe ContaBanco separada em arquivo próprio com métodos encapsulados.

## Requisitos
- Java Development Kit (JDK) 17 ou superior (recomendado).
- Um terminal (ou IDE como VS Code) para compilar e executar o programa.

## Como compilar e executar
No diretório do projeto, execute:

1. Compilar:
   javac Main.java ContaBanco.java

2. Executar:
   java Main

Observação: se você mover os arquivos para um diretório `src/`, ajuste os comandos `javac` e `java` conforme a estrutura (por exemplo, compile para uma pasta `out/`).

## Testes rápidos
- Ao rodar `java Main`, você verá o prompt para digitar o nome do usuário.
- Usuários de exemplo incluídos: Fulano, Cicrano, Caio (senhas: consulte o código).
- Após login, use o menu para depositar, sacar, criar conta ou sair.

## Boas práticas / próximos passos sugeridos
- Usar `BigDecimal` para representar valores monetários (evita erros de ponto flutuante).
- Persistir dados em arquivo (JSON) para que contas sobrevivam ao encerramento do programa.
- Adicionar testes unitários e configurar CI (GitHub Actions).

## Contribuição
1. Crie uma branch com sua feature: `git checkout -b feature/nome-da-feature`
2. Faça commits pequenos e claros.
3. Abra um Pull Request para `main`.

## Autor
caio-zwk

## Licença
Escolha e adicione uma licença se desejar (ex.: MIT).
