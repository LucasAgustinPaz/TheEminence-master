import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Smurfear extends JPanel {
    private JButton closeButton;
    private JButton smurfear;

    private ImageIcon smurfboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_smurf.png");

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
        centerPanel.add(smurfear);

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
