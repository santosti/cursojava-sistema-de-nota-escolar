package cursojava.executavel;

import cursojava.entidades.Aluno;
import cursojava.entidades.Diretor;
import cursojava.entidades.Pessoa;
import cursojava.entidades.Secretario;

public class TesteHeranca {

	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		aluno.setNome("Simone Dev Junior");
		aluno.setNomeMae("Luzinete");
		aluno.setIdade(24);

		Diretor diretor = new Diretor();
		diretor.setNome("José Campos");
		diretor.setIdade(45);

		Secretario secretario = new Secretario();
		secretario.setNome("Francisca");
		secretario.setNivelCargo("Pleno");
		secretario.setIdade(16);

		System.out.println(aluno);
		System.out.println(diretor);
		System.out.println(secretario);

		System.out.println(aluno.restricaoIdade() + " - " + aluno.msg());
		System.out.println(diretor.restricaoIdade() + " - " + diretor.msg());
		System.out.println(secretario.restricaoIdade());

		System.out.println("Salario aluno = " + aluno.salario());
		System.out.println("Salario diretor = " + diretor.salario());
		System.out.println("Salario secretario = " + secretario.salario());
		
		
		teste(aluno);
		teste(diretor);
		teste(secretario);
		
	}
	
	//Conceito de polimorfismo e métodos abstratos
	public static void teste(Pessoa pessoa) {
		System.out.println("Essa pessoa é demais = " + pessoa.getNome() + ", Salario = " + pessoa.salario());
	}

}
