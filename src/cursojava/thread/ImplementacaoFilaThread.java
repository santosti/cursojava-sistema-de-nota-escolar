package cursojava.thread;

import java.util.concurrent.ConcurrentLinkedQueue;

import java.util.Iterator;

public class ImplementacaoFilaThread extends Thread {

	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}

	@Override
	public void run() {

		System.out.println("Fila rodando");

		while (true) {
			
			Iterator iteracao = pilha_fila.iterator();
			
			synchronized (iteracao) { // Bloquear o acesso a lista por outros processos.

				while (iteracao.hasNext()) { // Em quanto existir dados na lista irá processar.

					ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();

					System.out.println("-------------------------------");
					System.out.println(processar.getNome());
					System.out.println(processar.getEmail());

					iteracao.remove();

					try {
						Thread.sleep(1000); // Tempo para descarga de memoria.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(1000); // Tempo para limpeza de memoria após o processamento da lista.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
