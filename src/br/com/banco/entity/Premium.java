package br.com.banco.entity;

public class Premium implements TaxaStrategy {

	private boolean mensalidade = false;
	private float mensalidadeValor = (float) 20.00; 
	
	@Override
	public void cobrarTaxa(ContaCor conta, int senha) {
		if(mensalidade == false) {
			mensalidade = false;
			conta.debitarValor("Pagamento de taxa de pacote premium", 
					mensalidadeValor, senha);
		}
	}

}
