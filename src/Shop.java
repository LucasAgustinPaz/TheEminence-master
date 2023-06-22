import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Shop extends JPanel {
    private JButton closeButton;
    private JButton skin1;
    private JButton skin2;
    private JButton skin3;

    public Shop(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
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

        skin1 = new JButton(Main.prime);
        skin1.setBorder(Main.emptyBorder);
        skin1.setBackground(Main.transparentColor);
        skin1.setOpaque(false);
        skin1.setContentAreaFilled(false);
        skin1.setBorderPainted(false);

        skin2 = new JButton(Main.origin);
        skin2.setBorder(Main.emptyBorder);
        skin2.setBackground(Main.transparentColor);
        skin2.setOpaque(false);
        skin2.setContentAreaFilled(false);
        skin2.setBorderPainted(false);

        skin3 = new JButton(Main.reaven);
        skin3.setBorder(Main.emptyBorder);
        skin3.setBackground(Main.transparentColor);
        skin3.setOpaque(false);
        skin3.setContentAreaFilled(false);
        skin3.setBorderPainted(false);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 0, 0)); // 1 fila, 3 columnas
        buttonPanel.add(skin1);
        buttonPanel.add(skin2);
        buttonPanel.add(skin3);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.add(closeButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(buttonPanel);

        add(centerPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.SOUTH);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Tienda");
            }
        });

        skin1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!usuario.getSkins().contains("vandal prime")) {
                    if (usuario.getCoins() >= 1500) {
                        usuario.agregarSkin("vandal prime");
                        usuario.compra(1500);
                    }
                }
            }
        });

        skin2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!usuario.getSkins().contains("vandal gris")) {
                    if (usuario.getCoins() >= 500) {
                        usuario.agregarSkin("vandal gris");
                        usuario.compra(500);
                    }
                }
            }
        });

        skin3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!usuario.getSkins().contains("vandal fachera")) {
                    if (usuario.getCoins() >= 750) {
                        usuario.agregarSkin("vandal fachera");
                        usuario.compra(750);
                    }
                }
            }
        });
    }
}
