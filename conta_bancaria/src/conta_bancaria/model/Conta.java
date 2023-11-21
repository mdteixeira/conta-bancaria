package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class Conta {

	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public void visualizar() {

		String tipo = "";
		switch (this.tipo) {
		case 1 -> tipo = "Conta corrente";
		case 2 -> tipo = "Conta Poupança";
		}

		System.out.println(Cores.TEXT_CYAN + "\n---------------------------------------------" + Cores.TEXT_RESET);
		System.out.println("\t\tDados da Conta\n");
		System.out.println("\t* Número da Conta: " + this.numero);
		System.out.println("\t* Agência: " + this.agencia);
		System.out.println("\t* Tipo da conta: " + tipo);
		System.out.println("\t* Titular da conta: " + this.titular);
		System.out.println("\t* Saldo da conta: " + this.saldo);
	}
	///////////////////////////////

	// Sacar dinheiro
	public boolean Sacar(float valor) {
		if (this.getSaldo() < valor) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\n\tSaldo Insuficiente. \n" + Cores.TEXT_RESET);
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	// Depositar
	public void depositar(float valor) {
		this.setSaldo(this.getSaldo() + valor);
		System.out.printf("\n\tVocê depositou" + Cores.TEXT_GREEN_BOLD_BRIGHT + " R$ %.2f\n" +  Cores.TEXT_RESET, valor);
	}

}
