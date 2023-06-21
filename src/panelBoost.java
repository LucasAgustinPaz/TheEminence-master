import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class panelBoost extends JPanel {
    private JButton closeButton;
    private JButton Mouse;
    private JButton Teclado;
    private JButton Auriculares;
    private JButton RGB;
    private JButton MousePad;
    private JButton Coach1;
    private JButton Coach2;
    private JButton Coach3;
    private JButton Coach4;
    private JButton Coach5;
    private JButton eloBoost1;
    private JButton eloBoost2;
    private JButton eloBoost3;
    private JButton eloBoost4;
    private JButton eloBoost5;




    public panelBoost(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new FlowLayout());
        setPreferredSize(screenSize);

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        Teclado = new JButton("Teclado 250");
        Teclado.setBorderPainted(false);
        Teclado.setFocusPainted(false);
        Teclado.setBackground(Color.PINK.darker());

        Mouse = new JButton("Mouse 150");
        Mouse.setBorderPainted(false);
        Mouse.setFocusPainted(false);
        Mouse.setBackground(Color.PINK.darker());

        Auriculares = new JButton("Auriculares 500");
        Auriculares.setBorderPainted(false);
        Auriculares.setFocusPainted(false);
        Auriculares.setBackground(Color.PINK.darker());

        RGB = new JButton("RGB 50");
        RGB.setBorderPainted(false);
        RGB.setFocusPainted(false);
        RGB.setBackground(Color.PINK.darker());

        MousePad = new JButton("MousePad 100");
        MousePad.setBorderPainted(false);
        MousePad.setFocusPainted(false);
        MousePad.setBackground(Color.PINK.darker());

        Coach1 = new JButton("Coach1 25");
        Coach1.setBorderPainted(false);
        Coach1.setFocusPainted(false);
        Coach1.setBackground(Color.PINK.darker());

        Coach2 = new JButton("Coach2 35");
        Coach2.setBorderPainted(false);
        Coach2.setFocusPainted(false);
        Coach2.setBackground(Color.PINK.darker());

        Coach3 = new JButton("Coach3 50");
        Coach3.setBorderPainted(false);
        Coach3.setFocusPainted(false);
        Coach3.setBackground(Color.PINK.darker());

        Coach4 = new JButton("Coach4 60");
        Coach4.setBorderPainted(false);
        Coach4.setFocusPainted(false);
        Coach4.setBackground(Color.PINK.darker());

        Coach5 = new JButton("Coach5 100");
        Coach5.setBorderPainted(false);
        Coach5.setFocusPainted(false);
        Coach5.setBackground(Color.PINK.darker());

        eloBoost1 = new JButton("eloBoost1 100");
        eloBoost1.setBorderPainted(false);
        eloBoost1.setFocusPainted(false);
        eloBoost1.setBackground(Color.PINK.darker());

        eloBoost2 = new JButton("eloBoost2 150");
        eloBoost2.setBorderPainted(false);
        eloBoost2.setFocusPainted(false);
        eloBoost2.setBackground(Color.PINK.darker());

        eloBoost3 = new JButton("eloBoost3 200");
        eloBoost3.setBorderPainted(false);
        eloBoost3.setFocusPainted(false);
        eloBoost3.setBackground(Color.PINK.darker());

        eloBoost4 = new JButton("eloBoost4 250");
        eloBoost4.setBorderPainted(false);
        eloBoost4.setFocusPainted(false);
        eloBoost4.setBackground(Color.PINK.darker());

        eloBoost5 = new JButton("eloBoost5 320");
        eloBoost5.setBorderPainted(false);
        eloBoost5.setFocusPainted(false);
        eloBoost5.setBackground(Color.PINK.darker());

        add(closeButton, BorderLayout.PAGE_END);
        add(Teclado, BorderLayout.PAGE_END);
        add(Mouse, BorderLayout.PAGE_END);
        add(Auriculares, BorderLayout.PAGE_END);
        add(RGB, BorderLayout.PAGE_END);
        add(MousePad, BorderLayout.PAGE_END);
        add(Coach1, BorderLayout.PAGE_END);
        add(Coach2, BorderLayout.PAGE_END);
        add(Coach3, BorderLayout.PAGE_END);
        add(Coach4, BorderLayout.PAGE_END);
        add(Coach5, BorderLayout.PAGE_END);
        add(eloBoost1, BorderLayout.PAGE_END);
        add(eloBoost2, BorderLayout.PAGE_END);
        add(eloBoost3, BorderLayout.PAGE_END);
        add(eloBoost4, BorderLayout.PAGE_END);
        add(eloBoost5, BorderLayout.PAGE_END);



        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Tienda");
            }
        });


        Teclado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 250 && usuario.getPerifericos()[0].getNivel() < 5) {
                usuario.compra(250);
                usuario.getPerifericos()[0].subirNivel();
                }

                if(usuario.getPerifericos()[0].getNivel() == 5){usuario.getPerifericos()[0].setGold(true);}
            }
        });
        Mouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 150 && usuario.getPerifericos()[1].getNivel() < 5) {
                    usuario.compra(150);
                    usuario.getPerifericos()[1].subirNivel();
                }
            }
        });

        Auriculares.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 500 && usuario.getPerifericos()[2].getNivel() < 5) {
                    usuario.compra(500);
                    usuario.getPerifericos()[2].subirNivel();
                }
            }
        });
        RGB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 50) {
                    usuario.compra(50);
                }
            }
        });
        MousePad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 100 && usuario.getPerifericos()[4].getNivel() < 5) {
                    usuario.compra(100);
                    usuario.getPerifericos()[4].subirNivel();
                }
            }
        });

        Coach1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 25 && (usuario.getCoach()[0].getNivel()) < 1) {
                    usuario.compra(25);
                    usuario.getCoach()[0].setNivel(1);
                    usuario.getCoach()[0].sumarDuracion();
                }
                else if(usuario.getCoins() >= 25 && (usuario.getCoach()[0].getNivel()) == 1){
                    usuario.getCoach()[0].sumarDuracion();
                    usuario.compra(25);
                }
            }
        });

        Coach2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 35 && (usuario.getCoach()[1].getNivel()) < 1) {
                    usuario.compra(35);
                    usuario.getCoach()[1].setNivel(2);
                    usuario.getCoach()[1].sumarDuracion();
                }
                else if(usuario.getCoins() >= 35 && (usuario.getCoach()[1].getNivel()) == 2){
                    usuario.getCoach()[1].sumarDuracion();
                    usuario.compra(35);
                }
            }
        });

        Coach3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 50 && (usuario.getCoach()[2].getNivel()) < 1) {
                    usuario.compra(50);
                    usuario.getCoach()[2].setNivel(3);
                    usuario.getCoach()[2].sumarDuracion();
                }
                else if(usuario.getCoins() >= 50 && (usuario.getCoach()[2].getNivel()) == 3){
                    usuario.getCoach()[2].sumarDuracion();
                    usuario.compra(50);
                }
            }
        });
        Coach4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 60 && (usuario.getCoach()[3].getNivel()) < 1) {
                    usuario.compra(60);
                    usuario.getCoach()[3].setNivel(4);
                    usuario.getCoach()[3].sumarDuracion();
                }
                else if(usuario.getCoins() >= 60 && (usuario.getCoach()[3].getNivel()) == 4){
                    usuario.getCoach()[3].sumarDuracion();
                    usuario.compra(60);
                }
            }
        });
        Coach5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if (usuario.getCoins() >= 100 && (usuario.getCoach()[4].getNivel()) < 1) {
                        usuario.compra(100);
                        usuario.getCoach()[4].setNivel(5);
                        usuario.getCoach()[4].sumarDuracion();
                    }
                    else if(usuario.getCoins() >= 100 && (usuario.getCoach()[4].getNivel()) == 5){
                        usuario.getCoach()[4].sumarDuracion();
                        usuario.compra(100);
                    }
            }
        });

        eloBoost1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 100 && (usuario.getEloboost()[0].getNivel()) < 1) {
                    usuario.compra(100);
                    usuario.getEloboost()[0].setNivel(1);
                    usuario.getEloboost()[0].sumarDuracion();
                }
                else if(usuario.getCoins() >= 100 && (usuario.getEloboost()[0].getNivel()) == 1){
                    usuario.getEloboost()[0].sumarDuracion();
                    usuario.compra(100);
                }
            }
        });
        eloBoost2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 150 && (usuario.getEloboost()[1].getNivel()) < 1) {
                    usuario.compra(150);
                    usuario.getEloboost()[1].setNivel(2);
                    usuario.getEloboost()[1].sumarDuracion();
                }
                else if(usuario.getCoins() >= 150 && (usuario.getEloboost()[1].getNivel()) == 2){
                    usuario.getEloboost()[1].sumarDuracion();
                    usuario.compra(150);
                }
            }
        });
        eloBoost3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 200 && (usuario.getEloboost()[2].getNivel()) < 1) {
                    usuario.compra(200);
                    usuario.getEloboost()[2].setNivel(3);
                    usuario.getEloboost()[2].sumarDuracion();
                }
                else if(usuario.getCoins() >= 200 && (usuario.getEloboost()[2].getNivel()) == 3){
                    usuario.getEloboost()[2].sumarDuracion();
                    usuario.compra(200);
                }
            }
        });
        eloBoost4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 250 && (usuario.getEloboost()[3].getNivel()) < 1) {
                    usuario.compra(250);
                    usuario.getEloboost()[3].setNivel(4);
                    usuario.getEloboost()[3].sumarDuracion();
                }
                else if(usuario.getCoins() >= 250 && (usuario.getEloboost()[3].getNivel()) == 4){
                    usuario.getEloboost()[3].sumarDuracion();
                    usuario.compra(250);
                }
            }
        });
        eloBoost5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() >= 320 && (usuario.getEloboost()[4].getNivel()) < 1) {
                    usuario.compra(320);
                    usuario.getEloboost()[4].setNivel(5);
                    usuario.getEloboost()[4].sumarDuracion();
                }
                else if(usuario.getCoins() >= 320 && (usuario.getEloboost()[4].getNivel()) == 5){
                    usuario.getEloboost()[4].sumarDuracion();
                    usuario.compra(320);
                }
            }
        });



    }

}
