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
	private JLabel descricaoHora = new JLabel("Nome");
	private JTextField mostraTempo = new JTextField();

	private JLabel descricaoHora2 = new JLabel("E-mail");
	private JTextField mostraTempo2 = new JTextField();

	private JButton jbutton = new JButton("Add lista");
	private JButton jbutton2 = new JButton("Stop");

	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

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
		jPanel.add(mostraTempo, gridBagConstraints);

		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoHora2, gridBagConstraints);

		mostraTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
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
				
				if (fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}

				for (int i = 0; i <= 100; i++) {

					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraTempo.getText());
					filaThread.setEmail(mostraTempo2.getText() + " - " + i);

					fila.add(filaThread);
				}
			}
		});

		jbutton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
		});

		fila.start();

		add(jPanel, BorderLayout.WEST);

		setVisible(true); // Torna a tela visivel para o usuario.
	}
}
