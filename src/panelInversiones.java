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

    public panelInversiones(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        setLayout(new BorderLayout());

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        inversion1Button = new JButton("DogeCoin $1000");
        inversion1Button.setBorder(Main.emptyBorder);
        inversion1Button.setBackground(Main.transparentColor);
        inversion1Button.setOpaque(false);
        inversion1Button.setContentAreaFilled(false);
        inversion1Button.setBorderPainted(false);

        inversion2Button = new JButton("Bitcoin $1500");
        inversion2Button.setBorder(Main.emptyBorder);
        inversion2Button.setBackground(Main.transparentColor);
        inversion2Button.setOpaque(false);
        inversion2Button.setContentAreaFilled(false);
        inversion2Button.setBorderPainted(false);

        inversion3Button = new JButton("Dolares $500");
        inversion3Button.setBorder(Main.emptyBorder);
        inversion3Button.setBackground(Main.transparentColor);
        inversion3Button.setOpaque(false);
        inversion3Button.setContentAreaFilled(false);
        inversion3Button.setBorderPainted(false);

        // Crear un panel para el botón de cerrar
        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButtonPanel.add(closeButton);

        // Crear un panel interno para los botones y establecer su diseño
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setOpaque(false);

        // Agregar los botones al panel interno
        buttonPanel.add(inversion1Button);
        buttonPanel.add(inversion2Button);
        buttonPanel.add(inversion3Button);

        // Cargar la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("resources\\sprites\\Assets\\UI\\fondo_blur.png");

        // Crear un JLabel con el fondo deseado
        JLabel buttonPanelBackground = new JLabel(backgroundImage);
        buttonPanelBackground.setLayout(new BorderLayout());
        buttonPanelBackground.add(buttonPanel, BorderLayout.CENTER);

        // Agregar el componente al panel principal
        add(closeButtonPanel, BorderLayout.PAGE_END);
        add(buttonPanelBackground, BorderLayout.CENTER);

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
}