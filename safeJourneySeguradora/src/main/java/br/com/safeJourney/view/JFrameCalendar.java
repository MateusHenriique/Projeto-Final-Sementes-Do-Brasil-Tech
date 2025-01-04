package br.com.safeJourney.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class JFrameCalendar extends JFrame {

    // Instância estática da classe JFrameCalendar para acesso em métodos estáticos
    private static JFrameCalendar instancia;

    // Componentes da interface
    private JLabel labelMesAno;
    private JPanel painelDias;
    private int mesAtual;
    private int anoAtual;
    private String btnEmbarqueOuDesembarque;

    public JFrameCalendar() {
        // Configurações básicas da janela
        setTitle("Calendário");
        setSize(330, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());

        instancia = this; // Define a instância para acesso estático

        // Inicializa o calendário com o mês e ano atuais
        Calendar calendar = Calendar.getInstance();
        mesAtual = calendar.get(Calendar.MONTH);
        anoAtual = calendar.get(Calendar.YEAR);

        labelMesAno = new JLabel("", JLabel.CENTER);
        painelDias = new JPanel(new GridLayout(0, 7));

        // Criação dos botões de navegação do calendário
        JPanel painelNavegacao = new JPanel();
        JButton botaoAnterior = new JButton("<");
        JButton botaoProximo = new JButton(">");

        // Ação para o botão de mês anterior
        botaoAnterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesAtual--;
                if (mesAtual < 0) {
                    mesAtual = 11;
                    anoAtual--;
                }
                atualizarCalendario();
            }
        });

        // Ação para o botão de próximo mês
        botaoProximo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mesAtual++;
                if (mesAtual > 11) {
                    mesAtual = 0;
                    anoAtual++;
                }
                atualizarCalendario();
            }
        });

        // Adiciona os componentes de navegação ao painel
        painelNavegacao.add(botaoAnterior);
        painelNavegacao.add(labelMesAno);
        painelNavegacao.add(botaoProximo);

        // Adiciona o painel de navegação ao layout da janela
        getContentPane().add(painelNavegacao, BorderLayout.NORTH);
        getContentPane().add(painelDias, BorderLayout.CENTER);

        // Atualiza o calendário para exibir o mês e ano atuais
        atualizarCalendario();
    }

    // Método para atualizar o calendário com os dias do mês atual
    private void atualizarCalendario() {
        painelDias.removeAll();
        Calendar calendar = Calendar.getInstance();
        calendar.set(anoAtual, mesAtual, 1);

        int primeiroDia = calendar.get(Calendar.DAY_OF_WEEK);
        int diasNoMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Adiciona os dias da semana ao painel de dias
        String[] diasDaSemana = {"Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"};
        for (String dia : diasDaSemana) {
            JLabel labelDia = new JLabel(dia, JLabel.CENTER);
            labelDia.setFont(new Font("Arial", Font.PLAIN, 9)); // Reduz o tamanho da fonte para ajustar ao layout pequeno
            painelDias.add(labelDia);
        }

        // Adiciona espaços vazios até o primeiro dia do mês
        for (int i = 1; i < primeiroDia; i++) {
            painelDias.add(new JLabel(""));
        }

        // Adiciona os botões para cada dia do mês
        for (int i = 1; i <= diasNoMes; i++) {
            JButton botaoDia = new JButton(String.valueOf(i));
            botaoDia.setFont(new Font("Arial", Font.PLAIN, 9)); // Reduz o tamanho da fonte para ajustar ao layout pequeno
            int diaSelecionado = i; // Variável local final para uso no listener
            botaoDia.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String data = diaSelecionado + "/" + (mesAtual + 1) + "/" + anoAtual;
                    TelaCalcular.atualizaTextFild(data);
                    instancia.dispose();
                    instancia = null;
                }
            });
            painelDias.add(botaoDia);
        }

        // Atualiza o rótulo do mês e ano
        labelMesAno.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, getLocale()) + " " + anoAtual);

        painelDias.revalidate();
        painelDias.repaint();
    }

    // Método estático para invocar o calendário
    public static void invocarCalendario() {
        if (instancia == null) {
            JFrameCalendar calendario = new JFrameCalendar();
            calendario.setVisible(true);
            calendario.setLocationRelativeTo(null); // Centraliza a janela na tela
        }
    }

    // Método principal para execução do programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrameCalendar frame = new JFrameCalendar();
                frame.setVisible(true);
            }
        });
    }
}
