import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Juego extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Minijuego minijuego;
    private Configuracion configuracion;
    private Shop shop;
    private Armario armario;
    private JProgressBar experienceLabel;
    private JLabel levelLabel;
    private int level;
    private int experience;

    private double experienceMultiplier;
    private boolean isButtonPressed = false;

    private ImageIcon suelto = new ImageIcon("resources\\sprites\\button1.png");
    private ImageIcon apretado = new ImageIcon("resources\\sprites\\button2.png");

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }


    public Juego() {
        level = 1;
        experience = 0;
        experienceMultiplier = 1.0;

        setTitle("Juego");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel panelMenu = crearPanelMenu();
        minijuego = crearPanelMinijuego(panelPrincipal,cardLayout);
        configuracion = crearPanelConfiguracion(panelPrincipal,cardLayout);
        shop = crearPanelShop(panelPrincipal,cardLayout);
        armario = crearPanelArmario(panelPrincipal,cardLayout);


        panelPrincipal.add(panelMenu, "menu");
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

        JButton salirButton = new JButton("Salir");
        JButton configuracionButton = new JButton("Configuracion");
        JButton minijuegoB = new JButton("minijuego");
        JButton shopButton = new JButton("Shop");
        JButton armarioButton = new JButton("Armario");

        levelLabel = new JLabel("Rango: " + cambiarNivel(level));
        experienceLabel = new JProgressBar();
        JButton clickButton = new JButton(suelto);
        JButton closeButton = new JButton(apretado);


        minijuegoB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal,"minijuego");
                minijuego.startMinijuego();
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


        clickButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!isButtonPressed) {
                    gainExperience((int) (10 * experienceMultiplier)); // Ganar experiencia multiplicada por el multiplicador actual
                }
            }

            public void mousePressed(MouseEvent e) {
                isButtonPressed = true; // El botón está presionado cuando se hace clic
                clickButton.setEnabled(false); // Desactivar el botón mientras está presionado
                clickButton.setIcon(apretado);
            }

            public void mouseReleased(MouseEvent e) {
                isButtonPressed = false; // El botón se suelta
                clickButton.setEnabled(true); // Reactivar el botón
                clickButton.setIcon(suelto);
            }
        });


        panel.add(new JLabel("Juego"));
        panel.add(salirButton);
        panel.add(minijuegoB);
        panel.add(configuracionButton);
        panel.add(shopButton);
        panel.add(armarioButton);
        panel.add(levelLabel, BorderLayout.WEST);
        panel.add(experienceLabel, BorderLayout.CENTER);
        panel.add(clickButton, BorderLayout.EAST);





        return panel;




    }

    public String cambiarNivel(int level) {
        String nombreNivel = "Hierro";

        if (level == 2) {
            nombreNivel = "Bronce";
        } else if (level == 3) {
            nombreNivel = "Plata";
        } else if (level == 4) {
            nombreNivel = "Oro";
        } else if (level == 5) {
            nombreNivel = "Platino";
        } else if (level == 6) {
            nombreNivel = "Diamante";
        } else if (level == 7) {
            nombreNivel = "Ascendente";
        } else if (level == 8) {
            nombreNivel = "Inmortal";
        } else if (level >= 9) {
            nombreNivel = "Radiante";
        }

        return nombreNivel;
    }

    private void gainExperience(int amount) {
        experience += amount;
        experienceLabel.setValue(experience);

        if (experience >= level * 100) {
            level++;
            levelLabel.setText("Rango: " + cambiarNivel(level));

            if (cambiarNivel(level) != "Radiante") {
                experience = 0;
            }

            experienceLabel.setMaximum(level * 100);
            experienceLabel.setValue(experience);
            experienceMultiplier += 0.6; // Aumentar el multiplicador en 0.5
        }
    }



}