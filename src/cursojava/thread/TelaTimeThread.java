package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

													
public class TelaTimeThread extends JDialog {

	private JPanel jPanel = new JPanel(new GridBagLayout()); // Painel de componentes

	// Componentes
	private JLabel descricaoHora = new JLabel("Time Thread 1");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricaoHora2 = new JLabel("Time Thread 2");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jbutton = new JButton("Start");
	private JButton jbutton2 = new JButton("Stop");

	//THREADS
	private Runnable thread1 =  new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private Runnable thread2 =  new Runnable() {
		
		@Override
		public void run() {
			while(true) {
				mostraTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh-mm-ss").format(Calendar.getInstance().getTime()));
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};
	
	private Thread threadTime1;
	private Thread threadTime2;
	
	public TelaTimeThread() {

		// Estrutura da caixa
		setTitle("Minha tela de time com thread");
		setSize(new Dimension(240, 240));
		setLocationRelativeTo(null);
		setResizable(false);
		// ***

		// Tela
		GridBagConstraints gridBagConstraints = new GridBagConstraints(); // Controla posicionamento de componentes
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2; // Componentes vão consumir dois espaços na tabela
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		descricaoHora.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoHora, gridBagConstraints);

		mostraTempo.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostraTempo.setEditable(false);
		jPanel.add(mostraTempo, gridBagConstraints);

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		mostraTempo2.setEditable(false);
		jPanel.add(mostraTempo2, gridBagConstraints);

		// Botões
		gridBagConstraints.gridwidth = 1; // Botões voltam a consumir 1 espaço na tabela.

		jbutton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(jbutton, gridBagConstraints);

		jbutton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jbutton2, gridBagConstraints);
		
		jbutton.addActionListener(new ActionListener() { // Executa o evento de clique no botão.
			
			@Override
			public void actionPerformed(ActionEvent e) {
				threadTime1 = new Thread(thread1);
				threadTime1.start();
				
				threadTime2 = new Thread(thread2);
				threadTime2.start();
				
				jbutton.setEnabled(false);
				jbutton2.setEnabled(true);
			}
		});
		
		jbutton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				threadTime1.stop();	
				threadTime2.stop();
				
				jbutton.setEnabled(true);
				jbutton2.setEnabled(false);
			}
		});
		
		jbutton2.setEnabled(false);
		
		add(jPanel, BorderLayout.WEST);

		setVisible(true); // Torna a tela visivel para o usuario.
	}
}
