package br.com.safeJourney.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.safeJourney.model.plano.Plano;
import br.com.safeJourney.model.plano.PrecoDinamico;
import br.com.safeJourney.model.plano.TipoPlano;
import br.com.safeJourney.model.viagem.Viagem;
import br.com.safeJourney.util.ImagePanel;
import br.com.safeJourney.util.RoundButton;
import java.awt.Font;

public class TelaOrcamento extends JFrame {

	
    private static double precoDinamicoBasico;
    private static double precoDinamicoIntermediario;
    private static double precoDinamicoTop;
    private static Viagem viagemCliente;
    private static TelaOrcamento instance;
    private static final long serialVersionUID = 1L;
    private JPanel panel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TelaOrcamento frame = new TelaOrcamento();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        });
    }

    /**
     * Create the frame.
     */
    public TelaOrcamento() {
    	
        precoDinamicoBasico = PrecoDinamico.calcularPrecoDinamico(viagemCliente, TipoPlano.BASICO);
        precoDinamicoIntermediario = PrecoDinamico.calcularPrecoDinamico(viagemCliente, TipoPlano.INTERMEDIARIO);
        precoDinamicoTop = PrecoDinamico.calcularPrecoDinamico(viagemCliente, TipoPlano.TOP);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1280, 720);
        setLocationRelativeTo(null);

        panel = new ImagePanel("/backgroundimage.png");
        panel.setForeground(new Color(0, 128, 0));
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(panel);
        panel.setLayout(null);
        panel.setBackground(new Color(255, 255, 255));

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(-1, 0, 1266, 81);
        panel_4.setBackground(new Color(255, 255, 255));
        panel.add(panel_4);
        panel_4.setLayout(null);

        JLabel lblNewLabel_6 = new JLabel();
        lblNewLabel_6.setBounds(548, -4, 170, 90);
        Image img5 = new ImageIcon(this.getClass().getResource("/logoMaior.png")).getImage();
        lblNewLabel_6.setIcon(new ImageIcon(img5));
        panel_4.add(lblNewLabel_6);

        JPanel panelPlanoBasico = new ImagePanel("/planoBasico.png");
        panelPlanoBasico.setBounds(90, 128, 300, 427);
        panel.add(panelPlanoBasico);
        panelPlanoBasico.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setForeground(new Color(37, 92, 168));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lblNewLabel.setBounds(125, 365, 113, 36);
        lblNewLabel.setText("%.2f".formatted(precoDinamicoBasico));
        panelPlanoBasico.add(lblNewLabel);
        

        JButton btnConfirmarPlanoBasico = new RoundButton("CONFIRMAR",
                new ImageIcon(getClass().getResource("/botaoConfirmarPlano.png")));
        btnConfirmarPlanoBasico.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmarPlanoBasico.setText("");
        btnConfirmarPlanoBasico.setBounds(90, 496, 300, 115);
        panel.add(btnConfirmarPlanoBasico);

        JPanel panelPlanoIntermediario = new ImagePanel("/planoIntermediario.png");
        panelPlanoIntermediario.setBounds(487, 128, 300, 427);
        panel.add(panelPlanoIntermediario);
        panelPlanoIntermediario.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel();
        lblNewLabel_1.setBounds(126, 367, 113, 36);
        lblNewLabel_1.setForeground(new Color(37, 92, 168));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lblNewLabel_1.setText("%.2f".formatted(precoDinamicoIntermediario));
        panelPlanoIntermediario.add(lblNewLabel_1);

        JButton btnConfirmarPlanoIntermediario = new RoundButton("CONFIRMAR",
                new ImageIcon(getClass().getResource("/botaoConfirmarPlano.png")));
        btnConfirmarPlanoIntermediario.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmarPlanoIntermediario.setText("");
        btnConfirmarPlanoIntermediario.setBounds(487, 496, 300, 115);
        panel.add(btnConfirmarPlanoIntermediario);

        JPanel panelPlanoTop = new ImagePanel("/planoTop.png");
        panelPlanoTop.setBounds(876, 128, 300, 427);
        panel.add(panelPlanoTop);
        panelPlanoTop.setLayout(null);
        
        JLabel lblNewLabel_1_1 = new JLabel("0.0");
        lblNewLabel_1_1.setForeground(new Color(37, 92, 168));
        lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 35));
        lblNewLabel_1_1.setBounds(126, 366, 113, 36);
        lblNewLabel_1_1.setText("%.2f".formatted(precoDinamicoTop));
        panelPlanoTop.add(lblNewLabel_1_1);

        JButton btnConfirmarPlanoTop = new RoundButton("CONFIRMAR",
                new ImageIcon(getClass().getResource("/botaoConfirmarPlano.png")));
        btnConfirmarPlanoTop.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnConfirmarPlanoTop.setText("");
        btnConfirmarPlanoTop.setBounds(876, 496, 300, 115);
        panel.add(btnConfirmarPlanoTop);

        btnConfirmarPlanoBasico.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastroPlano(TipoPlano.BASICO);
            }
        });
        btnConfirmarPlanoIntermediario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastroPlano(TipoPlano.INTERMEDIARIO);
            }
        });
        btnConfirmarPlanoTop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cadastroPlano(TipoPlano.TOP);
            }
        });
    }

    private static void cadastroPlano(TipoPlano tipoPlano) {
        Plano plano = new Plano(tipoPlano);
        
         double precoDinamico = PrecoDinamico.calcularPrecoDinamico(viagemCliente, plano.getTipoPlano());
         
        TelaLoginCadastroApolice.iniciaTelaLoginCadastroApolice(viagemCliente, plano);
        instance.dispose();
    }

    public static void invocarTelaOrcamento(Viagem viagem) {
        viagemCliente = viagem;
        if (instance == null) {
            instance = new TelaOrcamento();
            instance.setVisible(true);
        }
    }
}
