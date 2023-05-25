import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Juego extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Minijuego minijuego;
    private Configuracion configuracion;
    private Shop shop;
    private Armario armario;
    private Usuario usuario;
    private EleccionDeRol eleccionDeRol;
    private JProgressBar experienceLabel;
    private JLabel levelLabel;
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
        usuario = new Usuario();
        usuario.setNivel(1);
        ;
        usuario.setXp(0);
        experienceMultiplier = 1.0;

        setTitle("Juego");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel panelMenu = crearPanelMenu();
        minijuego = crearPanelMinijuego(panelPrincipal, cardLayout);
        configuracion = crearPanelConfiguracion(panelPrincipal, cardLayout);
        shop = crearPanelShop(panelPrincipal, cardLayout);
        armario = crearPanelArmario(panelPrincipal, cardLayout);
        eleccionDeRol = crearPanelEleccionesDeRol(panelPrincipal, cardLayout);

        panelPrincipal.add(panelMenu, "menu");
        panelPrincipal.add(minijuego, "minijuego");
        panelPrincipal.add(configuracion, "Configuracion");
        panelPrincipal.add(shop, "Shop");
        panelPrincipal.add(armario, "Armario");
        panelPrincipal.add(eleccionDeRol,"Rol");

        cardLayout.show(panelPrincipal, "menu");

        add(panelPrincipal);
        setVisible(true);
    }

    private Minijuego crearPanelMinijuego(JPanel panelPrincipal, CardLayout cardLayout) {
        Minijuego minijuego = new Minijuego(panelPrincipal, cardLayout);
        return minijuego;
    }

    private Configuracion crearPanelConfiguracion(JPanel panelPrincipal, CardLayout cardLayout) {
        Configuracion configuracion = new Configuracion(panelPrincipal, cardLayout);
        return configuracion;
    }

    private Shop crearPanelShop(JPanel panelPrincipal, CardLayout cardLayout) {
        Shop shop = new Shop(panelPrincipal, cardLayout, usuario);
        return shop;
    }

    private Armario crearPanelArmario(JPanel panelPrincipal, CardLayout cardLayout) {
        Armario armario = new Armario(panelPrincipal, cardLayout, usuario);
        return armario;
    }
    private EleccionDeRol crearPanelEleccionesDeRol(JPanel panelPrincipal, CardLayout cardLayout){
        EleccionDeRol eleccionDeRol = new EleccionDeRol(panelPrincipal,cardLayout,usuario);
        return eleccionDeRol;
    }

    private JPanel crearPanelMenu() {
        JPanel panel = new JPanel(new BorderLayout());

        JButton salirButton = new JButton("Salir");
        JButton configuracionButton = new JButton("Configuracion");
        JButton minijuegoButton = new JButton("Minijuego");
        JButton shopButton = new JButton("Shop");
        JButton armarioButton = new JButton("Armario");
        JButton eleccionDeRol = new JButton("Rol");

        levelLabel = new JLabel("Rango: " + cambiarNivel(usuario.getNivel()));
        experienceLabel = new JProgressBar();
        JButton clickButton = new JButton(suelto);
        JButton closeButton = new JButton(apretado);

        minijuegoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "minijuego");
                minijuego.startMinijuego();
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        configuracionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Configuracion");
            }
        });

        shopButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Shop");
            }
        });

        armarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Armario");
            }
        });

        eleccionDeRol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Rol");}
        });

        JPanel buttonPanel = new JPanel(); // Panel adicional para los botones
        buttonPanel.setLayout(new FlowLayout()); // Utilizamos FlowLayout para alinear los botones
        buttonPanel.add(minijuegoButton);
        buttonPanel.add(configuracionButton);
        buttonPanel.add(shopButton);
        buttonPanel.add(armarioButton);
        buttonPanel.add(eleccionDeRol);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setPreferredSize(new Dimension(200, 100));
        bottomPanel.add(salirButton, BorderLayout.WEST);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(200, 100));
        topPanel.add(levelLabel, BorderLayout.WEST);
        topPanel.add(experienceLabel, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(clickButton, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        clickButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!isButtonPressed) {
                    usuario.setTapsCount(usuario.getTapsCount()+1);
                    gainExperience((int) (10 * experienceMultiplier));
                }
            }

            public void mousePressed(MouseEvent e) {
                isButtonPressed = true;
                clickButton.setEnabled(false);
                clickButton.setIcon(apretado);
            }

            public void mouseReleased(MouseEvent e) {
                isButtonPressed = false;
                clickButton.setEnabled(true);
                clickButton.setIcon(suelto);
            }
        });

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
        usuario.subirXP(amount);
        experienceLabel.setValue(usuario.getXp());

        if (usuario.getNivel() <= 9) {

            if (usuario.getXp() >= usuario.getNivel() * 100) {
                usuario.subirNivel();
                levelLabel.setText("Rango: " + cambiarNivel(usuario.getNivel()));

                if (!cambiarNivel(usuario.getNivel()).equals("Radiante")) {
                    usuario.setXp(0);
                }
            }
        } else {
            usuario.agregarCoins(10);
        }


        experienceLabel.setMaximum(usuario.getNivel() * 100);
        experienceLabel.setValue(usuario.getXp());
        experienceMultiplier += 0.6;
    }


}

