package br.com.banco.DAO;
import br.com.banco.entity.ContaCor;
import br.com.banco.entity.PacoteConta;

/**
 * Autores: C.M.F. Rubira, P.A. Guerra e L.P. Tizzei
 * 
 * Introdução à Programação Orientada a Objetos usando Java
 * 
 * Estudo de caso: Sistema de Caixa Automático
 * 
 * última modificação: março de 2014
 */



public class CadastroContas {
	//Atributos
	  private ContaCor c[];  // vetor de contas
	  
	//Operacoes
	  
	  public CadastroContas () {  // método construtor 
	    c=new ContaCor[4];// o índice zero não é utilizado
	    
	    c[1]=new ContaCor("Juliana",500,1,1);
	    System.out.println("Conta de Juliana criada com id 1 senha 1 e 500,00");
	    
	    c[2]=new ContaCor(1000,"Michelle", 2, 2);
	    System.out.println("Conta de Maria criada com id 2 senha 2 e 500,00");
	    
	    c[3]=new ContaCor("Marcio", 600, 3, 3, PacoteConta.BASICO);
	    System.out.println("Conta de Nestor criada com id 3 senha 3 e 500,00");
	    
	  }
	  
	  public ContaCor buscarConta (int num) {
	    if (num < 1 || num > 3)  // apenas os número 1, 2 e 3 são aceitos
	      return(null);
	    else
	      return(c[num]);
	  }

}