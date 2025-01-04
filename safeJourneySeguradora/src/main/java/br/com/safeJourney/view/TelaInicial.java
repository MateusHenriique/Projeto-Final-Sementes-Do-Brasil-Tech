package br.com.safeJourney.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.RoundButton;
import br.com.safeJourney.view.chatbot.TelaInicialChatbot;

public class TelaInicial extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static TelaInicial frame;
	private final JTextField textField = new JTextField();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = TelaInicial.getInstance();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static TelaInicial getInstance() {
		if (frame == null) {
			frame = new TelaInicial(); 
			} 
		return frame;
	}

	public TelaInicial() {
		initialize();
	}

	private void initialize() {
	
		textField.setColumns(10);
		setBounds(100, 100, 1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImagePanel panel = new ImagePanel("/backgroundimage.png");
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("SEGURO VIAGEM INTERNACIONAL");
		lblNewLabel.setBackground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(96, 267, 290, 29);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Pensou em viajar?");
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(96, 304, 290, 44);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Crie memórias");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(860, 326, 251, 46);
		panel.add(lblNewLabel_2);

		JButton btnContrateOnline = new RoundButton("CONTRATE ONLINE",
				new ImageIcon(getClass().getResource("/btnContrateOnline.png")));
		btnContrateOnline.setText("");
		btnContrateOnline.setForeground(new Color(255, 255, 255));
		btnContrateOnline.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnContrateOnline.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btnContrateOnline.setBackground(UIManager.getColor("control"));
			}
		});
		btnContrateOnline.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnContrateOnline.setBackground(new Color(0, 0, 0, 0)); // Define fundo transparente
		btnContrateOnline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCalcular.invocarTelaCalcular();
				frame.dispose();
			}
		});
		btnContrateOnline.setBounds(96, 444, 134, 55);
		panel.add(btnContrateOnline);

		JLabel lblNewLabel_3 = new JLabel("Contrate o Seguro Viagem Internacional Safe");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(96, 359, 346, 23);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_6 = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/imagemtelainicial.png")).getImage();
		lblNewLabel_6.setIcon(new ImageIcon(img));
		lblNewLabel_6.setBounds(443, 159, 392, 447);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_8 = new JLabel("Journey! Você viaja tranquilo com o amparo de");
		lblNewLabel_8.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_8.setForeground(new Color(255, 255, 255));
		lblNewLabel_8.setBounds(96, 382, 346, 17);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("uma das maiores Seguradoras do mundo.");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9.setForeground(new Color(255, 255, 255));
		lblNewLabel_9.setBounds(96, 389, 318, 44);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("com a SafeJourney!");
		lblNewLabel_10.setFont(new Font("Segoe UI", Font.BOLD, 32));
		lblNewLabel_10.setForeground(new Color(255, 255, 255));
		lblNewLabel_10.setBounds(860, 371, 331, 44);
		panel.add(lblNewLabel_10);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(255, 255, 255));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1266, 68);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lbLogo = new JLabel();
		lbLogo.setBounds(31, 0, 162, 71);
		panel_1.add(lbLogo);
		Image img2 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lbLogo.setIcon(new ImageIcon(img2));

		JButton btnAreaCorretor = new RoundButton("ÁREA DO CORRETOR",
				new ImageIcon(getClass().getResource("/btnAreaCorretor.png")));
		btnAreaCorretor.setForeground(new Color(0, 0, 0));
		btnAreaCorretor.setText("");
		btnAreaCorretor.setBounds(818, 5, 162, 55);
		panel_1.add(btnAreaCorretor);
		btnAreaCorretor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAreaCorretor.setBackground(new Color(0, 0, 0, 0));
		btnAreaCorretor.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btnAreaCorretor.setBackground(UIManager.getColor("control"));
			}
		});
		btnAreaCorretor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				TelaLoginCorretor.main(null); 
			}
		});

		JButton btnAreaCliente = new RoundButton("ÁREA DO CLIENTE",
				new ImageIcon(getClass().getResource("/btnAreaCliente.png")));
		btnAreaCliente.setForeground(new Color(255, 255, 255));
		btnAreaCliente.setText("");
		btnAreaCliente.setBounds(1007, 5, 162, 55);
		panel_1.add(btnAreaCliente);
		btnAreaCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAreaCliente.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent e) {
				btnAreaCliente.setBackground(UIManager.getColor("control"));
			}
		});
		btnAreaCliente.setBackground(new Color(255, 255, 255));
		btnAreaCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLogin.main(null); // Abre a tela inicial
				frame.dispose(); // Fecha a janela atual
			}
		});

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 30, 196));
		panel_2.setBounds(0, 68, 1266, 3);
		panel.add(panel_2);

		// Atualiza o tamanho preferido do painel para permitir a rolagem
		panel.setPreferredSize(new java.awt.Dimension(0, 1190));

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(new Color(17, 74, 170));
		panel_2_1.setBounds(0, 670, 1266, 523);
		panel.add(panel_2_1);
		panel_2_1.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("Seguro Viagem");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblNewLabel_4.setBackground(new Color(255, 255, 255));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(564, 64, 106, 18);
		panel_2_1.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Benefícios");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblNewLabel_5.setBackground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(558, 105, 112, 30);
		panel_2_1.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel(
				"Independente do seu destino, os benefícios do Seguro Viagem SafeJourney foram pensados para você ter proteção e tranquilidade para aproveitar");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_7.setForeground(new Color(255, 255, 255));
		lblNewLabel_7.setBounds(123, 146, 996, 20);
		panel_2_1.add(lblNewLabel_7);

		JLabel lblNewLabel_11 = new JLabel(
				"ainda mais as suas viagens internacionais. Conheça os principais benefícios para viajar tranquilo:");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(280, 169, 653, 18);
		panel_2_1.add(lblNewLabel_11);

		JLabel lblNewLabel_15 = new JLabel();
		Image img3 = new ImageIcon(this.getClass().getResource("/beneficioAtendimentoMedico.png")).getImage();
		lblNewLabel_15.setIcon(new ImageIcon(img3));
		lblNewLabel_15.setBounds(911, 231, 235, 235);
		panel_2_1.add(lblNewLabel_15);

		JLabel lblNewLabel_15_1 = new JLabel();
		Image img4 = new ImageIcon(this.getClass().getResource("/beneficioCOVID.png")).getImage();
		lblNewLabel_15_1.setIcon(new ImageIcon(img4));
		lblNewLabel_15_1.setBounds(640, 231, 235, 235);
		panel_2_1.add(lblNewLabel_15_1);

		JLabel lblNewLabel_15_2 = new JLabel();
		Image img5 = new ImageIcon(this.getClass().getResource("/beneficioDespesasMedicas.png")).getImage();
		lblNewLabel_15_2.setIcon(new ImageIcon(img5));
		lblNewLabel_15_2.setBounds(371, 231, 235, 235);
		panel_2_1.add(lblNewLabel_15_2);

		JLabel lblNewLabel_15_3 = new JLabel();
		Image img6 = new ImageIcon(this.getClass().getResource("/beneficioHospital.png")).getImage();
		lblNewLabel_15_3.setIcon(new ImageIcon(img6));
		lblNewLabel_15_3.setBounds(94, 231, 232, 235);
		panel_2_1.add(lblNewLabel_15_3);

		JLabel lblNewLabel_12_1 = new JLabel();
		Image img9 = new ImageIcon(this.getClass().getResource("/traçoAmarelo.png")).getImage();
		lblNewLabel_12_1.setIcon(new ImageIcon(img9));
		lblNewLabel_12_1.setBounds(574, 81, 75, 30);
		panel_2_1.add(lblNewLabel_12_1);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(0, 294, 1276, 229);
		panel_2_1.add(panel_3);

		JLabel lblNewLabel_12 = new JLabel();
		Image img7 = new ImageIcon(this.getClass().getResource("/traçoAmarelo.png")).getImage();
		lblNewLabel_12.setIcon(new ImageIcon(img7));
		lblNewLabel_12.setBounds(96, 224, 75, 44);
		panel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel();
		Image img8 = new ImageIcon(this.getClass().getResource("/traçoAmarelo2.png")).getImage();
		lblNewLabel_13.setIcon(new ImageIcon(img8));
		lblNewLabel_13.setBounds(860, 427, 318, 23);
		panel.add(lblNewLabel_13);

		JButton btnChatBot = new RoundButton("CHAT BOT", new ImageIcon(getClass().getResource("/btnChatBot.png")));
		btnChatBot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicialChatbot.invocarTelaTelaInicialChatBot();
			}
		});
		btnChatBot.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnChatBot.setText("");
		btnChatBot.setBounds(1140, 569, 90, 90);
		panel.add(btnChatBot);
	}
	public static void invocarTelaTelaInicial() {
		if (frame == null) {

			frame = new TelaInicial();
			frame.setVisible(true);

		}
	}
}
