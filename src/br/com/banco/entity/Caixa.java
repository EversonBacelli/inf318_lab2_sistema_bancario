package br.com.banco.entity;
/**
 * Autores: C.M.F. Rubira, P.A. Guerra e L.P. Tizzei
 * 
 * Introdução à Programação Orientada a Objetos usando Java
 * 
 * Estudo de caso: Sistema de Caixa Automático
 * 
 * última modificação: março de 2014
 */


public class Caixa {
	//Atributos 
	private float saldoCaixa;	// saldo no caixa, em R$
	private int senhaCaixa;
	private int modoAtual;  // modo de operação atual: 0=supervisor, 1=cliente 

	//Constantes
	public static int MODO_SUPERVISOR = 0;
	public static int MODO_CLIENTE = 1;

	//Operacoes
	public Caixa(int senhaCaixa) {
		this.senhaCaixa = senhaCaixa;
		this.saldoCaixa = 0;
	}

	public void alternarModo(int senhaCaixa){
		if(this.validarSenha(senhaCaixa)){
			if (this.modoAtual == Caixa.MODO_SUPERVISOR)
				this.modoAtual = Caixa.MODO_CLIENTE;
			else
				this.modoAtual = Caixa.MODO_SUPERVISOR;
		}
		else
			System.out.println("Senha incorreta!");

	}

	public void liberarNotas(int qtd){
		this.saldoCaixa -= qtd*10; // notas de R$10
		while ( ( qtd-- ) > 0 )
			System.out.println("===/ R$10,00 /===>");
	}	

	public int obterModoOperacaoAtual(){
		return this.modoAtual;
	}

	public float obterSaldoCaixa(){
		return saldoCaixa;

	}


	public void recarregar(int senha){
		if(this.senhaCaixa == senha){
			this.saldoCaixa=1000;	// caixa recarregado (R$ 1000,00)
			System.out.println("Caixa recarregado!");
		}
		else
			System.out.println("Senha incorreta!");
	}
	
	public boolean validarSenha(int senhaCx){
		if(this.senhaCaixa == senhaCx)
			return true;
		else
			return false;
	}
	
}