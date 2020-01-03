package cursojava.entidades;

import cursojava.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargo;
	private String experiencia;

	private String usuario;
	private String senha;

	public Secretario() {
	}

	public Secretario(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
	}

	public Secretario(String nome, int idade, String dataNasc, String cpf, String nomeMae, String nomePai) {
		super(nome, idade, dataNasc, cpf, nomeMae, nomePai);
	}

	public String getRegistro() {
		return registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public String toString() {
		return "Secretario [registro=" + registro + ", nivelCargo=" + nivelCargo + ", experiencia=" + experiencia
				+ ", nome=" + nome + ", idade=" + idade + ", dataNasc=" + dataNasc + ", cpf=" + cpf + ", nomeMae="
				+ nomeMae + ", nomePai=" + nomePai + "]";
	}

	@Override
	public boolean restricaoIdade() {
		return idade >= 30;
	}

	@Override
	public double salario() {
		return 1550.00;
	}

	@Override
	public boolean autenticar(String usuario, String senha) {
		this.usuario = usuario;
		this.senha = senha;
		return autenticar();
	}

	@Override
	public boolean autenticar() {
		return usuario.equals("secretario") && senha.equals("admin");
	}

}
