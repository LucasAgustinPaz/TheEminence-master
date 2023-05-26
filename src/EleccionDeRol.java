import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EleccionDeRol extends JPanel {
    private JButton closeButton;
    private JButton Duelista;
    private JButton Centinela;
    private JButton Smoker;
    private JButton Iniciador;


    public EleccionDeRol(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario){
        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        Duelista = new JButton("Duelista");
        Duelista.setBorderPainted(false);
        Duelista.setFocusPainted(false);
        Duelista.setBackground(Color.ORANGE.darker());

        Centinela = new JButton("Centinela");
        Centinela.setBorderPainted(false);
        Centinela.setFocusPainted(false);
        Centinela.setBackground(Color.PINK.darker());

        Smoker= new JButton("Smoker");
        Smoker.setBorderPainted(false);
        Smoker.setFocusPainted(false);
        Smoker.setBackground(Color.CYAN.darker());

        Iniciador= new JButton("Iniciador");
        Iniciador.setBorderPainted(false);
        Iniciador.setFocusPainted(false);
        Iniciador.setBackground(Color.CYAN.darker());


        add(closeButton, BorderLayout.PAGE_END);
        add(Duelista, BorderLayout.PAGE_END);
        add(Centinela, BorderLayout.PAGE_END);
        add(Smoker, BorderLayout.PAGE_END);
        add(Iniciador, BorderLayout.PAGE_END);


        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        Duelista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             usuario.setRol("Duelista");
                System.out.println(usuario.getRol());
            }
        });
        Centinela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             usuario.setRol("Centinela");
                System.out.println(usuario.getRol());
            }
        });
        Smoker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol("Smoker");
                System.out.println(usuario.getRol());
            }
        });
        Iniciador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol("Iniciador");
                System.out.println(usuario.getRol());
            }
        });




    }

}
