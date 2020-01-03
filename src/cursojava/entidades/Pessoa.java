package cursojava.entidades;

public abstract class Pessoa {
	protected String nome;
	protected  int idade;
	protected  String dataNasc;
	protected  String cpf;
	protected  String nomeMae;
	protected  String nomePai;

	public Pessoa() {
	}
	
	public Pessoa(String nome, int idade, String dataNasc, String cpf, String nomeMae, String nomePai) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.dataNasc = dataNasc;
		this.cpf = cpf;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
	}

	public abstract double salario();
	
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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	
	
	public boolean restricaoIdade() {
		
		return idade >= 18;
	}

}
