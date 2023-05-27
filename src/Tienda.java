import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Tienda extends JPanel {
    private JButton closeButton;
    private JButton skin;
    private JButton boost;



    public Tienda(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new FlowLayout());
        setPreferredSize(screenSize);

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        skin = new JButton("skin");
        skin.setBorderPainted(false);
        skin.setFocusPainted(false);
        skin.setBackground(Color.ORANGE.darker());

        boost = new JButton("boost");


        boost.setBorderPainted(false);
        boost.setFocusPainted(false);
        boost.setBackground(Color.PINK.darker());




        add(closeButton, BorderLayout.PAGE_END);
        add(skin, BorderLayout.PAGE_END);
        add(boost, BorderLayout.PAGE_END);



        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });


        skin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Shop");
            }
        });


        boost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Boost");}
        });



    }



}
