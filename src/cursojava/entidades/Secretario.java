package cursojava.entidades;

public class Secretario extends Pessoa {

	private String registro;
	private String nivelCargo;
	private String experiencia;

	public Secretario() {
		super();
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

}
