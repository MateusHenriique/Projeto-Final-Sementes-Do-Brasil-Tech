package br.com.safeJourney.util;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RoundButton extends JButton {
    private Shape shape;

    public RoundButton(String label, ImageIcon icon) {
        super(label, icon);
        setOpaque(false); // Necessário para exibir o botão arredondado corretamente
        setContentAreaFilled(false); // Remove o preenchimento do conteúdo
        setFocusPainted(false); // Remove a borda do foco
        setBorderPainted(false); // Remove a borda do botão
    }

    @Override
    protected void paintComponent(Graphics g) {
    	if (isOpaque()) { // Só desenha o fundo se for opaco
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14); // Curvatura de 14
        }
        super.paintComponent(g); // Desenha o texto e o ícone do botão
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Não desenha a borda para remover a borda preta
    }

    @Override
    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), 14, 14); // Curvatura de 14
        }
        return shape.contains(x, y);
    }
}

