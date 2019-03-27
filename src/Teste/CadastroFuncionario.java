/*Esta é classe que sera usado para realizar testes do cadastro de um funcionario.
 * 
 * */

package Teste;

import Codigo.Funcionario;

public class CadastroFuncionario {
	
	public static void main(String[] args) {
		//
		Funcionario fun = new Funcionario();
		
		fun.setMatricula(389);
		fun.setNome("Maria");
		fun.setDataNascimento("13-05-1960");
		
				
		System.out.println(fun.getMatricula());
		System.out.println(fun.getNome()); 

	}	
	
}
