package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.controller.ContaController;
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
			System.out.println("\t3 - Buscar Conta por Numero");
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
			operacao = sc.nextInt();

			switch (operacao) {
			case 1 -> criarConta();
			case 2 -> listarContas();
			case 3 -> System.out.println("Opção 3 - Buscar Conta por número");
			case 4 -> System.out.println("Opção 4 - Atualizar Dados da Conta");
			case 5 -> System.out.println("Opção 5 - Apagar Conta");
			case 6 -> System.out.println("Opção 6 - Sacar");
			case 7 -> System.out.println("Opção 7 - Depositar");
			case 8 -> System.out.println("Opção 8 - Transferir valores entre Contas");
			case 9 -> Finalizar();
			default -> System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\n\tOperação inválida! \n" + Cores.TEXT_RESET);
			}
		}

	}

	static ContaController contas = new ContaController();

	static int numero, agencia, tipo, aniversario;
	static String titular;
	static float saldo, limite;

	private static void criarConta() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 1 - Criar Conta ***\n" + Cores.TEXT_RESET);
		System.out.println("Digite o número da Agência: ");
		agencia = sc.nextInt();

		System.out.println("Digite o nome do titular: ");
		titular = sc.next();

		System.out.println("Digite o tipo da conta: 1 - CC / 2 - CP");
		tipo = sc.nextInt();
		
		System.out.println("Digite o saldo da conta: ");
		saldo = sc.nextFloat();
		
		switch (tipo) {
		case 1 -> {
			System.out.println("Digite o limite da conta: ");
			limite = sc.nextFloat();
			contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
		}
		case 2 -> {
			System.out.println("Digite o aniversário da conta: ");
			aniversario = sc.nextInt();
			contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
		}
	}

	}

	private static void listarContas() {
		System.out.println(Cores.TEXT_PURPLE_BOLD_BRIGHT + "*** Opção 2 - Listar todas as Contas ***\n" + Cores.TEXT_RESET);
		contas.listarTodas();
	}
	
	private static void Finalizar() {
		System.out.println("\nOpção 9 - Sair\n");

		System.out.println(separador);
		System.out.println("");
		System.out.println("\t\tTyche Bank");
		System.out.println("");
		System.out.println(separador);
		Creditos();
		sc.close();
		System.exit(0);

	}

	private static void Creditos() {
		System.out.println();
		System.out.println(separador);
		System.out.println(
				"\nProjeto desenvolvido por " + Cores.TEXT_CYAN_BOLD_BRIGHT + "Matheus Teixeira" + Cores.TEXT_RESET);
		System.out.println("\nCódigo disponível em: \n" + Cores.TEXT_BLUE_UNDERLINED + urlRepo + Cores.TEXT_RESET);
		System.out.println(separador);

	}

}
