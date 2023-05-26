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


    public Shop(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1920, 1080));

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

    }

}
