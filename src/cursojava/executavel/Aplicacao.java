package cursojava.executavel;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import cursojava.classesAuxiliares.MetodoAutenticar;
import cursojava.constantes.StatusAluno;
import cursojava.entidades.Aluno;
import cursojava.entidades.Diretor;
import cursojava.entidades.Disciplina;
import cursojava.entidades.Secretario;

public class Aplicacao {

	public static void main(String[] args) {
	
		try {
			lerArquivo();
			
			String usuario = JOptionPane.showInputDialog("Informe o usuario: ");
			String senha = JOptionPane.showInputDialog("Informe a senha: ");

			// Amarração de autenticação do sistema.
			if (new MetodoAutenticar(new Diretor(usuario, senha)).autenticarSistema() || new MetodoAutenticar(new Secretario(usuario, senha)).autenticarSistema()) {

				List<Aluno> alunos = new ArrayList<Aluno>();

				// HashMap é uma lista que utiliza chave e valor.
				HashMap<String, List<Aluno>> maps = new HashMap<>();

				for (int qtd = 1; qtd <= 1; qtd++) {

					Aluno aluno = new Aluno();

					String nome = JOptionPane.showInputDialog("Informe o nome " + qtd + ": ");
					String idade = JOptionPane.showInputDialog("Informe a idade: ");

					aluno.setNome(nome);
					aluno.setIdade(Integer.valueOf(idade));

					for (int i = 1; i <= 1; i++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Informe a disciplina " + i + ": ");
						String notaDisciplina = JOptionPane.showInputDialog("Informe a nota " + i + ": ");
						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						disciplina.setNota(Double.valueOf(notaDisciplina));

						aluno.getDisciplinas().add(disciplina);
					}

					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina? ");
					// Opção 0 sim, opção 1 não.

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
				// Inicia as listas
				maps.put(StatusAluno.APROVADO, new ArrayList<>());
				maps.put(StatusAluno.RECUPERACAO, new ArrayList<>());
				maps.put(StatusAluno.REPROVADO, new ArrayList<>());

				for (Aluno aluno : alunos) {
					if (aluno.getResultado2().equalsIgnoreCase(StatusAluno.APROVADO)) {
						maps.get(StatusAluno.APROVADO).add(aluno);
					} else if (aluno.getResultado2().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
						maps.get(StatusAluno.RECUPERACAO).add(aluno);
					} else {
						maps.get(StatusAluno.REPROVADO).add(aluno);
					}

				}

				System.out.println("-------------Lista dos Aprovados--------------- ");
				for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
					System.out.println("Nome = " + aluno.getNome() + ", Resultado = " + aluno.getResultado2()
							+ ", Média = " + aluno.getMediaAluno());
				}
				System.out.println();
				System.out.println("-------------Lista dos Recuperação--------------- ");
				for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
					System.out.println("Nome = " + aluno.getNome() + ", Resultado = " + aluno.getResultado2()
							+ ", Mï¿½dia = " + aluno.getMediaAluno());
				}
				System.out.println();
				System.out.println("-------------Lista dos Reprovados--------------- ");
				for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
					System.out.println("Nome = " + aluno.getNome() + ", Resultado = " + aluno.getResultado2()
							+ ", Média = " + aluno.getMediaAluno());
				}

			} else {
				JOptionPane.showMessageDialog(null, "Acesso negado");
			}
		} catch (Exception e) {

			StringBuilder saida = new StringBuilder();

			e.printStackTrace(); // Imprime erro no console.

			for (int i = 0; i < e.getStackTrace().length; i++) {
				saida.append("\nNome do erro: " + e.getStackTrace()[i].getClassName());
				saida.append("\nMétodo do erro: " + e.getStackTrace()[i].getMethodName());
				saida.append("\nLinha do erro: " + e.getStackTrace()[i].getLineNumber());
			}

			JOptionPane.showMessageDialog(null, "Erro ao processar notas" + saida.toString());
		} 
		
		finally { // Sempre será executado independete de existir erros ou não.
			JOptionPane.showMessageDialog(null, "Obrigada por aprender Java");
		}

	}

	public static void lerArquivo() throws FileNotFoundException {
			File arq = new File("C:\\Users\\_Furiosa\\Documents\\projetos-java\\cursojava-sistema-de-notas-escolares\\arquivoTeste.txt");
			Scanner scan = new Scanner(arq);
	}
}
