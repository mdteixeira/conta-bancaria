package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.Optional;

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
		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent())
			conta.get().visualizar();
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

		Optional<Conta> buscaConta = buscarNaCollection(numero);

		if (buscaConta.isPresent()) {
			listaContas.set(listaContas.indexOf(buscaConta.get()), conta);
			System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\n*** A conta número " + conta.getNumero()
					+ " foi atualizada com êxito. ***" + Cores.TEXT_RESET);
		} else
			System.err.println("Erro: A conta número " + conta.getNumero() + " não foi encontrada.");
	}

	@Override
	public void deletar(int numero) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (listaContas.remove(conta.get()) == true) {
				System.out.println(Cores.TEXT_GREEN_BOLD_BRIGHT + "\n*** A conta número " + numero
						+ " foi deletada com êxito. ***" + Cores.TEXT_RESET);
			}
		} else
			System.err.println("Erro: A conta número " + numero + " não foi encontrada.");

	}

	@Override
	public void sacar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			if (conta.get().Sacar(valor) == true) {
				System.out.println("O saque da conta número " + numero + "foi efetuado com sucesso.");
			} else {
				System.err.println("Erro: A conta " + numero + "não foi encontrada.");
			}
		}

	}

	@Override
	public void depositar(int numero, float valor) {

		Optional<Conta> conta = buscarNaCollection(numero);

		if (conta.isPresent()) {
			conta.get().depositar(valor);
			System.out.println("O depósito de R$" + valor + " na conta número " + numero + "foi efetuado com sucesso.");
		} else {
			System.err.println("Erro: A conta " + numero + "não foi encontrada.");
		}
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		
		Optional<Conta> contaOrigem = buscarNaCollection(numeroOrigem);
		Optional<Conta> contaDestino = buscarNaCollection(numeroDestino);

		if (contaOrigem.isPresent() && contaDestino.isPresent()) {
			if(contaOrigem.get().Sacar(valor) == true) {
				contaDestino.get().depositar(valor);
				System.out.println("O transferência de R$" + valor + " da conta número " + numeroOrigem + " para a conta número " + numeroDestino + "foi efetuado com sucesso.");
			}
		} else {
			System.err.println("Erro: A conta " + numero + "não foi encontrada.");
		}

	}

	// métodos auxiliares

	public int gerarNumero() {
		return ++numero;
	}

	public Optional<Conta> buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if (conta.getNumero() == numero)
				return Optional.of(conta);
		}

		return Optional.empty();
	}

}
