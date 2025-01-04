package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import br.com.safeJourney.model.Apolice;
import br.com.safeJourney.model.Cliente;
import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.viagem.Viagem;
import br.com.safeJourney.util.BackgroundPanel;
import br.com.safeJourney.util.RoundButton;
import br.com.safeJourney.util.Validacao;

public class TelaLoginCadastroApolice extends JFrame {
    private static TelaLoginCadastroApolice instance;
    private JTextField textFieldCPF;
    private JPasswordField passwordField;
    private static Viagem viagemCliente;
    private static Plano planoCliente;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaLoginCadastroApolice frame = new TelaLoginCadastroApolice();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TelaLoginCadastroApolice() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        setBounds(100, 100, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new BackgroundPanel("/telaLogin.png");
        panel.setBounds(0, 0, 510, 681);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Vamos Começar!");
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblNewLabel.setBounds(27, 128, 234, 41);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Informe seu CPF:");
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(27, 206, 203, 21);
        panel.add(lblNewLabel_1);

        textFieldCPF = new JTextField();
        textFieldCPF.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        textFieldCPF.setColumns(10);
        textFieldCPF.setBounds(27, 238, 255, 35);
        panel.add(textFieldCPF);

        JLabel lblNewLabel_1_1 = new JLabel("Informe sua Senha:");
        lblNewLabel_1_1.setForeground(Color.WHITE);
        lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblNewLabel_1_1.setBounds(27, 322, 203, 21);
        panel.add(lblNewLabel_1_1);

        JButton btnSeta2 = new RoundButton("", new ImageIcon(getClass().getResource("/btnSetaMaior.png")));
        btnSeta2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSeta2.setBounds(27, 461, 116, 98);
        panel.add(btnSeta2);
        btnSeta2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                validaCliente(textFieldCPF.getText(), new String(passwordField.getPassword()));
            }
        });

        passwordField = new JPasswordField("");
        passwordField.setBounds(27, 354, 255, 35);
        panel.add(passwordField);

        JLabel lblNewLabel_3 = new JLabel("       Não possui um Cadastro?");
        lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_3.setForeground(new Color(255, 255, 255));
        lblNewLabel_3.setBounds(208, 483, 193, 21);
        panel.add(lblNewLabel_3);

        JButton btnCliqueAqui = new RoundButton("", new ImageIcon(getClass().getResource("/btnCliqueAqui.png")));
        btnCliqueAqui.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCliqueAqui.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        btnCliqueAqui.setBounds(400, 483, 100, 21);
        panel.add(btnCliqueAqui);
        
        RoundButton btnNewButton = new RoundButton("", (ImageIcon) null);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textFieldCPF.setText("580.757.038-39");
				passwordField.setText("123456");
        	}
        });
        btnNewButton.setBackground(Color.WHITE);
        btnNewButton.setBounds(368, 21, 132, 85);
        panel.add(btnNewButton);
        btnCliqueAqui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TelaCadastroAreaApolice.main(null); // Abre a tela de cadastro
            }
        });

        JPanel panel_1 = new BackgroundPanel("/aviaoLogin.png");
        panel_1.setBounds(511, 0, 753, 681);
        getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JButton btnCotacao = new RoundButton("", new ImageIcon(getClass().getResource("/btnCotacao.png")));
        btnCotacao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCotacao.setBounds(290, 68, 162, 74);
        panel_1.add(btnCotacao);

        JLabel lblNewLabel_2 = new JLabel("Vamos Cotar seu Seguro?");
        lblNewLabel_2.setForeground(new Color(255, 255, 255));
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblNewLabel_2.setBounds(245, 35, 280, 35);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("TOTALMENTE DIGITAL");
        lblNewLabel_2_1.setForeground(Color.WHITE);
        lblNewLabel_2_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNewLabel_2_1.setBounds(300, 11, 152, 26);
        panel_1.add(lblNewLabel_2_1);
        btnCotacao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                instance.dispose(); // Fecha a janela atual
                TelaCalcular.main(null); // Abre a tela de calcular
            }
        });

        setLocationRelativeTo(null); // Centraliza a janela
    }

    public void validaCliente(String cpf, String senha) {
        AppController app = AppController.getInstance();
        boolean validaCPFCliente = Validacao.validaCPFCliente(app, cpf);
        boolean validaSenhaCliente = Validacao.validaSenhaCliente(app, cpf, senha);
        if (validaCPFCliente && validaSenhaCliente) {
            JOptionPane.showMessageDialog(null, "Logado");

            Cliente cliente = app.buscarClientePorCPF(cpf);

            viagemCliente.setCpfCliente(cliente.getCpfCliente());

            app.cadastrarPlano(planoCliente);
            app.cadastrarViagem(viagemCliente);

            Apolice apolice = cadastraApolice(app, cpf);

            app.CadastroApolice(apolice);

            TelaPagamento.main(null);
            instance.dispose();

        } else if (validaCPFCliente && !validaSenhaCliente) {
            JOptionPane.showMessageDialog(null, "Senha inválida");
            passwordField.setText("");
        }
    }

    private Apolice cadastraApolice(AppController app, String cpf) {
        Cliente cliente = app.buscarClientePorCPF(cpf);

        Viagem viagem = app.buscarViagemByCPF(cpf);
        Plano plano = app.buscarplanoByTipo(planoCliente.getTipoPlano());

        Apolice apolice = new Apolice("Ativo", cliente, viagem, plano);

        return apolice;

    }

    public static void iniciaTelaLoginCadastroApolice(Viagem viagem, Plano plano) {
        viagemCliente = viagem;
        planoCliente = plano;
        if (instance == null) {
            instance = new TelaLoginCadastroApolice();
        }
        instance.setVisible(true);
    }
}
