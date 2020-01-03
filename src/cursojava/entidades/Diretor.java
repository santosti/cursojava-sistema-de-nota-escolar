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

	@Override
	public String toString() {
		return "Diretor [registroEduc=" + registroEduc + ", tempoDirecao=" + tempoDirecao + ", titulacao=" + titulacao
				+ ", nome=" + nome + ", idade=" + idade + ", dataNasc=" + dataNasc + ", cpf=" + cpf + ", nomeMae="
				+ nomeMae + ", nomePai=" + nomePai + "]";
	}
	
	@Override
	public boolean restricaoIdade() {
		return idade >= 40;
	}
	
	public String msg() {
		return this.restricaoIdade() ? "Parabéns você é maior de idade" : "Que pena você não é maior de idade";
	}

	@Override
	public double salario() {
		return 5000.23;
	}

}
