package br.com.safeJourney.util;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image backgroundImage;
    private boolean isTransparent;

    public ImagePanel(String imagePath) {
        backgroundImage = new ImageIcon(getClass().getResource(imagePath)).getImage();
        isTransparent = false; // Inicialmente, não transparente
    }

    // Método para definir a transparência do painel
    public void setTransparent(boolean isTransparent) {
        this.isTransparent = isTransparent;
        repaint(); // Repaint para aplicar as mudanças
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isTransparent && backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        } else {
            super.paintComponent(g);
            setOpaque(false); // Define o painel como não opaco
        }
    }
}
