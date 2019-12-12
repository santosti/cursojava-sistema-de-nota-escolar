package cursojava.executavel;

import javax.swing.JOptionPane;

import cursojava.entidades.Aluno;
import cursojava.entidades.Disciplina;

public class Aplicacao {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();

		String nome = JOptionPane.showInputDialog("Informe o nome: ");
		String idade = JOptionPane.showInputDialog("Informe a idade: ");
		String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento: ");

		aluno.setNome(nome);
		aluno.setIdade(Integer.valueOf(idade));
		aluno.setDataNascimento(dataNascimento);

		for (int i = 1; i <= 4; i++) {
			String nomeDisciplina = JOptionPane.showInputDialog("Informe a disciplina " + i + ": ");
			String notaDisciplina = JOptionPane.showInputDialog("Informe a nota " + i + ": ");
			Disciplina disciplina = new Disciplina();
			disciplina.setDisciplinas(nomeDisciplina);
			disciplina.setNota(Double.valueOf(notaDisciplina));

			aluno.getDisciplinas().add(disciplina);
		}

		System.out.println(aluno.toString());
		System.out.println("Média do Aluno: " + aluno.getMediaAluno());
		System.out.println("Resultado: " + (aluno.getResultado() ? "Aluno aprovado" : "Aluno reprovado"));

	}

}
