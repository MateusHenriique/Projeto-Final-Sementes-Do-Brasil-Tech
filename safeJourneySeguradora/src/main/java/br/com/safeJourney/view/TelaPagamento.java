package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.safeJourney.util.BackgroundPanel;
import br.com.safeJourney.util.RoundButton;
import br.com.safeJourney.util.RoundPanel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPagamento {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPagamento window = new TelaPagamento();
					window.frame.setLocationRelativeTo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPagamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1264, 75);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(544, 11, 175, 53);
		panel.add(lblNewLabel);
		Image img = new ImageIcon(this.getClass().getResource("/logoMaior.png")).getImage();
		panel.setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(img));
		panel.add(lblNewLabel);
		
		JPanel panel_2 = new BackgroundPanel("/fundopagamento.png");
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(0, 69, 1264, 139);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		RoundPanel panel_4_1 = new RoundPanel(15);
		panel_4_1.setLayout(null);
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(411, 0, 442, 86);
		panel_2.add(panel_4_1);
		JLabel lblNewLabel_9_1 = new JLabel("Seguro");
		lblNewLabel_9_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9_1.setBounds(129, 27, 60, 25);
		panel_4_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("Viagem");
		lblNewLabel_9_1_1.setForeground(Color.BLUE);
		lblNewLabel_9_1_1.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel_9_1_1.setBounds(129, 47, 78, 25);
		panel_4_1.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Origem:");
		lblNewLabel_9_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_9_1_1_1.setBounds(245, 29, 60, 20);
		panel_4_1.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_1_1_1 = new JLabel("Destino:");
		lblNewLabel_9_1_1_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblNewLabel_9_1_1_1_1.setBounds(245, 53, 60, 14);
		panel_4_1.add(lblNewLabel_9_1_1_1_1);
		
		JLabel lblNewLabel_9_1_1_1_1_1 = new JLabel("Brasil");
		lblNewLabel_9_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9_1_1_1_1_1.setBounds(305, 32, 46, 14);
		panel_4_1.add(lblNewLabel_9_1_1_1_1_1);
		
		JLabel lblNewLabel_9_1_1_1_1_1_1 = new JLabel("Internacional");
		lblNewLabel_9_1_1_1_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_9_1_1_1_1_1_1.setBounds(305, 53, 97, 14);
		panel_4_1.add(lblNewLabel_9_1_1_1_1_1_1);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(217, 11, 2, 75);
		panel_4_1.add(panel_5);
		
		JLabel lblNewLabel_10 = new JLabel();
		Image img1 = new ImageIcon(this.getClass().getResource("/aviao2.png")).getImage();
		lblNewLabel_10.setIcon(new ImageIcon(img1));
		lblNewLabel_10.setBounds(26, 21, 89, 51);
		panel_4_1.add(lblNewLabel_10);
		
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 255));
		panel_3.setBounds(0, 206, 1264, 106);
		frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PREENCHA ABAIXO AS INFORMAÇÕES SOBRE OS PASSAGEIROS:");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 23));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(286, 41, 738, 25);
		panel_3.add(lblNewLabel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 307, 1264, 374);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(502, 61, 257, 60);
		panel_4.add(lblNewLabel_3);
		Image img4 = new ImageIcon(this.getClass().getResource("/pagamento.png")).getImage();
		panel_4.setLayout(null);
		lblNewLabel_3.setIcon(new ImageIcon(img4));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("QUANTIDADE DE PARCELAS");
		lblNewLabel_2.setBounds(525, 36, 213, 14);
		panel_4.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 11));
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1x", "2x", "3x", "4x", "5x", "6x"}));
		comboBox.setBounds(775, 130, 45, 22);
		panel_4.add(comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Parcelamento");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(444, 147, 123, 14);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(444, 165, 376, 5);
		panel_4.add(lblNewLabel_5);
		Image img8 = new ImageIcon(this.getClass().getResource("/linhapreta.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img8));
		panel_4.add(lblNewLabel_5);
		
		JButton btnNewButton = new RoundButton("",
				new ImageIcon(getClass().getResource("/botaocontinuar.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaParabens.main(null);
				frame.dispose();
			}
		});
		btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(569, 297, 125, 40);
		panel_4.add(btnNewButton);
		
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(445, 226, 373, 14);
		panel_4.add(lblNewLabel_8);
		Image img9 = new ImageIcon(this.getClass().getResource("/linhapreta.png")).getImage();
		lblNewLabel_8.setIcon(new ImageIcon(img9));
		panel_4.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(" Para sua segurança as próximas seções são protegidas por criptografia seguro e monitoração.");
		lblNewLabel_9.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblNewLabel_9.setBounds(453, 257, 376, 14);
		panel_4.add(lblNewLabel_9);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Eu concordo com os termos e condições.");
		chckbxNewCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		chckbxNewCheckBox.setBounds(540, 270, 183, 23);
		panel_4.add(chckbxNewCheckBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		comboBox_1.setBackground(new Color(255, 255, 255));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Próprio segurado", "Mãe/Pai", "Vô/Vó", "Tio/Tia"}));
		comboBox_1.setBounds(563, 206, 138, 22);
		panel_4.add(comboBox_1);
		
		JLabel lblNewLabel_11 = new JLabel("Grau de parentesco com o pagador");
		lblNewLabel_11.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblNewLabel_11.setBounds(533, 181, 198, 22);
		panel_4.add(lblNewLabel_11);
		
		
		
		
		
		
		
		
		
	}
}
