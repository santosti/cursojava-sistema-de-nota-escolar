package cursojava.executavel;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {
		String texto = "Simone, curso Java, 80, 70, 55, 90";
		// Split é o método para separar itens de um array de String.
		String[] valorTexto = texto.split(",");

		//System.out.println(valorTexto);

//Converter array em lista.

		List<String> lista = Arrays.asList(valorTexto);
		
		for (String valorString : lista) {
			System.out.println(valorString);
		}
		
		
//Convertendo lista em Array
		
		String[] conversaoArray = lista.toArray(new String[5]);
		for (int i = 0; i < conversaoArray.length; i++) {
				System.out.println(conversaoArray[i]);
			}
		}
	}


