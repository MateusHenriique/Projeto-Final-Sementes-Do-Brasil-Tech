package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.util.BackgroundPanel;
import br.com.safeJourney.util.RoundButton;
import br.com.safeJourney.util.Validacao;

public class TelaLoginCorretor {

	private JPanel panel_1;
	JFrame frame;
	private JTextField textFieldCPF;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaLoginCorretor window = new TelaLoginCorretor();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLoginCorretor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1264, 92);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel();
		Image img3 = new ImageIcon(this.getClass().getResource("/logoMaior.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(534, 2, 196, 87);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel = new JLabel();
		Image img = new ImageIcon(this.getClass().getResource("/aviao.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(0, 91, 410, 590);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel();
		Image img1 = new ImageIcon(this.getClass().getResource("/imgemTelaCadastro.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(854, 91, 410, 590);
		frame.getContentPane().add(lblNewLabel_1);

		panel_1 = new BackgroundPanel("/imagemDadosCadastro.png");
		panel_1.setBounds(409, 91, 445, 590);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(207, 166, 30, 21);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Senha:");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(199, 284, 47, 21);
		panel_1.add(lblNewLabel_3_1);

		textFieldCPF = new JTextField("537.440.838-02");
		textFieldCPF.setToolTipText("");
		textFieldCPF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(95, 198, 255, 35);
		panel_1.add(textFieldCPF);

		JButton btnSeta = new RoundButton("", new ImageIcon(getClass().getResource("/btnseta.png")));
		btnSeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeta.setBounds(165, 424, 115, 78);
		panel_1.add(btnSeta);
		btnSeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validaCorretor(textFieldCPF.getText(), passwordFieldSenha.getText());
			}
			
		});
		passwordFieldSenha = new JPasswordField("123456");
		passwordFieldSenha.setBounds(95, 322, 255, 35);
		panel_1.add(passwordFieldSenha);
		
		JLabel lblNewLabel_4 = new JLabel("Acesse os Portais da SafeJourney");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_4.setBounds(70, 71, 319, 29);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("(Restrito aos corretores).");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_5.setBounds(116, 101, 212, 21);
		panel_1.add(lblNewLabel_5);

		frame.setLocationRelativeTo(null);
	}
	
	public void validaCorretor(String cpf, String senha) {
		AppController app = AppController.getInstance();
		boolean validaCPFCorretor = Validacao.validaCPFCorretor(app, cpf);
		boolean validaSenhaCorretor = Validacao.validaSenhaCorretor(app, cpf, senha);
		if (validaCPFCorretor && validaSenhaCorretor) {
			JOptionPane.showMessageDialog(null, "Logado");
			TelaCorretor.main(null);
			frame.dispose();
		}else if (validaCPFCorretor && !validaSenhaCorretor) {
			JOptionPane.showMessageDialog(null, "Senha invalida");
			passwordFieldSenha.setText("");
		}
	}
}