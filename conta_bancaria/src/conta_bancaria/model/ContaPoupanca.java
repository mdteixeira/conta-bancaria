package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class ContaPoupanca extends Conta{

	private int aniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);
		this.aniversario = aniversario;
	}

	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\t* Aniversário da conta: " + this.aniversario);
		System.out.println(Cores.TEXT_CYAN + "\n---------------------------------------------\n" + Cores.TEXT_RESET);

	}
    
}