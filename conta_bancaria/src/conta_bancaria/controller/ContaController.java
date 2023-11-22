package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;
import conta_bancaria.util.Cores;

public class ContaController implements ContaRepository {

	// Criar a collection
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	// Variável para receber o número da Conta
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void listarTodas() {
		
		for(Conta conta : listaContas) {
			conta.visualizar();
		}
		
		if (listaContas.isEmpty()) {
			System.out.println(Cores.TEXT_RED_BOLD_BRIGHT + "Não há contas cadastradas.\n" + Cores.TEXT_RESET);
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.printf("A conta número %d foi criada com êxito.\n\n", conta.getNumero());
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	// métodos auxiliares

	public int gerarNumero() {
		return ++numero;
	}

}
