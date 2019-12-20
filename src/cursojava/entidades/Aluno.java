package cursojava.entidades;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	public String nome;
	public int idade;
	private String dataNascimento;
	private double nota;

	private List<Disciplina> disciplinas = new ArrayList<>();

	public Aluno() {
	}

	public Aluno(String nome, int idade, String dataNascimento) {
		super();
		this.nome = nome;
		this.setIdade(idade);
		this.dataNascimento = dataNascimento;
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

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
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
				return "Aluno está aprovado";
			} else {
				return "Aluno está em recuperação";
			}
		} else {
			return "Aluno está reprovado";
		}
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
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
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
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

}
