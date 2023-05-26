import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JPanel {
    private JButton closeButton;
    private JPanel panelShop;
    private JPanel panelSkin;
    private JPanel panelBoost;

    private JPanel panelMenu;
    private JButton skinsButton;
    private JButton boostsButton;
    private Boost boosts;
    private Skin skins;

    public Shop(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        panelShop = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Crear el panel de menú
        panelMenu = crearPanelMenu(panelPrincipal, cardLayout, usuario);
        skins = crearPanelSkin(panelShop, cardLayout, usuario);
        boosts = crearPanelBoost(panelShop, cardLayout, usuario);
        panelShop.add(panelMenu, "Menu");

        add(panelShop);
        setVisible(true);
    }

    private Boost crearPanelBoost(JPanel panelShop, CardLayout cardLayout, Usuario usuario) {
        Boost boosts = new Boost(panelShop, cardLayout, usuario);
        return boosts;
    }

    private Skin crearPanelSkin(JPanel panelShop, CardLayout cardLayout, Usuario usuario) {
        Skin skins = new Skin(panelShop, cardLayout, usuario);
        return skins;
    }

    private JPanel crearPanelMenu(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        JPanel panel = new JPanel(new FlowLayout());

        // Crear los botones del menú
        skinsButton = new JButton("Skins");
        boostsButton = new JButton("Mejoras");
        closeButton = new JButton("X");

        // Acción para mostrar la sección de Skins
        skinsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelShop, "Skins");

            }
        });

        // Acción para mostrar la sección de Mejoras
        boostsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelShop, "Mejoras");
            }
        });

        // Acción para volver al menú principal
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        // Agregar los botones al panel de menú
        panel.add(skinsButton);
        panel.add(boostsButton);
        panel.add(closeButton);

        return panel;
    }
}

