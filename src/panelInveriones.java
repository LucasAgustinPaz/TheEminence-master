import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class panelInveriones extends JPanel {
    private JButton closeButton;
    private JButton inversion1Button;
    private JButton inversion2Button;
    private JButton inversion3Button;


    public panelInveriones(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        inversion1Button = new JButton("inversion1 $1000");
        inversion1Button.setBorderPainted(false);
        inversion1Button.setFocusPainted(false);
        inversion1Button.setBackground(Color.MAGENTA.darker());

        inversion2Button = new JButton("inversion2 $1500");
        inversion2Button.setBorderPainted(false);
        inversion2Button.setFocusPainted(false);
        inversion2Button.setBackground(Color.MAGENTA.darker());

        inversion3Button = new JButton("inversion3 $500");
        inversion3Button.setBorderPainted(false);
        inversion3Button.setFocusPainted(false);
        inversion3Button.setBackground(Color.MAGENTA.darker());





        add(closeButton, BorderLayout.PAGE_END);
        add(inversion1Button, BorderLayout.PAGE_END);
        add(inversion2Button, BorderLayout.PAGE_END);
        add(inversion3Button, BorderLayout.PAGE_END);



        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        inversion1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.getCoins()>=1000) {
                    usuario.getInversiones().aumentarInversion1();
                    System.out.println("1");
                    usuario.compra(1000);
                }
                }
        });

        inversion2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.getCoins()>=1500) {
                    usuario.getInversiones().aumentarInversion2();
                    System.out.println("2");
                    usuario.compra(1500);
                }
            }
        });

        inversion3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.getCoins()>=500) {
                    usuario.getInversiones().aumentarInversion3();
                    System.out.println("3");
                    usuario.compra(500);
                }
            }
        });


    }

}
