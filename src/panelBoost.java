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

    ImageIcon auriculares = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_auriculares.png");
    ImageIcon led = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_led.png");
    ImageIcon mouse = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_mouse.png");
    ImageIcon mousepad = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_mousepad.png");
    ImageIcon teclado = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_teclado.png");
    ImageIcon coach_1 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_1.png");
    ImageIcon coach_2 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_2.png");
    ImageIcon coach_3 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_3.png");
    ImageIcon coach_4 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_4.png");
    ImageIcon coach_5 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_5.png");
    ImageIcon eloboost_1 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_1.png");
    ImageIcon eloboost_2 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_2.png");
    ImageIcon eloboost_3 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_3.png");
    ImageIcon eloboost_4 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_4.png");
    ImageIcon eloboost_5 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_5.png");

    public panelBoost(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new FlowLayout());
        setPreferredSize(screenSize);

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        Teclado = new JButton(teclado);
        Teclado.setBorder(Main.emptyBorder);
        Teclado.setBackground(Main.transparentColor);
        Teclado.setOpaque(false);
        Teclado.setContentAreaFilled(false);
        Teclado.setBorderPainted(false);

        Mouse = new JButton(mouse);
        Mouse.setBorder(Main.emptyBorder);
        Mouse.setBackground(Main.transparentColor);
        Mouse.setOpaque(false);
        Mouse.setContentAreaFilled(false);
        Mouse.setBorderPainted(false);

        Auriculares = new JButton(auriculares);
        Auriculares.setBorder(Main.emptyBorder);
        Auriculares.setBackground(Main.transparentColor);
        Auriculares.setOpaque(false);
        Auriculares.setContentAreaFilled(false);
        Auriculares.setBorderPainted(false);

        RGB = new JButton(led);
        RGB.setBorder(Main.emptyBorder);
        RGB.setBackground(Main.transparentColor);
        RGB.setOpaque(false);
        RGB.setContentAreaFilled(false);
        RGB.setBorderPainted(false);

        MousePad = new JButton(mousepad);
        MousePad.setBorder(Main.emptyBorder);
        MousePad.setBackground(Main.transparentColor);
        MousePad.setOpaque(false);
        MousePad.setContentAreaFilled(false);
        MousePad.setBorderPainted(false);

        Coach1 = new JButton(coach_1);
        Coach1.setBorder(Main.emptyBorder);
        Coach1.setBackground(Main.transparentColor);
        Coach1.setOpaque(false);
        Coach1.setContentAreaFilled(false);
        Coach1.setBorderPainted(false);

        Coach2 = new JButton(coach_2);
        Coach2.setBorder(Main.emptyBorder);
        Coach2.setBackground(Main.transparentColor);
        Coach2.setOpaque(false);
        Coach2.setContentAreaFilled(false);
        Coach2.setBorderPainted(false);

        Coach3 = new JButton(coach_3);
        Coach3.setBorder(Main.emptyBorder);
        Coach3.setBackground(Main.transparentColor);
        Coach3.setOpaque(false);
        Coach3.setContentAreaFilled(false);
        Coach3.setBorderPainted(false);

        Coach4 = new JButton(coach_4);
        Coach4.setBorder(Main.emptyBorder);
        Coach4.setBackground(Main.transparentColor);
        Coach4.setOpaque(false);
        Coach4.setContentAreaFilled(false);
        Coach4.setBorderPainted(false);

        Coach5 = new JButton(coach_5);
        Coach5.setBorder(Main.emptyBorder);
        Coach5.setBackground(Main.transparentColor);
        Coach5.setOpaque(false);
        Coach5.setContentAreaFilled(false);
        Coach5.setBorderPainted(false);

        eloBoost1 = new JButton(eloboost_1);
        eloBoost1.setBorder(Main.emptyBorder);
        eloBoost1.setBackground(Main.transparentColor);
        eloBoost1.setOpaque(false);
        eloBoost1.setContentAreaFilled(false);
        eloBoost1.setBorderPainted(false);

        eloBoost2 = new JButton(eloboost_2);
        eloBoost2.setBorder(Main.emptyBorder);
        eloBoost2.setBackground(Main.transparentColor);
        eloBoost2.setOpaque(false);
        eloBoost2.setContentAreaFilled(false);
        eloBoost2.setBorderPainted(false);

        eloBoost3 = new JButton(eloboost_3);
        eloBoost3.setBorder(Main.emptyBorder);
        eloBoost3.setBackground(Main.transparentColor);
        eloBoost3.setOpaque(false);
        eloBoost3.setContentAreaFilled(false);
        eloBoost3.setBorderPainted(false);

        eloBoost4 = new JButton(eloboost_4);
        eloBoost4.setBorder(Main.emptyBorder);
        eloBoost4.setBackground(Main.transparentColor);
        eloBoost4.setOpaque(false);
        eloBoost4.setContentAreaFilled(false);
        eloBoost4.setBorderPainted(false);

        eloBoost5 = new JButton(eloboost_5);
        eloBoost5.setBorder(Main.emptyBorder);
        eloBoost5.setBackground(Main.transparentColor);
        eloBoost5.setOpaque(false);
        eloBoost5.setContentAreaFilled(false);
        eloBoost5.setBorderPainted(false);

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

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(closeButton);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        JPanel centerPanel2 = new JPanel(new GridBagLayout());
        JPanel centerPanel3 = new JPanel(new GridBagLayout());
        centerPanel.add(Teclado);
        centerPanel.add(Mouse);
        centerPanel.add(MousePad);
        centerPanel.add(Auriculares);
        centerPanel.add(RGB);
        centerPanel2.add(Coach1);
        centerPanel2.add(Coach2);
        centerPanel2.add(Coach3);
        centerPanel2.add(Coach4);
        centerPanel2.add(Coach5);
        centerPanel3.add(eloBoost1);
        centerPanel3.add(eloBoost2);
        centerPanel3.add(eloBoost3);
        centerPanel3.add(eloBoost4);
        centerPanel3.add(eloBoost5);


        add(buttonPanel, BorderLayout.PAGE_END);
        add(centerPanel, BorderLayout.NORTH);
        add(centerPanel2, BorderLayout.CENTER);
        add(centerPanel3, BorderLayout.SOUTH);



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
