package cursojava.thread;

import javax.swing.JOptionPane;

public class Threads {
	public static void main(String[] args){
		
		Thread threadEmail = new Thread(thread1);
		threadEmail.start(); // Inicia a thread para processo paralelo
		
		Thread threadNFC = new Thread(thread2);
		threadNFC.start();
	
		JOptionPane.showMessageDialog(null, "Rodando threads");
	}
	
public static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {

				System.out.println("Executando rotina, envio de nota fiscal");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	}; 
			
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {

				System.out.println("Executando rotina, envio de email");
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
	};

}
