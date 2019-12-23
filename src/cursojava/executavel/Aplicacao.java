package cursojava.executavel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.entidades.Aluno;
import cursojava.entidades.Disciplina;

public class Aplicacao {

	public static void main(String[] args) {

		List<Aluno> alunos = new ArrayList<>();

		for (int qtd = 1; qtd <= 2; qtd++) {

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

		for (int pos = 0; pos < alunos.size(); pos++) {
			Aluno aluno = alunos.get(pos); // Interação com os objetos a partir das posições.
			
			if(aluno.getNome().equalsIgnoreCase("simone")) {
				Aluno trocar = new Aluno();
				trocar.setNome("Aluno trocado! ");
				
				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina("Matématica");
				disciplina.setNota(98);
				
				trocar.getDisciplinas().add(disciplina);
				
				alunos.set(pos, trocar);
				aluno = alunos.get(pos);
				
			}
			System.out.println("Aluno(a) = " + aluno.getNome());
			System.out.println("Média do aluno(a) = " + aluno.getMediaAluno());
			System.out.println("Resultado = " + aluno.getResultado2());
			
			//Percorre a lista de disciplinas por posições.
			for(int posd = 0; posd < aluno.getDisciplinas().size(); posd ++) {
				Disciplina disc = aluno.getDisciplinas().get(posd);
				System.out.println("Disciplina = " + disc.getDisciplina() + " -- Nota = " + disc.getNota());
			}
			System.out.println("-------------------------------------------------");
		}

	}
}
