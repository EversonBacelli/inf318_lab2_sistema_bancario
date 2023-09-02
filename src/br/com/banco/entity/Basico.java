package br.com.banco.entity;

public class Basico  implements TaxaStrategy  {

	private int qtd_operacoes = 10;
	private float mensalidadeValor = (float) 5.0;
	private boolean mensalidade = false;
	
	@Override
	public void cobrarTaxa(ContaCor conta, int senha) {
		qtd_operacoes = qtd_operacoes - 1;
		
		if(mensalidade == false) {
			mensalidade = true;
			conta.debitarValor("Cobrança de taxa pacote basico", mensalidadeValor, senha);
		}	
	}
}
