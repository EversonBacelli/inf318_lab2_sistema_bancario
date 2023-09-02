package br.com.banco.boundary;
import br.com.banco.controller.TrmCxAut;

/**
 * Autores: C.M.F. Rubira, P.A. Guerra e L.P. Tizzei
 * 
 * Introdução à Programação Orientada a Objetos usando Java
 * 
 * Cap. 6 - Sistema de Caixa Automático
 * 
 * última modificação: março de 2014
 */



public class Principal {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Instanciacao do caixa automatico com a senha do caixa
		TrmCxAut meuTrmCxAut = new TrmCxAut(123);
		
		//utilizacao do terminal do caixa
		meuTrmCxAut.iniciarOperacao();

	}
}