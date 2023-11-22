package conta_bancaria.model;

import conta_bancaria.util.Cores;

public class ContaCorrente extends Conta{

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean Sacar(float valor) { 
		
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "\n\tSaldo Insuficiente. \n" + Cores.TEXT_RESET);
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
		
	}
	
    @Override
	public void visualizar() {
		super.visualizar();
		System.out.println("\t* Limite de Crédito: " + this.limite);
		System.out.println(Cores.TEXT_CYAN + "\n---------------------------------------------\n" + Cores.TEXT_RESET);
	}
    
}