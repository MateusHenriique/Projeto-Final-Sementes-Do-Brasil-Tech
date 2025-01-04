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
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.Apolice;
import br.com.safeJourney.model.Cliente;
import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.viagem.Viagem;
import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.RoundButton;

public class TelaCliente extends JFrame {

	private static Cliente cliente;
	private static String cpfCliente;
	private static TelaCliente instance;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		AppController app = AppController.getInstance();
		cliente = app.buscarClientePorCPF(cpfCliente);
		
		Apolice apolice = app.buscarApoliceByIdCliente(cliente.getIdCliente());
		Viagem viagem = app.buscarViagemById(apolice.getIdViagem());
		Plano plano = app.buscarplanoById(apolice.getIdPlano());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);

		ImagePanel panel = new ImagePanel("/fundoCliente.png");
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(67, 128, 300, 485);
		panel.setLayout(null);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1264, 82);
		panel_1.setBackground(new Color(255, 255, 255));
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblLogo = new JLabel();
		lblLogo.setBounds(20, 11, 162, 71);
		Image img = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		panel_1.setLayout(null);
		lblLogo.setIcon(new ImageIcon(img));
		panel_1.add(lblLogo);

		JLabel lblNewLabel_1_1 = new JLabel("ÁREA DO CLIENTE");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setBounds(520, 11, 223, 59);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 25));

		JButton btnNewButton = new RoundButton("inicio", 
				new ImageIcon(getClass().getResource("/btnIncio.png")));
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); // Fecha a janela atual
				TelaInicial.main(null); // Abre a tela inicial
			}
		});
		btnNewButton.setText("");
		btnNewButton.setBounds(1083, 22, 171, 48);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("Meus Seguros");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(257, 168, 132, 38);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Apólices");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(257, 211, 61, 21);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_2 = new JLabel("SEGURADORA");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(448, 177, 162, 21);
		panel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_2 = new JLabel();
		Image img2 = new ImageIcon(this.getClass().getResource("/logo.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img2));
		lblNewLabel_2.setBounds(438, 211, 162, 38);
		panel.add(lblNewLabel_2);

		// Definindo os dados e as colunas da tabela
		String[] colunas = { "Coluna 1", "Coluna 2" };
		String[][] dados = { { "Email: ", "Linha 1, Coluna 2" }, { "Nome: ", "Linha 2, Coluna 2" },
				{ "Data de nascimento: ", "Linha 3, Coluna 2" }, { "CPF: ", "Linha 3, Coluna 2" } };

		// Criando o modelo da tabela
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);

		// Inicializando a JTable com o modelo
		table_1 = new JTable(new DefaultTableModel(new Object[][] { { "Email: ", cliente.getEmailCliente() }, { "Nome: ", cliente.getNomeCliente() },
				{ "Data de Nascimento: ", cliente.getDataNascCliente() }, { "CPF: ", cliente.getCpfCliente() }, }, new String[] { "Coluna 1", "Coluna 2" }));
		table_1.setForeground(new Color(0, 0, 0));
		table_1.setBackground(new Color(203, 236, 254));
		table_1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		table_1.setSelectionBackground(new Color(65, 105, 225)); // Cor do fundo da célula selecionada
		table_1.setSelectionForeground(Color.WHITE); // Cor do texto da célula selecionada

		// Ajustando tamanho da tabela
		table_1.setBounds(257, 322, 430, 64); // Ajuste os valores conforme necessário

		// Adicionando a tabela ao painel
		panel.add(table_1);

		JLabel lblNewLabel_1_2_1 = new JLabel("SEGURADO");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(257, 280, 111, 21);
		panel.add(lblNewLabel_1_2_1);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("VIAGEM");
		lblNewLabel_1_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(717, 444, 111, 21);
		panel.add(lblNewLabel_1_2_1_1);

		table_2 = new JTable();
		table_2.setForeground(new Color(0, 0, 0));
		table_2.setBackground(new Color(203, 236, 254));
		table_2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		table_2.setModel(new DefaultTableModel(
				new Object[][] { { "Destino: ", viagem.getPaisDestino() }, { "Partida: ", viagem.getDataIda().toString() }, { "Retorno: ", viagem.getDataVolta().toString() }, },
				new String[] { "New column", "New column" }));
		table_2.setSelectionBackground(new Color(65, 105, 225)); // Cor do fundo da célula selecionada
		table_2.setSelectionForeground(Color.WHITE); // Cor do texto da célula selecionada
		table_2.setBounds(627, 477, 260, 48);
		panel.add(table_2);

		JLabel lblNewLabel_1_2_1_2 = new JLabel("PLANO");
		lblNewLabel_1_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_2.setBounds(833, 280, 111, 21);
		panel.add(lblNewLabel_1_2_1_2);

		table_3 = new JTable();
		table_3.setForeground(new Color(0, 0, 0));
		table_3.setBackground(new Color(203, 236, 254));
		table_3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 13));
		table_3.setModel(new DefaultTableModel(
				new Object[][] { { "Seguradora: ", "SafeJourney" }, { "Plano: ", plano.getTipoPlano().toString() }, { "Preço Total: ", null }, },
				new String[] { "New column", "New column" }));
		table_3.setSelectionBackground(new Color(65, 105, 225)); // Cor do fundo da célula selecionada
		table_3.setSelectionForeground(Color.WHITE); // Cor do texto da célula selecionada
		table_3.setBounds(833, 322, 386, 48);
		panel.add(table_3);

	}

	public static void iniciaPainelCliente(String cpf) {
		cpfCliente = cpf;
		if (instance == null) {

			instance = new TelaCliente();
			instance.setVisible(true);

		}

	}
}
