package conta_bancaria;

import java.util.Scanner;

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
		
        // Teste da Classe Conta
		Conta c1 = new Conta(3, 123, 1, "Mariana", 500000.0f);
		c1.visualizar();
		c1.Sacar(12000.0f);
		c1.visualizar();
		c1.depositar(5000.0f);
		c1.visualizar();
        
		// Teste da Classe Conta Corrente
		ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
		cc1.visualizar();
		cc1.Sacar(12000.0f);
		cc1.visualizar();
		cc1.depositar(5000.0f);
		cc1.visualizar();
		
        // Teste da Classe Conta Poupança
		ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
		cp1.visualizar();
        cp1.Sacar(1000.0f);
		cp1.visualizar();
		cp1.depositar(5000.0f);
		cp1.visualizar();

		while (true) {

			System.out.println(separador);
			System.out.println("");
			System.out.println("\t\tTyche Bank");
			System.out.println("");
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
			case 1 -> System.out.println("Opção 1 - Criar Conta");
			case 2 -> System.out.println("Opção 2 - Listar todas as Contas");
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
