package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.viagem.PaisDestino;
import br.com.safeJourney.model.viagem.Viagem;
import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.RoundButton;
import br.com.safeJourney.util.RoundPanel;

public class TelaCalcular extends JFrame {

	private static TelaCalcular frame;
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private static JButton btnDtEmbarque;
	private static JButton btnDtDesembarque;
	private static JButton btnClicado;
	private JTextField txtNomeCompeto;
	private JTextField txtEmail;
	private JTextField txtNmeroDeTelefone;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaCalcular();
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

	public TelaCalcular() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);

		ImagePanel panel = new ImagePanel("/backgroundimage.png");
		panel.setLayout(null);
		panel.setForeground(new Color(0, 128, 0));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		// Lista de finalidades de viagem
		String[] finalidades = { "Negócios/trabalho", "Turismo/lazer" };
		Image img = new ImageIcon(this.getClass().getResource("/logoMaior.png")).getImage();

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 382, 1266, 301);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Destino:");
		lblNewLabel_3.setBounds(125, 35, 186, 14);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		// BOTÃO CALCULAR
		JButton btnCalcular = new RoundButton("Calcular", new ImageIcon(getClass().getResource("/btnCalcular.png")));
		btnCalcular.setText("");
		btnCalcular.setBounds(552, 226, 162, 64);
		panel_1.add(btnCalcular);
		btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCalcular.setBackground(new Color(255, 255, 255));
		
		// espaços para o usuario digitar nome, email e telefone
		txtNomeCompeto = new JTextField();
		txtNomeCompeto.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtNomeCompeto.setBounds(125, 128, 255, 35);
		panel_1.add(txtNomeCompeto);
		txtNomeCompeto.setToolTipText("Nome Completo");
		txtNomeCompeto.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtEmail.setBounds(500, 128, 298, 35);
		panel_1.add(txtEmail);
		txtEmail.setBackground(new Color(255, 255, 255));
		txtEmail.setColumns(10);

		txtNmeroDeTelefone = new JTextField();
		txtNmeroDeTelefone.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtNmeroDeTelefone.setBounds(917, 128, 247, 35);
		panel_1.add(txtNmeroDeTelefone);
		txtNmeroDeTelefone.setToolTipText("Número de Telefone");
		txtNmeroDeTelefone.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Número de Telefone/WhatsApp:");
		lblNewLabel_2.setBounds(917, 101, 247, 19);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblNewLabel_1 = new JLabel("E-mail para contato:");
		lblNewLabel_1.setBounds(500, 101, 308, 19);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		// textos que orientam o usuario sobre o que deve ser feito
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBounds(125, 101, 254, 19);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		// cria o JComboBox para países e adiciona os países
		JComboBox<PaisDestino> comboBoxPaises = new JComboBox<>(PaisDestino.values());
		comboBoxPaises.setBounds(125, 59, 186, 35);
		panel_1.add(comboBoxPaises);
		comboBoxPaises.setBackground(new Color(255, 255, 255));
		comboBoxPaises.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBoxPaises.setFocusable(false);
		comboBoxPaises.setRenderer(new DefaultListCellRenderer() {
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

		// Cria o JComboBox para finalidades de viagem e adiciona as opções
		JComboBox<String> comboBoxFinalidade = new JComboBox<>(finalidades);
		comboBoxFinalidade.setBounds(338, 59, 207, 35);
		panel_1.add(comboBoxFinalidade);
		comboBoxFinalidade.setBackground(new Color(255, 255, 255));
		comboBoxFinalidade.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBoxFinalidade.setFocusable(false);
		comboBoxFinalidade.setRenderer(new DefaultListCellRenderer() {
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

		// CALENDARIOS
		// embarque
		btnDtEmbarque = new JButton("Data de Embarque");
		btnDtEmbarque.setBounds(571, 59, 195, 35);
		panel_1.add(btnDtEmbarque);
		btnDtEmbarque.setBackground(new Color(255, 255, 255));
		btnDtEmbarque.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblNewLabel_4 = new JLabel("Finalidade:");
		lblNewLabel_4.setBounds(338, 35, 207, 14);
		panel_1.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblNewLabel_5 = new JLabel("Data de Embarque:");
		lblNewLabel_5.setBounds(570, 35, 238, 14);
		panel_1.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		// desembarque
		btnDtDesembarque = new JButton("Data de Desembarque");
		btnDtDesembarque.setBounds(788, 59, 195, 35);
		panel_1.add(btnDtDesembarque);
		btnDtDesembarque.setBackground(new Color(255, 255, 255));
		btnDtDesembarque.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JLabel lblNewLabel_6 = new JLabel("Data de Desembarque:");
		lblNewLabel_6.setBounds(788, 35, 195, 14);
		panel_1.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 30, 1));
		spinner.setBounds(1008, 59, 186, 35);
		panel_1.add(spinner);
		spinner.setBackground(new Color(255, 255, 255));

		JLabel lblNewLabel_7 = new JLabel("Quantidade de Viajantes:");
		lblNewLabel_7.setBounds(1008, 31, 195, 23);
		panel_1.add(lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 15));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Aceito que a SafeJourney entre em contato comigo");
		chckbxNewCheckBox.setForeground(new Color(0, 0, 0));
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(472, 201, 321, 23);
		panel_1.add(chckbxNewCheckBox);
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected()) {
					txtNomeCompeto.setText("Guilherme Santos da Costa"); 
					txtEmail.setText("guisantoscosta9@gmail.com"); 
					txtNmeroDeTelefone.setText("(11) 95121-0882"); 
				} else {
					// Limpa os campos caso o checkbox seja desmarcado
					txtNomeCompeto.setText("");
					txtEmail.setText("");
					txtNmeroDeTelefone.setText("");
				}
			}
		});

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 66, 1266, 5);
		panel.add(panel_3);
		panel_3.setBackground(new Color(0, 30, 196));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 0, 1266, 69);
		panel.add(panel_2);
		panel_2.setLayout(null);

		// IMAGENS
		// logo
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setBounds(540, -1, 186, 71);
		panel_2.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(img));

		RoundPanel panel_4 = new RoundPanel(15);
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(423, 54, 442, 86);
		getContentPane().add(panel_4);
		panel_4.setLayout(null);
		JLabel lblNewLabel_9 = new JLabel("Seguro");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9.setBounds(129, 27, 60, 25);
		panel_4.add(lblNewLabel_9);

		JLabel lblNewLabel_9_1 = new JLabel("Viagem");
		lblNewLabel_9_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_9_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_9_1.setBounds(129, 47, 78, 25);
		panel_4.add(lblNewLabel_9_1);

		JLabel lblNewLabel_9_1_1 = new JLabel("Origem:");
		lblNewLabel_9_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_9_1_1.setBounds(245, 29, 60, 20);
		panel_4.add(lblNewLabel_9_1_1);

		JLabel lblNewLabel_9_1_1_1 = new JLabel("Destino:");
		lblNewLabel_9_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_9_1_1_1.setBounds(245, 53, 60, 14);
		panel_4.add(lblNewLabel_9_1_1_1);

		JLabel lblNewLabel_9_1_1_1_1 = new JLabel("Brasil");
		lblNewLabel_9_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9_1_1_1_1.setBounds(305, 32, 46, 14);
		panel_4.add(lblNewLabel_9_1_1_1_1);

		JLabel lblNewLabel_9_1_1_1_1_1 = new JLabel("Internacional");
		lblNewLabel_9_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9_1_1_1_1_1.setBounds(305, 53, 97, 14);
		panel_4.add(lblNewLabel_9_1_1_1_1_1);

		JLabel lblNewLabel_10 = new JLabel();
		Image img1 = new ImageIcon(this.getClass().getResource("/aviao2.png")).getImage();
		lblNewLabel_10.setIcon(new ImageIcon(img1));
		lblNewLabel_10.setBounds(25, 27, 89, 51);
		panel_4.add(lblNewLabel_10);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(192, 192, 192));
		panel_5.setBounds(217, 11, 2, 75);
		panel_4.add(panel_5);

		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(0, 30, 196));
		panel_3_1.setBounds(-192, 67, 1266, 3);
		panel.add(panel_3_1);

		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBackground(new Color(0, 0, 255));
		panel_2_1.setBounds(0, 303, 1266, 80);
		panel.add(panel_2_1);

		JLabel lblNewLabel_11 = new JLabel("Olá! Eu sou a           e vou te ajudar na cotação e contratação do seu ");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setBounds(330, 27, 560, 25);
		panel_2_1.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Safira");
		lblNewLabel_12.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_12.setForeground(new Color(255, 255, 255));
		lblNewLabel_12.setBounds(439, 33, 46, 14);
		panel_2_1.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Seguro Viagem");
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_13.setBounds(874, 28, 123, 25);
		panel_2_1.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setBounds(252, 5, 68, 69);
		panel_2_1.add(lblNewLabel_14);
		Image img2 = new ImageIcon(this.getClass().getResource("/fotoChatBot.png")).getImage();
		lblNewLabel_14.setIcon(new ImageIcon(img2));

		btnDtDesembarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicado = btnDtDesembarque;
				JFrameCalendar.invocarCalendario();
			}
		});

		btnDtEmbarque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnClicado = btnDtEmbarque;
				JFrameCalendar.invocarCalendario();
			}
		});

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastraViagem(comboBoxPaises.getSelectedItem().toString(), comboBoxFinalidade.getSelectedItem().toString(),
						btnDtEmbarque.getText(), btnDtDesembarque.getText(), Integer.parseInt(spinner.getValue().toString()));
			}
		});

	}

	private static void cadastraViagem(String paisDestino, String finalidadeViagem, String dataEmbarque, String dataDesembarque, int qtdViajantes) {
		Viagem viagem = new Viagem(dataEmbarque, dataDesembarque, qtdViajantes, paisDestino, finalidadeViagem);
		
		TelaOrcamento.invocarTelaOrcamento(viagem);
		frame.dispose();
		
	}

	public static void atualizaTextFild(String dataSelecionada) {
		if (btnClicado != null) {
			btnClicado.setText(dataSelecionada);
			btnClicado = null;
		} else {
			System.out.println("Botão não inicializado.");
		}

	}

	public static void invocarTelaCalcular() {
		if (frame == null) {

			frame = new TelaCalcular();
			frame.setVisible(true);
		}
	}
}
