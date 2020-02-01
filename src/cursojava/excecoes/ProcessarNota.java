package cursojava.excecoes;

public class ProcessarNota extends Exception {
	
	public ProcessarNota(String erro) {
		super("Erro ao carregar o arquivo..." + erro);
	}

}
