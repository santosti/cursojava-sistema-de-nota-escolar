package cursojava.executavel;

import cursojava.entidades.Aluno;
import cursojava.entidades.Disciplina;

public class ArrayVetor {

	public static void main(String[] args) {

		double[] notasJava = { 7.4, 5.4, 6.3, 7.5 };
		double[] notasLogica = { 8.7, 6.6, 8.6, 9.7 };

		Aluno aluno = new Aluno();
		aluno.setNome("Simone");
		aluno.setIdade(24);

		Disciplina disciplina1 = new Disciplina();
		disciplina1.setDisciplina("Java");
		disciplina1.setNota(notasJava);
		aluno.getDisciplinas().add(disciplina1);

		Disciplina disciplina2 = new Disciplina();
		disciplina2.setDisciplina("Logica");
		disciplina2.setNota(notasLogica);
		aluno.getDisciplinas().add(disciplina2);

		Aluno[] arrayAlunos = new Aluno[1];
		arrayAlunos[0] = aluno;

		for (int i = 0; i < arrayAlunos.length; i++) {
			System.out.println("Nome do aluno: " + arrayAlunos[i].getNome());

			for (Disciplina dis : arrayAlunos[i].getDisciplinas()) {
				System.out.println();
				System.out.println("Nome disciplina: " + dis.getDisciplina());
				
				double notaMax = 0;
				double notaMin = 0;
				for (int posNota = 0; posNota < dis.getNota().length; posNota++) {
					System.out.println("Notas " + (posNota + 1) + " : " + dis.getNota()[posNota]);

					if (posNota == 0) {
						notaMax = dis.getNota()[posNota];
					} else {
						if (dis.getNota()[posNota] > notaMax) {
							notaMax =+ dis.getNota()[posNota];
						}
					}
					
					if(posNota == 0) {
						notaMin = dis.getNota()[posNota];
					}else {
						if(dis.getNota()[posNota] < notaMin) {
							notaMin =+ dis.getNota()[posNota];
						}
					}
				}
				System.out.println("Maior nota: " + notaMax);
				System.out.println("Menor nota: " + notaMin);

			}

		}

	}
}
