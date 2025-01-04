package br.com.safeJourney.view.chatbot;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.Protocolo;
import br.com.safeJourney.util.RoundButton;
import br.com.safeJourney.util.Validacao;
import br.com.safeJourney.view.TelaCalcular;
import br.com.safeJourney.view.TelaCliente;
import br.com.safeJourney.view.TelaInicial;
import br.com.safeJourney.view.TelaLogin;

import java.awt.Color;
import java.awt.Cursor;

public class TelaSouSeguradoChatBot extends JFrame {
	private static TelaSouSeguradoChatBot instancia;
	
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField textFieldCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSouSeguradoChatBot frame = new TelaSouSeguradoChatBot();
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
	public TelaSouSeguradoChatBot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 425);
		
		ImagePanel panel = new ImagePanel("/backgroundimage.png");
		panel.setLayout(null);
		setContentPane(panel); 
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblTexto1 = new JLabel("O protocolo do seu atendimento é:");
		lblTexto1.setForeground(new Color(255, 255, 255));
		lblTexto1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTexto1.setBounds(229, 116, 234, 24);
		panel.add(lblTexto1);

		JLabel lblProtocolo = new JLabel();
		lblProtocolo.setForeground(new Color(255, 255, 255));
		String protocolo = Protocolo.gerarProtocolo();
		lblProtocolo.setText(protocolo);
		lblProtocolo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblProtocolo.setBounds(229, 150, 197, 24);
		panel.add(lblProtocolo);

		JLabel lblTexto2 = new JLabel("Digite o seu CPF:");
		lblTexto2.setForeground(new Color(255, 255, 255));
		lblTexto2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTexto2.setBounds(229, 198, 189, 24);
		panel.add(lblTexto2);

		textFieldCPF = new JTextField("582.818.668.02");
		textFieldCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCPF.setBounds(229, 232, 214, 33);
		panel.add(textFieldCPF);
		textFieldCPF.setColumns(10);

		JButton btnConfirma = new JButton("", new ImageIcon(getClass().getResource("/btnConfirmar.png")));
		btnConfirma.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnConfirma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocarComponentes(textFieldCPF.getText());
			}
		});
		btnConfirma.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirma.setBounds(229, 339, 223, 39);
		panel.add(btnConfirma);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/safira.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-17, 0, 250, 390);
		panel.add(lblNewLabel);
		
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

	private void trocarComponentes(String CampoCPF) {
		boolean validaCliente;
		String cpf = CampoCPF;

		ImagePanel panel = new ImagePanel("/backgroundimage.png");
		panel.setLayout(null);
		setContentPane(panel); 
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		AppController app = AppController.getInstance();
		validaCliente = Validacao.validaCPFCliente(app, cpf);
		panel.removeAll();

		if (validaCliente == true) {
			
			try {
				app.closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JLabel lblNewLabel = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/safira.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			lblNewLabel.setBounds(-17, 0, 250, 390);
			panel.add(lblNewLabel);
			
			JLabel lblTexto1 = new JLabel("Confirmamos seu cadastro ");
			lblTexto1.setForeground(new Color(255, 255, 255));
			lblTexto1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTexto1.setBounds(222, 111, 210, 24);
			panel.add(lblTexto1);

			JLabel lblTexto2 = new JLabel("Qual operacao voce deseja realizar");
			lblTexto2.setForeground(new Color(255, 255, 255));
			lblTexto2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTexto2.setBounds(222, 155, 242, 24);
			panel.add(lblTexto2);

			JButton btnApolice = new JButton("Veja suas Apólices");
			btnApolice.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnApolice.setBounds(222, 212, 210, 33);
			panel.add(btnApolice);
			btnApolice.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaLogin.main(null);
					instancia.dispose();
					TelaInicial.invocarTelaTelaInicial();
				}
			});

			JButton btnNewButton_2 = new JButton("Fale com um atendente");
			btnNewButton_2.setBounds(222, 273, 210, 33);
			panel.add(btnNewButton_2);
			
			JButton btnSair = new JButton("Sair");
			btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					instancia.dispose();
				}
			});
			btnSair.setBounds(417, 10, 63, 21);
			panel.add(btnSair);
			
		} else {
			
			JLabel lblNewLabel = new JLabel("");
			Image img = new ImageIcon(this.getClass().getResource("/safira.png")).getImage();
			lblNewLabel.setIcon(new ImageIcon(img));
			lblNewLabel.setBounds(-17, 0, 250, 390);
			panel.add(lblNewLabel);

			JLabel lblTexto1 = new JLabel("Vimos que você não tem cadastro ");
			lblTexto1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTexto1.setForeground(new Color(255, 255, 255));
			lblTexto1.setBounds(229, 175, 251, 24);
			panel.add(lblTexto1);
			
			JLabel lblTexto2 = new JLabel("Faça seu cadastro agora: ");
			lblTexto2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblTexto2.setForeground(new Color(255, 255, 255));
			lblTexto2.setBounds(229, 209, 238, 24);
			panel.add(lblTexto2);
			

			JButton btnCadastre = new JButton("Cadastrar-se");
			btnCadastre.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btnCadastre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnCadastre.setBounds(229, 281, 223, 39);
			panel.add(btnCadastre);
			
			JLabel lblOps = new JLabel("OPS!");
			lblOps.setForeground(Color.WHITE);
			lblOps.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblOps.setBounds(229, 141, 251, 24);
			panel.add(lblOps);
			
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

		panel.revalidate();
		panel.repaint();
	}
	
	public static void invocarTelaTelaSouSeguradoChatBot () {
		if (instancia == null) {

			instancia  = new TelaSouSeguradoChatBot();
			instancia.setVisible(true);
		}
	}
}
