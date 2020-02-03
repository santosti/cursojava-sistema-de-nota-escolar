package cursojava.executavel;

public class Matriz {
	public static void main(String[] args) {
		
		int[][] notas = new int[2][4];
		
		notas[0][0] = 80;
		notas[0][1] = 65;
		notas[0][2] = 64;
		notas[0][3] = 87;
		
		notas[1][0] = 70;
		notas[1][1] = 75;
		notas[1][2] = 30;
		notas[1][3] = 45;
		
		for (int i = 0; i < notas.length; i++) {
			System.out.println();
			for (int j = 0; j < notas[i].length; j++) {
				System.out.println("Valor da matriz de notas: " + notas[i][j]);
			}
		}
		
	}
}
