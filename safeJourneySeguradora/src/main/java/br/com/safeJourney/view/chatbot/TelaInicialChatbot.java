package br.com.safeJourney.view.chatbot;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.RoundButton;

public class TelaInicialChatbot extends JFrame {

	private static TelaInicialChatbot instancia;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static TelaInicialChatbot frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaInicialChatbot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicialChatbot() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 425);
		
		ImagePanel panel = new ImagePanel("/backgroundimage.png");
		panel.setLayout(null);
		setContentPane(panel); 
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		JLabel lblNewLabel = new JLabel("Bem vindo ao nosso atendimento 24 horas");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(226, 82, 254, 41);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Eu sou a safira ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(226, 121, 264, 41);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("para que eu possa te ajudar ");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(226, 155, 254, 41);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Clique em uma das opções abaixo");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(226, 188, 223, 41);
		panel.add(lblNewLabel_3);

		JButton btnCotacaoMoeda = new RoundButton("Cotação de moedas",  new ImageIcon(getClass().getResource("/btnCotacaoMoeda.png")));
		btnCotacaoMoeda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCotacaoMoeda.setText("");
		btnCotacaoMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCotacaoMoedaChatBot.invocarTelaCotacaoMoedaChatBot();
				instancia.dispose();
			}
		});
		btnCotacaoMoeda.setBounds(226, 244, 210, 33);
		panel.add(btnCotacaoMoeda);

		JButton btnSouSegurado = new RoundButton("Já sou Segurado", new ImageIcon(getClass().getResource("/btnJaSouSegurado.png")));
		btnSouSegurado.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSouSegurado.setText("");
		btnSouSegurado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSouSeguradoChatBot.invocarTelaTelaSouSeguradoChatBot();
				instancia.dispose();

			}
		});
		btnSouSegurado.setBounds(226, 287, 210, 33);
		panel.add(btnSouSegurado);

		JButton btnNaoSouSegurado = new RoundButton("Ainda não sou Segurado", new ImageIcon(getClass().getResource("/btnAindaNaoSouSegurado.png")));
		btnNaoSouSegurado.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNaoSouSegurado.setText("");
		btnNaoSouSegurado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaNaoSouSeguradoChatBot.invocarTelaTelaNaoSouClienteChatBot();
				instancia.dispose();
			}
		});
		btnNaoSouSegurado.setBounds(226, 330, 210, 33);
		panel.add(btnNaoSouSegurado);

		JLabel lblImgSafira = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/safira.png")).getImage();
		lblImgSafira.setIcon(new ImageIcon(img));
		lblImgSafira.setBounds(-17, 0, 250, 390);

		panel.add(lblImgSafira);
		
		JButton btnSair = new RoundButton("", new ImageIcon(getClass().getResource("/btnSair.png")));
		btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instancia.dispose();
			}
		});
		btnSair.setBounds(401, 10, 79, 33);
		panel.add(btnSair);

	}

	public static void invocarTelaTelaInicialChatBot() {
		if (instancia == null) {

			instancia = new TelaInicialChatbot();
		}
			instancia.setVisible(true);
			
	}
}
