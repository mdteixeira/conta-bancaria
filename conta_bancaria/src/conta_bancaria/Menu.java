package conta_bancaria;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	static Scanner sc = new Scanner(System.in);
	static final String urlRepo = "https://github.com/mdteixeira/conta-bancaria\n";
	static final String separador = Cores.TEXT_YELLOW_BOLD_BRIGHT + "*********************************************"
			+ Cores.TEXT_RESET;

	public static void main(String[] args) {
		
		int operacao = 0;

		while (true) {

			System.out.println(separador);
			System.out.println("\t\tTyche Bank");
			System.out.println(separador);
			System.out.println("");
			System.out.println("\t1 - Criar Conta");
			System.out.println("\t2 - Listar todas as Contas");
			System.out.println("\t3 - Buscar Conta por número");
			System.out.println("\t4 - Atualizar Dados da Conta");
			System.out.println("\t5 - Apagar Conta");
			System.out.println("\t6 - Sacar");
			System.out.println("\t7 - Depositar");
			System.out.println("\t8 - Transferir valores entre Contas");
			System.out.println("\t9 - Sair");
			System.out.println("");
			System.out.println(separador);
			System.out.println("\n*** Entre com a opção desejada:");
			System.out.print("\n >>> ");

			try {
				operacao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.err.println("\tDigite valores inteiros.");
				sc.nextLine();
				operacao = 0;
			}

			switch (operacao) {
			case 1 -> criarConta();
			case 2 -> listarContas();
			case 3 -> buscarPorNumero();
			case 4 -> {
				
				System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 4 - Atualizar Conta ***\n" + Cores.TEXT_RESET);
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				Optional<Conta> conta = contas.buscarNaCollection(numero);
				
				if (conta.isPresent()) {
					
					System.out.println("Digite o número da Agência: ");
					agencia = sc.nextInt();

					System.out.println("Digite o nome do titular: ");
					titular = sc.next();

					conta.get().getTipo();

					System.out.println("Digite o saldo da conta: ");
					saldo = sc.nextFloat();
					
					// Verifica se a conta é corrente ou poupança
					switch (tipoDeConta) {
					// Se for Conta Corrente
					case 1 -> {
						System.out.println("Digite o limite da conta: ");
						limite = sc.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipoDeConta, titular, saldo, limite));
					}
					// Se for Conta Poupança
					case 2 -> {
						System.out.println("Digite o aniversário da conta: ");
						aniversario = sc.nextInt();
						contas.atualizar(
								new ContaPoupanca(numero, agencia, tipoDeConta, titular, saldo, aniversario));
					}
					}
					keyPress();
					
				} else {
					System.err.println("Erro: A conta número " + numero + " não foi encontrada.");
				}
			}
			case 5 -> deletarConta();
			case 6 -> {
				
				float valor;
				
				System.out.println("Opção 6 - Sacar");
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				
				System.out.println("Digite o valor do saque: ");
				valor = sc.nextFloat();
				
				contas.sacar(numero, valor);
				
			}
			case 7 -> {
				System.out.println("Opção 7 - Depositar");
				
				
				float valor;
				
				System.out.println("Digite o número da conta: ");
				numero = sc.nextInt();
				
				System.out.println("Digite o valor do depósito: ");
				valor = sc.nextFloat();
				
				contas.depositar(numero, valor);
			}
			case 8 -> {
				System.out.println("Opção 8 - Transferir valores entre Contas");

				int numeroOrigem, numeroDestino;
				float valor;
				
				System.out.println("Digite o número da conta de origem: ");
				numeroOrigem = sc.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = sc.nextInt();
				System.out.println("Digite o valor da transferência: ");
				valor = sc.nextFloat();
				
				contas.transferir(numeroOrigem, numeroDestino, valor);
				
			}
			case 9 -> Finalizar();
			default -> {
				System.err.println("Erro: Operação inválida!");
				keyPress();
			}
			}
		}

	}

	static ContaController contas = new ContaController();

	static int numero, agencia, tipoDeConta, aniversario;
	static String titular;
	static float saldo, limite;

	private static void criarConta() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 1 - Criar Conta ***\n" + Cores.TEXT_RESET);
		System.out.println("Digite o número da Agência: ");
		agencia = sc.nextInt();

		System.out.println("Digite o nome do titular: ");
		titular = sc.next();

		System.out.println("Digite o tipo da conta: 1 - CC / 2 - CP");
		tipoDeConta = sc.nextInt();

		System.out.println("Digite o saldo da conta: ");
		saldo = sc.nextFloat();

		// Verifica se a conta é corrente ou poupança
		switch (tipoDeConta) {
		// Se for Conta Corrente
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			limite = sc.nextFloat();
			contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipoDeConta, titular, saldo, limite));
		}
		// Se for Conta Poupança
		case 2 -> {
			System.out.println("Digite o aniversário da conta: ");
			aniversario = sc.nextInt();
			contas.cadastrar(
					new ContaPoupanca(contas.gerarNumero(), agencia, tipoDeConta, titular, saldo, aniversario));
		}
		}
		keyPress();
	}

	private static void buscarPorNumero() {

		System.out.println(
				Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 3 - Buscar conta por número ***\n" + Cores.TEXT_RESET);

		System.out.println("Digite o número da conta : ");
		numero = sc.nextInt();
		contas.procurarPorNumero(numero);
		keyPress();
	}

	private static void deletarConta() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 5 - Deletar Conta ***\n" + Cores.TEXT_RESET);

		System.out.println("Digite o número da conta : ");
		numero = sc.nextInt();
		contas.deletar(numero);
		keyPress();
	}

	private static void listarContas() {
		System.out.println(
				Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 2 - Listar todas as Contas ***\n" + Cores.TEXT_RESET);
		contas.listarTodas();
		keyPress();
	}

	private static void Finalizar() {
		System.out.println("\nOpção 9 - Sair\n");

		System.out.println(separador);
		System.out.println("");
		System.out.println("\t\tTyche Bank");
		System.out.println("");
		System.out.println(separador);
		Sobre();
		sc.close();
		System.exit(0);

	}

	private static void Sobre() {
		System.out.println("\n" + separador);
		System.out.println(
				"\nProjeto desenvolvido por " + Cores.TEXT_CYAN_BOLD_BRIGHT + "Matheus Teixeira" + Cores.TEXT_RESET);
		System.out.println("\nCódigo disponível em: \n" + Cores.TEXT_BLUE_UNDERLINED + urlRepo + Cores.TEXT_RESET);
		System.out.println(separador + Cores.TEXT_RESET);

	}

	public static void keyPress() {

		try {

			System.out.println("\n\nPressione a tecla Enter para continuar");
			System.in.read();

		} catch (IOException e) {
			System.err.println("Erro: Você pressionou uma tecla inválida!");
		}
	}

}
