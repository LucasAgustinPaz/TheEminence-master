import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Boost extends JPanel {
    private JButton closeButton;

    private JButton boosts;

    private JButton boosts2;

    private JButton boosts3;

    private int precio;

    public Boost(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        boosts = new JButton("Pagar un Eloboost");
        boosts.setBorderPainted(false);
        boosts.setFocusPainted(false);
        boosts.setBackground(Color.RED.darker());

        boosts2 = new JButton("Contratar ub Coach");
        boosts2.setBorderPainted(false);
        boosts2.setFocusPainted(false);
        boosts2.setBackground(Color.BLUE.darker());

        boosts3 = new JButton("Comprar Perifericos");
        boosts3.setBorderPainted(false);
        boosts3.setFocusPainted(false);
        boosts3.setBackground(Color.YELLOW.darker());

        add(closeButton, BorderLayout.PAGE_END);
        add(boosts, BorderLayout.PAGE_END);
        add(boosts2, BorderLayout.PAGE_END);
        add(boosts3, BorderLayout.PAGE_END);

/*
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        boosts3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!containPeriferico(usuario)) {
                    if (usuario.getCoins() >= 1500) {
                        // usuario.getBoosts().add((Boost) new Periferico(panelPrincipal, cardLayout, usuario));
                        usuario.compra(precio);
                    }
                }
            }
        });

        boosts2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!containCoaching(usuario)) {
                    if (usuario.getCoins() >= 1500) {
                        // usuario.getBoosts().add((Boost) new Coaching(panelPrincipal, cardLayout, usuario));
                        usuario.compra(precio);
                    }
                }
            }
        });

        boosts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!containEloboosting(usuario)) {
                    if (usuario.getCoins() >= 1500) {
                        // usuario.getBoosts().add((Boost) new Eloboosting(panelPrincipal, cardLayout, usuario));
                        usuario.compra(precio);
                    }
                }
            }


        });
    }

    private boolean containEloboosting(Usuario usuario) {
        for (Boost a : usuario.getBoosts()) {
            if (a instanceof Eloboosting) {
                boosts.setEnabled(false);
                return false;
            }
        }
        return true;}

        private boolean containCoaching(Usuario usuario) {
            for (Boost a : usuario.getBoosts()) {
                if (a instanceof Coaching) {
                    boosts2.setEnabled(false);
                    return false;
                }
            }
            return true;}
        private boolean containPeriferico(Usuario usuario) {
            for (Boost a : usuario.getBoosts()) {
                if (a instanceof Periferico) {
                    boosts3.setEnabled(false);
                    return false;
                }
            }
            return true;}
    }
*/
    }
}


