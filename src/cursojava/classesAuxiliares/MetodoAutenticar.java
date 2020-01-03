package cursojava.classesAuxiliares;

import cursojava.interfaces.PermitirAcesso;

public class MetodoAutenticar {
	
	private PermitirAcesso permitirAcesso;
	
	public boolean autenticarSistema() {
		return permitirAcesso.autenticar();
	}
	
	public MetodoAutenticar(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}
}
