package cursojava.entidades;

import cursojava.interfaces.PermitirAcesso;

public class Diretor extends Pessoa implements PermitirAcesso {

	private int registroEduc;
	private int tempoDirecao;
	private String titulacao;

	private String usuario;
	private String senha;

	public Diretor() {
	}

	public Diretor(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
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

	@Override
	public boolean autenticar(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		return autenticar();
	}

	@Override
	public boolean autenticar() {
		return usuario.equals("diretor") && senha.equals("admin");
	}

}
