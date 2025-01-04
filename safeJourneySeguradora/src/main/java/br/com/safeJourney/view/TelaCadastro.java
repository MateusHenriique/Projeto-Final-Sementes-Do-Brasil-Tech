package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.Cliente;
import br.com.safeJourney.util.BackgroundPanel;
import br.com.safeJourney.util.Criptografia;
import br.com.safeJourney.util.RoundButton;

public class TelaCadastro extends JFrame {

	private JPanel panel_1;
	private JFrame frame;
	private JTextField textFieldNomeCliente;
	private JTextField textFieldEmailCliente;
	private JTextField textFieldTelefoneCliente;
	private JTextField textFieldDataNascCliente;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField;
	private JComboBox<String> comboBoxSexo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaCadastro window = new TelaCadastro();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {
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

		JLabel lblNewLabel_3 = new JLabel("Nome Completo:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(161, 24, 122, 21);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("Email:");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(199, 102, 47, 21);
		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("Telefone:");
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(191, 180, 62, 21);
		panel_1.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("Sexo:");
		lblNewLabel_3_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(205, 336, 35, 21);
		panel_1.add(lblNewLabel_3_3);

		textFieldNomeCliente = new JTextField();
		textFieldNomeCliente.setToolTipText("Nome Completo");
		textFieldNomeCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldNomeCliente.setColumns(10);
		textFieldNomeCliente.setBounds(95, 56, 255, 35);
		panel_1.add(textFieldNomeCliente);

		textFieldEmailCliente = new JTextField();
		textFieldEmailCliente.setToolTipText("Email");
		textFieldEmailCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldEmailCliente.setColumns(10);
		textFieldEmailCliente.setBounds(95, 134, 255, 35);
		panel_1.add(textFieldEmailCliente);

		textFieldTelefoneCliente = new JTextField();
		textFieldTelefoneCliente.setToolTipText("Telefone");
		textFieldTelefoneCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldTelefoneCliente.setColumns(10);
		textFieldTelefoneCliente.setBounds(95, 212, 255, 35);
		panel_1.add(textFieldTelefoneCliente);

		String[] sexOptions = { "", "Masculino", "Feminino" };
		comboBoxSexo = new JComboBox<>(sexOptions);
		comboBoxSexo.setBounds(95, 368, 255, 35);
		panel_1.add(comboBoxSexo);
		comboBoxSexo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBoxSexo.setFocusable(false);
		comboBoxSexo.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (isSelected) {
					c.setBackground(Color.LIGHT_GRAY); // Cor do item selecionado
					c.setForeground(Color.BLACK); // Cor do texto do item selecionado
				} else {
					c.setBackground(Color.WHITE); // Fundo branco para outros itens
					c.setForeground(Color.BLACK); // Texto preto para outros itens
				}
				return c;
			}
		});

		JButton btnSeta = new RoundButton("", new ImageIcon(getClass().getResource("/btnseta.png")));
		btnSeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeta.setBounds(166, 463, 115, 78);
		panel_1.add(btnSeta);
		btnSeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				telaSenha(textFieldNomeCliente.getText(),
						textFieldDataNascCliente.getText(), textFieldEmailCliente.getText(),
						textFieldTelefoneCliente.getText(), comboBoxSexo.getSelectedItem().toString());
			}
		});

		JCheckBox chckbxNewCheckBox = new JCheckBox("Ao pressionar o botão você aceita nossos");
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setToolTipText("");
		chckbxNewCheckBox.setBounds(90, 420, 265, 20);
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					textFieldNomeCliente.setText("Guilherme Santos da Costa");
					textFieldEmailCliente.setText("guisantoscosta9@gmail.com");
					textFieldTelefoneCliente.setText("(11) 95121-0882");
					textFieldDataNascCliente.setText("13/10/2006");
				} else {
					textFieldNomeCliente.setText("");
					textFieldEmailCliente.setText("");
					textFieldTelefoneCliente.setText("");
					textFieldDataNascCliente.setText("");
				}
			}
		});

		JLabel lblNewLabel_4 = new JLabel("termos e condições");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setBounds(163, 439, 118, 17);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_3_4 = new JLabel("Data de Nascimento:");
		lblNewLabel_3_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(150, 258, 144, 21);
		panel_1.add(lblNewLabel_3_4);

		textFieldDataNascCliente = new JTextField();
		textFieldDataNascCliente.setToolTipText("Data de Nascimento");
		textFieldDataNascCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldDataNascCliente.setColumns(10);
		textFieldDataNascCliente.setBounds(95, 290, 255, 35);
		panel_1.add(textFieldDataNascCliente);

		frame.setLocationRelativeTo(null);
	}

	public void telaSenha(String nomeCliente, String dataNascCliente,
			String emailCliente, String telefoneCliente, String generoCliente) {
		panel_1.removeAll();
		JLabel lblNewLabel_3 = new JLabel("Vamos criar sua senha de acesso! Para");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_3.setBounds(90, 50, 264, 14);
		panel_1.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("começar preencha as informações abaixo:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(78, 60, 289, 25);
		panel_1.add(lblNewLabel_4);

		JLabel lblNewLabel_3_1 = new JLabel("CPF:");
		lblNewLabel_3_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(204, 96, 37, 21);
		panel_1.add(lblNewLabel_3_1);
		JTextField textFieldCpfCliente = new JTextField("580.757.038-39");
		textFieldCpfCliente.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textFieldCpfCliente.setBounds(95, 128, 255, 35);
		panel_1.add(textFieldCpfCliente);

		JLabel lblNewLabel_3_2 = new JLabel("Senha:");
		lblNewLabel_3_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(198, 209, 49, 21);
		panel_1.add(lblNewLabel_3_2);
		passwordField = new JPasswordField("123456");
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		passwordField.setBounds(95, 241, 255, 35);
		panel_1.add(passwordField);

		JLabel lblNewLabel_3_4 = new JLabel("Confirmar Senha:");
		lblNewLabel_3_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(163, 323, 118, 21);
		panel_1.add(lblNewLabel_3_4);
		
		passwordField_1 = new JPasswordField("123456");
		passwordField_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		passwordField_1.setBounds(95, 355, 255, 35);
		panel_1.add(passwordField_1);

		JButton btnSeta2 = new RoundButton("", new ImageIcon(getClass().getResource("/btnseta.png")));
		btnSeta2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSeta2.setBounds(165, 427, 115, 78);
		panel_1.add(btnSeta2);
		btnSeta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrarCliente(textFieldCpfCliente.getText(), nomeCliente, dataNascCliente,
						emailCliente, telefoneCliente, generoCliente,
						passwordField.getText());
				frame.dispose();
				TelaLoginCadastroApolice.main(null); // Abre a tela de login

			}

		});

		panel_1.revalidate();
		panel_1.repaint();
	}

	public static void cadastrarCliente(String cpfCliente, String nomeCliente, String dataNascCliente,
			String emailCliente, String telefoneCliente, String generoCliente, String senhaCliente) {
		
		Cliente cliente = new Cliente(cpfCliente, nomeCliente, dataNascCliente,
				emailCliente, telefoneCliente, generoCliente, senhaCliente);
		AppController app = AppController.getInstance();
		
		app.cadastrarCliente(cliente);
		
	}

}
