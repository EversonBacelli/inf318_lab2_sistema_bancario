package br.com.banco.controller;
import br.com.banco.DAO.CadastroContas;
import br.com.banco.entity.Caixa;
import br.com.banco.entity.ContaCor;

/**
 * Autores: C.M.F. Rubira, P.A. Guerra e L.P. Tizzei
 * 
 * Introdução à Programação Orientada a Objetos usando Java
 * 
 * Estudo de Caso do Sistema de Caixa Automático
 * 
 * última modificação: março de 2014
 */

public class ControladorCaixa {
	//Atributos
	private CadastroContas dbContas;  // Banco de dados das contas
	private Caixa caixa;

	//Operacoes
	public ControladorCaixa(int senhaCaixa) {
		dbContas = new CadastroContas();
		caixa = new Caixa(senhaCaixa);
	}

	public float consultarSaldo(int num, int senha){
		ContaCor cta;
		cta = dbContas.buscarConta(num); // obtem referencia para o objeto que representa a conta 'num'
		if (cta==null)   // se numero de conta invalido ...
			return -1; // ... retorna -1 
		else             // caso contrario ... 
			return cta.obterSaldo(senha); // efetua consulta 
	} 

	/**
	 * Saques permitidos deve ser menor ou igual que o saldo disponível no caixa.
	 * @param num numero da conta corrente
	 * @param senha senha do cliente 
	 * @param val valor que sera retirado da conta
	 * @return true se o numero da conta e a senha estiverem corretos e se o valor a ser retirado esta disponível
	 * e é menor que o saldo atual. Caso contrário, retorna false.
	 */
	public boolean efetuarSaque (int num, int senha, float val){

		ContaCor cta;

		float saldoCaixa = this.caixa.obterSaldoCaixa();

		if (saldoCaixa < val ){
			System.out.println("O caixa nao possui R$"+val+" e precisa ser recarregado.");
			return false;
		}

		cta=dbContas.buscarConta(num);  // obtem a referencia para o objeto que representa a conta 'num'

		if (cta==null)  // se número de conta inválido ...
			return false;  // ... retorna false

		if (cta.debitarValor("Saque Automatico", val, senha)==false) // se saque recusado ...
			return false;  // retorna false
		else{
			this.caixa.liberarNotas((int)(val/10)); // libera pagamento
			return true;
		}
	}
	
	
	public boolean transferencia(int conta1, int conta2, float val) {
		ContaCor cta1;
		ContaCor cta2;

		float saldoCaixa = this.caixa.obterSaldoCaixa();
		
		if (saldoCaixa < val ){
			System.out.println("O caixa nao possui R$"+val+" e precisa ser recarregado.");
			return false;
		}
		
		cta1=dbContas.buscarConta(conta1);
		cta2=dbContas.buscarConta(conta2);
		
		if(cta1 == null || cta2 == null) {return false;}
		
		boolean retorno = cta1.transferirValor(cta1, cta2, val);
		return retorno;
	}

	public void recarregar(int senha){
		this.caixa.recarregar(senha);
	}

	public boolean validarSenha(int senha){
		return this.caixa.validarSenha(senha);
	}

	public void alternarModo(int senhaCaixa){
		this.caixa.alternarModo(senhaCaixa);
	}

	public int obterModoOperacaoAtual(){
		return this.caixa.obterModoOperacaoAtual();
	}
}