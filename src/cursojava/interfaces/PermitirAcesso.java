package cursojava.interfaces;

public interface PermitirAcesso {
	
	public boolean autenticar();
	public boolean autenticar(String usuario, String senha); // Apenas declaração do método.
}
