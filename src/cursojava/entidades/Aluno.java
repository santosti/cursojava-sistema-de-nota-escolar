package cursojava.entidades;

import java.util.ArrayList;
import java.util.List;

import cursojava.constantes.StatusAluno;

public class Aluno extends Pessoa {

	private double nota;

	private List<Disciplina> disciplinas = new ArrayList<>();

	public Aluno(String nome, int idade, String dataNasc, String cpf, String nomeMae, String nomePai) {
		super(nome, idade, dataNasc, cpf, nomeMae, nomePai);
	}

	public Aluno() {
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplina(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	// Percorre a lista de objetos, soma a nota das disciplinas e atribui a variavel somaNota.
	public double getMediaAluno() {
		double somaNotas = 0.0;
		for (Disciplina disc : disciplinas) {
			somaNotas += disc.getNota();
		}
		return somaNotas / disciplinas.size(); // size() retorna a quantidade existente dinamicamente.
	}

	// Condição de aprovado e reprovado.
	public boolean getResultado() {
		double media = this.getMediaAluno();

		if (media >= 70) {
			return true;
		} else {
			return false;
		}
	}

	public String getResultado2() {
		double media = this.getMediaAluno();

		if (media >= 50) {
			if (media >= 70) {
				return StatusAluno.APROVADO;
			} else {
				return StatusAluno.RECUPERACAO;
			}
		} else {
			return StatusAluno.REPROVADO;
		}
	}

	@Override
	public String toString() {
		return "Aluno [nota=" + nota + ", disciplinas=" + disciplinas + ", nome=" + nome + ", idade=" + idade
				+ ", dataNasc=" + dataNasc + ", cpf=" + cpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + idade;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nota);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (idade != other.idade)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(nota) != Double.doubleToLongBits(other.nota))
			return false;
		return true;
	}
	
	@Override
	public boolean restricaoIdade() {
		return idade <= 18;
	}
	public String msg() {
		return this.restricaoIdade() ? "Parabéns você é maior de idade" : "Que pena você não é maior de idade";
	}

	@Override
	public double salario() {
		return 700.00;
	}

}
