package br.com.safeJourney.view;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.Cliente;
import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.RoundButton;

public class TelaCorretor extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldConsultar;
	private JTextField textFieldNome;
	private JTextField textFieldTelefone;
	private JTextField textFieldEmail;
	private JTextField textFieldAtualizar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textFieldDeletar;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaCorretor frame = new TelaCorretor();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public TelaCorretor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);

		ImagePanel panel = new ImagePanel("/fundoNuvem.png");
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setLayout(null);

		// Painel superior
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1264, 82);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLogo = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblLogo.setIcon(new ImageIcon(img));
		lblLogo.setBounds(20, 23, 159, 47);
		panel_1.add(lblLogo);

		JLabel lblTitulo = new JLabel("ÁREA DO CORRETOR");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(new Color(0, 0, 0));
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblTitulo.setBounds(492, 11, 279, 59);
		panel_1.add(lblTitulo);
		
		JButton btnVoltarInicio = new RoundButton("", new ImageIcon(getClass().getResource("/btnIncio.png")));
		btnVoltarInicio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnVoltarInicio.setBounds(1072, 10, 182, 60);
		panel_1.add(btnVoltarInicio);
		btnVoltarInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Fecha a janela atual
				TelaInicial.main(null); // Abre a tela inicial
			}
		});
		

		// Campos e botões
		JLabel lblConsultarCliente = new JLabel("Consulte o cliente:");
		lblConsultarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultarCliente.setForeground(Color.WHITE);
		lblConsultarCliente.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblConsultarCliente.setBounds(160, 123, 195, 22);
		panel.add(lblConsultarCliente);

		JLabel lblCpfCliente = new JLabel("CPF:");
		lblCpfCliente.setForeground(Color.WHITE);
		lblCpfCliente.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblCpfCliente.setBounds(66, 155, 52, 39);
		panel.add(lblCpfCliente);

		textFieldConsultar = new JTextField("582.818.668-02");
		textFieldConsultar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textFieldConsultar.setBounds(121, 156, 290, 39);
		panel.add(textFieldConsultar);

		JButton btnBuscar = new RoundButton("buscar", new ImageIcon(getClass().getResource("/btnBuscar.png")));
		btnBuscar.setText("");
		btnBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBuscar.setBounds(170, 219, 170, 50);
		panel.add(btnBuscar);

		JLabel lblDadosEncontradoCliente = new JLabel("Dados encontrados:");
		lblDadosEncontradoCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosEncontradoCliente.setForeground(Color.WHITE);
		lblDadosEncontradoCliente.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblDadosEncontradoCliente.setBounds(170, 320, 195, 22);
		panel.add(lblDadosEncontradoCliente);

		JLabel lblNomeCliente = new JLabel("Nome:");
		lblNomeCliente.setForeground(new Color(255, 255, 255));
		lblNomeCliente.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblNomeCliente.setBounds(45, 394, 66, 39);
		panel.add(lblNomeCliente);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textFieldNome.setBounds(121, 395, 290, 39);
		panel.add(textFieldNome);

		JLabel lblNumeroCliente = new JLabel("Telefone:");
		lblNumeroCliente.setForeground(new Color(255, 255, 255));
		lblNumeroCliente.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblNumeroCliente.setBounds(19, 459, 99, 39);
		panel.add(lblNumeroCliente);

		textFieldTelefone = new JTextField();
		textFieldTelefone.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textFieldTelefone.setBounds(121, 460, 290, 39);
		panel.add(textFieldTelefone);

		JLabel lblEmailCliente = new JLabel("E-mail:");
		lblEmailCliente.setForeground(new Color(255, 255, 255));
		lblEmailCliente.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblEmailCliente.setBounds(43, 527, 75, 39);
		panel.add(lblEmailCliente);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textFieldEmail.setBounds(121, 528, 290, 39);
		panel.add(textFieldEmail);

		JLabel lblUpdateCliente = new JLabel("Atualizar Cliente:");
		lblUpdateCliente.setForeground(new Color(255, 255, 255));
		lblUpdateCliente.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblUpdateCliente.setBounds(619, 123, 159, 22);
		panel.add(lblUpdateCliente);

		textFieldAtualizar = new JTextField();
		textFieldAtualizar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textFieldAtualizar.setBounds(551, 155, 290, 39);
		panel.add(textFieldAtualizar);

		JButton btnBuscar2 = new RoundButton("buscar", new ImageIcon(getClass().getResource("/btnBuscar.png")));
		btnBuscar2.setText("");
		btnBuscar2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnBuscar2.setBounds(605, 219, 170, 50);
		panel.add(btnBuscar2);

		JLabel lblDadosEncontradoCliente_1 = new JLabel("Altere os dados abaixo:");
		lblDadosEncontradoCliente_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDadosEncontradoCliente_1.setForeground(Color.WHITE);
		lblDadosEncontradoCliente_1.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblDadosEncontradoCliente_1.setBounds(583, 320, 219, 22);
		panel.add(lblDadosEncontradoCliente_1);

		JLabel lblNomeCliente_1 = new JLabel("Nome:");
		lblNomeCliente_1.setForeground(Color.WHITE);
		lblNomeCliente_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblNomeCliente_1.setBounds(475, 394, 66, 39);
		panel.add(lblNomeCliente_1);

		JLabel lblCpfCliente_1 = new JLabel("CPF:");
		lblCpfCliente_1.setForeground(Color.WHITE);
		lblCpfCliente_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblCpfCliente_1.setBounds(489, 155, 52, 39);
		panel.add(lblCpfCliente_1);

		JLabel lblNumeroCliente_1 = new JLabel("Telefone:");
		lblNumeroCliente_1.setForeground(Color.WHITE);
		lblNumeroCliente_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblNumeroCliente_1.setBounds(450, 459, 99, 39);
		panel.add(lblNumeroCliente_1);

		JLabel lblEmailCliente_1 = new JLabel("E-mail:");
		lblEmailCliente_1.setForeground(Color.WHITE);
		lblEmailCliente_1.setFont(new Font("Segoe UI", Font.BOLD, 21));
		lblEmailCliente_1.setBounds(475, 527, 75, 39);
		panel.add(lblEmailCliente_1);

		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textField.setBounds(551, 394, 290, 39);
		panel.add(textField);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textField_1.setBounds(551, 460, 290, 39);
		panel.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textField_2.setBounds(551, 528, 290, 39);
		panel.add(textField_2);

		JButton btnAtualizarCliente = new RoundButton("Atualizar",
				new ImageIcon(getClass().getResource("/btnAtualizar.png")));
		btnAtualizarCliente.setText("");
		btnAtualizarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnAtualizarCliente.setBounds(605, 588, 170, 50);
		panel.add(btnAtualizarCliente);

		// Botão deletar
		JLabel lblDeletarCliente = new JLabel("Deletar Cliente:");
		lblDeletarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletarCliente.setForeground(Color.WHITE);
		lblDeletarCliente.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblDeletarCliente.setBounds(1010, 123, 159, 22);
		panel.add(lblDeletarCliente);

		textFieldDeletar = new JTextField();
		textFieldDeletar.setFont(new Font("Segoe UI", Font.BOLD, 18));
		textFieldDeletar.setBounds(943, 155, 290, 39);
		panel.add(textFieldDeletar);

		JButton btnDeletarCliente = new RoundButton("Deletar",
				new ImageIcon(getClass().getResource("/btnDeletar.png")));
		btnDeletarCliente.setText("");
		btnDeletarCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnDeletarCliente.setBounds(998, 219, 170, 50);
		panel.add(btnDeletarCliente);
		
		// Ação do botão Buscar (para consulta de dados do cliente)
		btnBuscar.addActionListener(e -> consultarCliente());

		// Ação do botão Buscar (para atualizar os dados)
		btnBuscar2.addActionListener(e -> buscarAtualizarCliente());

		// Ação do botão Atualizar Cliente
		btnAtualizarCliente.addActionListener(e -> atualizarCliente());
		
		btnDeletarCliente.addActionListener(e -> deletarCliente());
	}

	// Método de consulta do cliente
	private void consultarCliente() {
		String cpf = textFieldConsultar.getText();

		if (cpf.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o CPF!");
			return;
		}

		AppController app = AppController.getInstance();
		Cliente cliente = app.buscarClientePorCPF(cpf);

		if (cliente != null) {
			// Preenche os campos com os dados do cliente
			textFieldNome.setText(cliente.getNomeCliente());
			textFieldTelefone.setText(cliente.getTelefoneCliente());
			textFieldEmail.setText(cliente.getEmailCliente());
		} else {
			JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
			limparCampos();
		}
	}

	// Método para buscar cliente para atualizar
	private void buscarAtualizarCliente() {
		String cpf = textFieldAtualizar.getText();

		if (cpf.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o CPF!");
			return;
		}

		AppController app = AppController.getInstance();
		Cliente cliente = app.buscarClientePorCPF(cpf);

		if (cliente != null) {
			// Preenche os campos com os dados do cliente
			textField.setText(cliente.getNomeCliente());
			textField_1.setText(cliente.getTelefoneCliente());
			textField_2.setText(cliente.getEmailCliente());
		} else {
			JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
			limparCampos();
		}
	}

	// Método de atualização do cliente
	private void atualizarCliente() {
		String cpf = textFieldAtualizar.getText();

		if (cpf.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o CPF!");
			return;
		}

		AppController app = AppController.getInstance();
		Cliente cliente = app.buscarClientePorCPF(cpf);

		if (cliente != null) {
			// Pega os dados alterados
			String nomeAlterado = textField.getText();
			String telefoneAlterado = textField_1.getText();
			String emailAlterado = textField_2.getText();

			// Atualiza os dados do cliente
			cliente.setNomeCliente(nomeAlterado);
			cliente.setTelefoneCliente(telefoneAlterado);
			cliente.setEmailCliente(emailAlterado);

			// Atualiza o cadastro no banco
			app.atualizarCadastroCliente(cliente);
			JOptionPane.showMessageDialog(this, "Cliente atualizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(this, "Cliente não encontrado!");
			limparCampos();
		}
	}

	// Método de limpeza dos campos
	private void limparCampos() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textFieldNome.setText("");
		textFieldTelefone.setText("");
		textFieldEmail.setText("");
	}

	private void deletarCliente() {
		String cpf = textFieldDeletar.getText();

		if (cpf.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Informe o CPF para deletar o cliente!");
			return;
		}
		AppController app = AppController.getInstance();
		Cliente cliente = app.buscarClientePorCPF(cpf);

		if (cliente != null) {
			int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja deletar este cliente?",
					"Confirmação", JOptionPane.YES_NO_OPTION);
			if (confirmacao == JOptionPane.YES_OPTION) {
				app.deletarCliente(cpf);
				JOptionPane.showMessageDialog(this, "Cliente deletado com sucesso!");
				textFieldDeletar.setText("");
			} else {
				JOptionPane.showMessageDialog(this, "Erro ao deletar o cliente. CPF não encontrado.");
			}

		}
	}
}
