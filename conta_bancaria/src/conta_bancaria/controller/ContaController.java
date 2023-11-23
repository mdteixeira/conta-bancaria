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
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.err.println("Erro: A conta número " + numero + " não foi encontrada.");
	}

	@Override
	public void listarTodas() {

		for (Conta conta : listaContas) {
			conta.visualizar();
		}

		if (listaContas.isEmpty()) {
			System.err.println("Erro: Não há contas cadastradas.");
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\n*** A conta número " + numero
				+ " foi criada com êxito. ***" + Cores.TEXT_RESET);
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int numero) {

		var conta = buscarNaCollection(numero);

		if (conta != null) {
			if (listaContas.remove(conta) == true) {
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\n*** A conta número " + numero
						+ " foi deletada com êxito. ***" + Cores.TEXT_RESET);
			}
		} else
			System.err.println("Erro: A conta número " + numero + " não foi encontrada.");

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

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return conta;
		}

		return null;
	}

}
