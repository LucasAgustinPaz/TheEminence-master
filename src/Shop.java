import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Shop extends JPanel {
    private JButton closeButton;
    private JPanel panelShop;
    private JButton skin1;
    private JButton skin2;
    private JButton skin3;
    private JButton boosts1;
    private JButton boosts2;
    private JButton boosts3;
    private Boost boosts;
    private Skin skins;



    public Shop(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);


        panelShop.add(panelShop);
        panelShop = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JPanel closeBottonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());


        JPanel panelMenu = crearPanelMenu(usuario, cardLayout);
        boosts = crearPanelBoost(panelShop,cardLayout,usuario);
        skins= crearPanelSkin(panelShop,cardLayout,usuario);

        panelShop.add(panelMenu, "Menu");
        panelShop.add(boosts,"Mejoras");
        panelShop.add(skins,"Skins");

        cardLayout.show(panelShop, "menu");

        add(panelShop);
        setVisible(true);
}

    private Boost crearPanelBoost(JPanel panelShop, CardLayout cardLayout, Usuario usuario){
        Boost boosts = new Boost(panelShop, cardLayout, usuario);
        return boosts;
    }

    private Skin crearPanelSkin(JPanel panelShop, CardLayout cardLayout, Usuario usuario){
        Skin skins= new Skin(panelShop,cardLayout,usuario);
        return skins;
    }

    private JPanel crearPanelMenu (Usuario usuario, CardLayout cardLayout) {
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