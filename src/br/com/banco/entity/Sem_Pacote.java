package br.com.banco.entity;

public class Sem_Pacote implements TaxaStrategy {

	float valorOperacao = (float) 0.8;
	
	@Override
	public void cobrarTaxa(ContaCor conta, int senha) {
		conta.debitarValor("Cobrança de taxa", valorOperacao, senha);
	}
	
}
