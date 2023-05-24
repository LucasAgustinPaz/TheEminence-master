import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Juego extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Gameplay gameplay;
    private Minijuego minijuego;
    private Configuracion configuracion;
    private Shop shop;
    private Armario armario;

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public Juego() {
        setTitle("Juego");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel panelMenu = crearPanelMenu();

        gameplay = crearPanelJuego();
        minijuego = crearPanelMinijuego(panelPrincipal,cardLayout);
        configuracion = crearPanelConfiguracion(panelPrincipal,cardLayout);
        shop = crearPanelShop(panelPrincipal,cardLayout);
        armario = crearPanelArmario(panelPrincipal,cardLayout);


        panelPrincipal.add(panelMenu, "menu");
        panelPrincipal.add(gameplay, "juego");
        panelPrincipal.add(crearPanelMinijuego(panelPrincipal,cardLayout),"minijuego");
        panelPrincipal.add(crearPanelConfiguracion(panelPrincipal,cardLayout),"Configuracion");
        panelPrincipal.add(crearPanelShop(panelPrincipal,cardLayout),"Shop");
        panelPrincipal.add(crearPanelArmario(panelPrincipal,cardLayout), "Armario");

        cardLayout.show(panelPrincipal, "menu");

        add(panelPrincipal);
        setVisible(true);
    }

    private Minijuego crearPanelMinijuego(JPanel panelPrincipal,CardLayout cardLayout){
        Minijuego minijuego = new Minijuego(panelPrincipal,cardLayout);
        return minijuego;
    }
    private Gameplay crearPanelJuego() {
        Gameplay gameplay = new Gameplay();
        return gameplay;
    }
    private Configuracion crearPanelConfiguracion(JPanel panelPrincipal,CardLayout cardLayout){
        Configuracion configuracion = new Configuracion(panelPrincipal,cardLayout);
        return configuracion;
    }
    private Shop crearPanelShop(JPanel panelPrincipal,CardLayout cardLayout){
        Shop shop = new Shop(panelPrincipal,cardLayout);
        return shop;
    }
    private Armario crearPanelArmario(JPanel panelPrincipal,CardLayout cardLayout) {
        Armario armario = new Armario(panelPrincipal,cardLayout);
        return armario;
    }

    private JPanel crearPanelMenu() {
        JPanel panel = new JPanel(new FlowLayout());

        JButton jugarButton = new JButton("Jugar");
        JButton salirButton = new JButton("Salir");
        JButton configuracionButton = new JButton("Configuracion");
        JButton minijuegoB = new JButton("minijuego");
        JButton shopButton = new JButton("Shop");
        JButton armarioButton = new JButton("Armario");

        minijuegoB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal,"minijuego");
                minijuego.startMinijuego();
            }
        });

        jugarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "juego");
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        configuracionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Configuracion");}
        });

        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Shop");}
        });

        armarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Armario");}
        });


        panel.add(new JLabel("Juego"));
        panel.add(jugarButton);
        panel.add(salirButton);
        panel.add(minijuegoB);
        panel.add(configuracionButton);
        panel.add(shopButton);
        panel.add(armarioButton);



        return panel;




    }

}