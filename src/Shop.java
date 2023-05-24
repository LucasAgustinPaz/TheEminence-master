import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Shop extends JPanel {
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 400;
    private static final int OBJECT_SIZE = 50;
    private static final int CLICK_RADIUS = 30;
    private JButton closeButton;
    private JButton skin1;
    private JButton skin2;
    private JButton skin3;


    public Shop(JPanel panelPrincipal, CardLayout cardLayout){
        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        skin1 = new JButton("vandal prime");
        skin1.setBorderPainted(false);
        skin1.setFocusPainted(false);
        skin1.setBackground(Color.ORANGE.darker());

        skin2 = new JButton("La mama de gaspar");
        skin2.setBorderPainted(false);
        skin2.setFocusPainted(false);
        skin2.setBackground(Color.PINK.darker());

        skin3= new JButton("vandal re fachera");
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


    }

}
