import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class panelInversiones extends JPanel {
    private JButton closeButton;
    private JButton inversion1Button;
    private JButton inversion2Button;
    private JButton inversion3Button;
    private Image backgroundImage;

    public panelInversiones(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {

        setLayout(new BorderLayout());

        closeButton = new JButton("X");
        inversion1Button = new JButton("inversion1 $1000");
        inversion2Button = new JButton("inversion2 $1500");
        inversion3Button = new JButton("inversion3 $500");

        // Establecer el fondo del panel
        setOpaque(false);

        // Crear un panel interno para los botones y establecer su diseño
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Agregar los botones al panel interno
        buttonPanel.add(inversion1Button);
        buttonPanel.add(inversion2Button);
        buttonPanel.add(inversion3Button);

        // Agregar los componentes al panel principal
        add(closeButton, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        inversion1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 1000) {
                    usuario.getInversiones().aumentarInversion1();
                    System.out.println("1");
                    usuario.compra(1000);
                }
            }
        });

        inversion2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 1500) {
                    usuario.getInversiones().aumentarInversion2();
                    System.out.println("2");
                    usuario.compra(1500);
                }
            }
        });

        inversion3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 500) {
                    usuario.getInversiones().aumentarInversion3();
                    System.out.println("3");
                    usuario.compra(500);
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
    }
}
