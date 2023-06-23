import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Smurfear extends JPanel {
    private JButton closeButton;
    private JButton smurfear;

    private ImageIcon smurfboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_smurf.png");
    private ImageIcon backgroundImage = new ImageIcon("resources\\sprites\\Assets\\UI\\fondo_blur.png");

    public Smurfear(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);


        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        smurfear = new JButton(smurfboton);
        smurfear.setBorder(Main.emptyBorder);
        smurfear.setBackground(Main.transparentColor);
        smurfear.setOpaque(false);
        smurfear.setContentAreaFilled(false);
        smurfear.setBorderPainted(false);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(closeButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());

        // Agregar fondo al panel de botones
        JLabel buttonsBackgroundLabel = new JLabel(backgroundImage);
        buttonsBackgroundLabel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0); // Ajusta los mÃ¡rgenes inferiores
        buttonsBackgroundLabel.add(smurfear, gbc);

        centerPanel.add(buttonsBackgroundLabel);

        add(buttonPanel, BorderLayout.PAGE_END);
        add(centerPanel, BorderLayout.CENTER);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        smurfear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getNivel() >= 6) {
                    usuario.setNivel(0);
                    usuario.aumentarBoosteoSmurf();
                    usuario.setXp(0);
                    usuario.setearNivelesRol();
                    usuario.agregarCoins(1000);
                    usuario.setPromoGanada(false);

                    System.out.println("Smurfeado");
                } else {
                    System.out.println("no esmurfea");
                }
            }
        });
    }
}