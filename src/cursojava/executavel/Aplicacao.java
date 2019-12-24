package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.constantes.StatusAluno;
import cursojava.entidades.Aluno;
import cursojava.entidades.Disciplina;

public class Aplicacao {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<>();

		List<Aluno> alunosAprovados = new ArrayList<>();
		List<Aluno> alunosRecuperacao = new ArrayList<>();
		List<Aluno> alunosReprovados = new ArrayList<>();

		for (int qtd = 1; qtd <= 5; qtd++) {

			Aluno aluno = new Aluno();

			String nome = JOptionPane.showInputDialog("Informe o nome " + qtd + ": ");
			String idade = JOptionPane.showInputDialog("Informe a idade: ");
//			String dataNascimento = JOptionPane.showInputDialog("Informe a data de nascimento: ");

			aluno.setNome(nome);
			aluno.setIdade(Integer.valueOf(idade));
//			aluno.setDataNascimento(dataNascimento);

			for (int i = 1; i <= 1; i++) {
				String nomeDisciplina = JOptionPane.showInputDialog("Informe a disciplina " + i + ": ");
				String notaDisciplina = JOptionPane.showInputDialog("Informe a nota " + i + ": ");
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(nomeDisciplina);
				disciplina.setNota(Double.valueOf(notaDisciplina));

				aluno.getDisciplinas().add(disciplina);
			}

			int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");
			// Opção 0 é sim, opção 1 é não
			if (escolha == 0) {
				int continuarRemover = 0;
				int posicao = 1;
				while (continuarRemover == 0) {
					String disciplinaRemover = JOptionPane.showInputDialog("Qual a disciplina 1, 2, 3 ou 4 ? ");
					aluno.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
					posicao++;
					continuarRemover = JOptionPane.showConfirmDialog(null, "Continuar a remover? ");
				}
			}

			alunos.add(aluno);
		}

		for (Aluno aluno : alunos) {
			if (aluno.getResultado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
				alunosAprovados.add(aluno);
			} else if (aluno.getResultado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
				alunosRecuperacao.add(aluno);
			} else {
				alunosReprovados.add(aluno);
			}

		}

		System.out.println("-------------Lista dos Aprovados--------------- ");
		for (Aluno aluno : alunosAprovados) {
			System.out.println("Nome = " + aluno.getNome() + ", Resultado = " + aluno.getResultado2() + ", Média = " + aluno.getMediaAluno());
		}
		System.out.println();
		System.out.println("-------------Lista dos Recuperação--------------- ");
		for (Aluno aluno : alunosRecuperacao) {
			System.out.println("Nome = " + aluno.getNome() + ", Resultado = " + aluno.getResultado2() + ", Média = " + aluno.getMediaAluno());
		}
		System.out.println();
		System.out.println("-------------Lista dos Reprovados--------------- ");
		for (Aluno aluno : alunosReprovados) {
			System.out.println("Nome = " + aluno.getNome() + ", Resultado = " + aluno.getResultado2() + ", Média = " + aluno.getMediaAluno());
		}

	}

}
