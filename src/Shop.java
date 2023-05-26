import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Shop extends JPanel {
    private JButton closeButton;
    private CardLayout cardLayout;
    private JPanel panelShop;
    private JButton skin1;
    private JButton skin2;
    private JButton skin3;
    private JButton boosts;
    private JButton boosts2;
    private JButton boosts3;
    //private Boost boosts;
    private Skin skins;



    public Shop(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana

        /*panelShop = new JPanel();
        this.cardLayout = new CardLayout();
        panelShop.setLayout(this.cardLayout);

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        JPanel panelMenu = crearPanelMenu(usuario);
        boosts = crearPanelBoost(panelShop,this.cardLayout,usuario);
        skins= crearPanelSkin(panelShop,this.cardLayout,usuario);

        panelShop.add(panelMenu, "Menu");
        panelShop.add(boosts,"Mejoras");
        panelShop.add(skins,"Skins");

        this.cardLayout.show(panelShop, "menu");

        add(panelShop);
        setVisible(true);*/

        //solucion temporal

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        skin1 = new JButton("vandal prime 1500");
        skin1.setBorderPainted(false);
        skin1.setFocusPainted(false);
        skin1.setBackground(Color.ORANGE.darker());

        skin2 = new JButton("vandal gris 500");


        skin2.setBorderPainted(false);
        skin2.setFocusPainted(false);
        skin2.setBackground(Color.PINK.darker());

        skin3 = new JButton("vandal fachera 750");
        skin3.setBorderPainted(false);
        skin3.setFocusPainted(false);
        skin3.setBackground(Color.CYAN.darker());


        add(closeButton, BorderLayout.PAGE_END);
        add(skin1, BorderLayout.PAGE_END);
        add(skin2, BorderLayout.PAGE_END);
        add(skin3, BorderLayout.PAGE_END);


        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
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


        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });
}

    private Boost crearPanelBoost(JPanel panelShop, CardLayout cardLayout, Usuario usuario){
        Boost boosts = new Boost(panelShop, cardLayout, usuario);
        return boosts;
    }

    private Skin crearPanelSkin(JPanel panelShop, CardLayout cardLayout, Usuario usuario){
        Skin skins= new Skin(panelShop,cardLayout,usuario);
        return skins;
    }

    private JPanel crearPanelMenu (Usuario usuario) {
        JPanel panel = new JPanel(new BorderLayout());

        JButton salirButton = new JButton("Salir");
        JButton skinsButton = new JButton("Skins");
        JButton boostsButton = new JButton("Mejoras");

        skinsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {cardLayout.show(panelShop, "Skins");}
        });

        boostsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelShop, "Mejoras");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return panel;
    }
}