package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.util.RoundButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaParabens extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaParabens frame = new TelaParabens();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaParabens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 1264, 63);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(535, -4, 194, 71);
		Image img = new ImageIcon(this.getClass().getResource("/logoMaior.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		panel.add(lblLogo);

		JButton btnVoltarInicio = new RoundButton("VOLTAR A TELA INICIAL",
				new ImageIcon(getClass().getResource("/btnIncio.png")));
		btnVoltarInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltarInicio.setForeground(new Color(0, 0, 0));
		btnVoltarInicio.setText("");
		btnVoltarInicio.setBounds(1082, 0, 182, 60);
		panel.add(btnVoltarInicio);
		btnVoltarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Fecha a janela atual
				TelaInicial.main(null); // Abre a tela inicial
			}
		});

		JLabel lblNewLabel = new JLabel();
		Image img2 = new ImageIcon(this.getClass().getResource("/parabens.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(0, 64, 1264, 617);
		contentPane.add(lblNewLabel);

		setLocationRelativeTo(null); // Centraliza a janela
	}
}
