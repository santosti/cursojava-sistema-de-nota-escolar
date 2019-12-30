package cursojava.entidades;

public class Diretor extends Pessoa {

	private int registroEduc;
	private int tempoDirecao;
	private String titulacao;

	public Diretor() {
		super();
	}

	public Diretor(String nome, int idade, String dataNasc, String cpf, String nomeMae, String nomePai) {
		super(nome, idade, dataNasc, cpf, nomeMae, nomePai);
	}

	public int getRegistroEduc() {
		return registroEduc;
	}

	public int getTempoDirecao() {
		return tempoDirecao;
	}

	public void setTempoDirecao(int tempoDirecao) {
		this.tempoDirecao = tempoDirecao;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

}
