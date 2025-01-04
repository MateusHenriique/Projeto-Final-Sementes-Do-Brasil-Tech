package br.com.safeJourney.view.chatbot;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.controller.AppController;
import br.com.safeJourney.model.cotacaoMoeda.Moeda;
import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.Protocolo;
import br.com.safeJourney.util.RoundButton;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TelaCotacaoMoedaChatBot extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JFrame frame;
	private static JLabel lblValBRL;
	private static JLabel lblValConversao;
	private static JTextField textFieldValorReais;
	private static String cotacao = "";
	private static String txtTotReais = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new TelaCotacaoMoedaChatBot();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param lblValBRL 
	 * @param lblValConversao 
	 */
	public TelaCotacaoMoedaChatBot() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 425);

		ImagePanel panel = new ImagePanel("/backgroundimage.png");
		panel.setLayout(null);
		setContentPane(panel);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblTexto1 = new JLabel("Ótimo vamos comecar a cotação");
		lblTexto1.setForeground(new Color(255, 255, 255));
		lblTexto1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTexto1.setBounds(229, 116, 234, 24);
		panel.add(lblTexto1);
		String protocolo = Protocolo.gerarProtocolo();

		JLabel lblTexto2 = new JLabel("Selecione a moeda:");
		lblTexto2.setForeground(new Color(255, 255, 255));
		lblTexto2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTexto2.setBounds(224, 204, 189, 24);
		panel.add(lblTexto2);

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/safira.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(-17, 0, 250, 390);
		panel.add(lblNewLabel);

		
		textFieldValorReais = new JTextField("");
		JComboBox<Moeda> comboBox = new JComboBox<>(Moeda.values());
		textFieldValorReais.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                	actionDoFindCash(comboBox, textFieldValorReais.getText());
	                }
	            }
	        });
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actionDoFindCash(comboBox, textFieldValorReais.getText());
			}
		});
		comboBox.setBounds(229, 238, 237, 30);
		panel.add(comboBox);

		JLabel lblNewLabel_2 = new JLabel("Valor em R$:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(225, 163, 106, 27);
		panel.add(lblNewLabel_2);

		lblValBRL = new JLabel("");
		lblValBRL.setForeground(new Color(255, 255, 255));
		lblValBRL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValBRL.setBounds(229, 292, 237, 30);
		panel.add(lblValBRL);
		
		lblValConversao = new JLabel("");
		lblValConversao.setForeground(new Color(255, 255, 255));
		lblValConversao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblValConversao.setBounds(229, 332, 237, 30);
		panel.add(lblValConversao);
		textFieldValorReais.setBounds(331, 164, 135, 30);
		panel.add(textFieldValorReais);
		textFieldValorReais.setColumns(10);
		
		JButton btnSair = new RoundButton("", new ImageIcon(getClass().getResource("/btnSair.png")));
		btnSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnSair.setBounds(401, 10, 79, 33);
		panel.add(btnSair);
	}

	public static void invocarTelaCotacaoMoedaChatBot() {
		if (frame == null) {
			
			frame = new TelaCotacaoMoedaChatBot();
			frame.setVisible(true);
		}
	}
	
	public static void actionDoFindCash(JComboBox<Moeda> comboBox, String moedaTexto) {
		AppController app = AppController.getInstance();
		Moeda moeda = (Moeda) comboBox.getSelectedItem();
		String cotacao = Float.toString(app.cotacaoMoeda(moeda.getSigla()));
		try {
			String totReaisStr = moedaTexto;
			if (totReaisStr != null && !totReaisStr.isEmpty()) {
				float conversao;
				float totReais = Float.parseFloat(totReaisStr.trim());
				float cotacaoFloat = Float.parseFloat(cotacao.trim());
				if (cotacaoFloat > 1) {
					conversao = totReais / cotacaoFloat;
				}else {
					conversao = totReais * cotacaoFloat;
				}
				
				
				lblValBRL.setText("Valor em BRL %.2f".formatted(totReais));
				lblValConversao.setText("Conversão em %s %.2f".formatted(moeda.getSigla(), conversao));
			} else {
				lblValConversao.setText("Por favor, insira um valor válido.");
			}
		} catch (NumberFormatException ex) {
			lblValConversao.setText("Erro ao converter valores.");
			ex.printStackTrace();
		}

	}
}
