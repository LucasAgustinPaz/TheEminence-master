import javax.swing.*;
import java.awt.*;

class TransparentLabel extends JLabel {
    public TransparentLabel(String text) {
        super(text);
        setForeground(Color.WHITE); // Establecer el color del texto en blanco
        setOpaque(false); // Hacer que el fondo del JLabel sea transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Establecer la transparencia del fondo del JLabel al 50%
        ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        super.paintComponent(g);
    }
}
