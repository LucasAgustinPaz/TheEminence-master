import com.google.gson.Gson;

import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class Juego extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Minijuego minijuego;
    private Configuracion configuracion;
    private Tienda Tienda;
    private Shop shop;
    private PanelBoost panelBoost;
    private Armario armario;
    private Estadistica estadistica;
    private EleccionDeRol eleccionDeRol;
    private Smurfear smurfear;
    private panelInversiones inveriones;
    private JLabel levelLabel;
    private int estadoMusica = 1;
    private Clip clip;
    private PanelVictoria panelVictoria;
    private boolean isButtonPressed = false;
    private ImageIcon suelto = new ImageIcon("resources\\sprites\\Assets\\skins baldu\\skin_1.png");
    private ImageIcon configuracionboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_configuracion.png");
    private ImageIcon armarioboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_armario.png");
    private ImageIcon smurfboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_smurf.png");
    private ImageIcon statsboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_stats.png");
    private ImageIcon tiendaboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_tienda.png");
    private ImageIcon rolboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_rol.png");
    private ImageIcon inversionesboton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_inversiones.png");
    private ImageIcon minijuegoBoton = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_minijuego.png");
    private ImageIcon hierro = new ImageIcon("resources\\sprites\\Assets\\tiers\\hierro.png");
    private ImageIcon ascendente = new ImageIcon("resources\\sprites\\Assets\\tiers\\ascendente.png");
    private ImageIcon bronce = new ImageIcon("resources\\sprites\\Assets\\tiers\\bronce.png");
    private ImageIcon diamante = new ImageIcon("resources\\sprites\\Assets\\tiers\\diamante.png");
    private ImageIcon inmortal = new ImageIcon("resources\\sprites\\Assets\\tiers\\inmortal.png");
    private ImageIcon oro = new ImageIcon("resources\\sprites\\Assets\\tiers\\oro.png");
    private ImageIcon plata = new ImageIcon("resources\\sprites\\Assets\\tiers\\plata.png");
    private ImageIcon platino = new ImageIcon("resources\\sprites\\Assets\\tiers\\platino.png");
    private ImageIcon radiante = new ImageIcon("resources\\sprites\\Assets\\tiers\\radiante.png");


    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public Juego(Usuario usuario, JProgressBar experienceLabel) {
        PlayMusic("resources\\musica\\melodia.wav");
        usuario.setStartTime(System.currentTimeMillis()); //Seteo tiempo de inicio

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);


        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel panelMenu = crearPanelMenu(usuario, experienceLabel);
        minijuego = crearPanelMinijuego(panelPrincipal, cardLayout, usuario);
        configuracion = crearPanelConfiguracion(panelPrincipal, cardLayout, estadoMusica, clip);
        Tienda = crearPanelTienda(panelPrincipal, cardLayout, usuario);
        armario = crearPanelArmario(panelPrincipal, cardLayout, usuario);
        estadistica = crearPanelEstadistica(panelPrincipal, cardLayout, usuario);
        eleccionDeRol = crearPanelEleccionesDeRol(panelPrincipal, cardLayout, usuario);
        smurfear = crearPanelSmurfear(panelPrincipal, cardLayout, usuario);
        inveriones = crearPanelInversiones(panelPrincipal, cardLayout, usuario);
        shop = crearPanelShop(panelPrincipal, cardLayout, usuario);
        panelBoost = crearPanelBoost(panelPrincipal, cardLayout, usuario);
        panelVictoria = crearPanelVictoria(panelPrincipal, cardLayout, usuario);


        panelPrincipal.add(panelMenu, "menu");
        panelPrincipal.add(minijuego, "minijuego");
        panelPrincipal.add(configuracion, "Configuracion");
        panelPrincipal.add(Tienda, "Tienda");
        panelPrincipal.add(armario, "Armario");
        panelPrincipal.add(estadistica, "Estadistica");
        panelPrincipal.add(eleccionDeRol, "Rol");
        panelPrincipal.add(smurfear, "Smurfear");
        panelPrincipal.add(inveriones, "Inversiones");
        panelPrincipal.add(shop,"Shop");
        panelPrincipal.add(panelBoost,"Boost");
        panelPrincipal.add(panelVictoria, "Victoria");

        cardLayout.show(panelPrincipal, "menu");

        add(panelPrincipal);
        setVisible(true);
    }

    private PanelVictoria crearPanelVictoria(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        PanelVictoria panelVictoria = new PanelVictoria(panelPrincipal, cardLayout, usuario);
        return panelVictoria;
    }

    private Minijuego crearPanelMinijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Minijuego minijuego = new Minijuego(panelPrincipal, cardLayout, usuario);
        return minijuego;
    }

    private Configuracion crearPanelConfiguracion(JPanel panelPrincipal, CardLayout cardLayout, int estadoMusica, Clip clip) {
        Configuracion configuracion = new Configuracion(panelPrincipal, cardLayout, estadoMusica, clip);
        return configuracion;
    }

    private Tienda crearPanelTienda(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Tienda Tienda = new Tienda(panelPrincipal, cardLayout, usuario);
        return Tienda;
    }

    private Armario crearPanelArmario(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Armario armario = new Armario(panelPrincipal, cardLayout, usuario);
        return armario;
    }

    private Estadistica crearPanelEstadistica(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Estadistica estadistica = new Estadistica(panelPrincipal, cardLayout, usuario);
        return estadistica;
    }

    private EleccionDeRol crearPanelEleccionesDeRol(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        EleccionDeRol eleccionDeRol = new EleccionDeRol(panelPrincipal, cardLayout, usuario);
        return eleccionDeRol;
    }

    private Smurfear crearPanelSmurfear(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Smurfear smurfear = new Smurfear(panelPrincipal, cardLayout, usuario);
        return smurfear;
    }

    private panelInversiones crearPanelInversiones(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        panelInversiones inveriones = new panelInversiones(panelPrincipal, cardLayout, usuario);
        return inveriones;
    }

    private Shop crearPanelShop(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Shop shop = new Shop(panelPrincipal, cardLayout, usuario);
        return shop;
    }
    private PanelBoost crearPanelBoost(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario){
        PanelBoost panelBoost = new PanelBoost(panelPrincipal, cardLayout, usuario);
        return panelBoost;
    }

    private JPanel crearPanelMenu(Usuario usuario, JProgressBar experienceLabel) {
        JPanel panel = new JPanel(new BorderLayout());


        JButton salirButton = new JButton(Main.cerrar);
        salirButton.setBorder(Main.emptyBorder);
        salirButton.setBackground(Main.transparentColor);
        salirButton.setOpaque(false);
        salirButton.setContentAreaFilled(false);
        salirButton.setBorderPainted(false);

        JButton configuracionButton = new JButton(configuracionboton);
        configuracionButton.setBorder(Main.emptyBorder);
        configuracionButton.setBackground(Main.transparentColor);
        configuracionButton.setOpaque(false);
        configuracionButton.setContentAreaFilled(false);
        configuracionButton.setBorderPainted(false);

        JButton minijuegoButton = new JButton(minijuegoBoton);
        minijuegoButton.setBorder(Main.emptyBorder);
        minijuegoButton.setBackground(Main.transparentColor);
        minijuegoButton.setOpaque(false);
        minijuegoButton.setContentAreaFilled(false);
        minijuegoButton.setBorderPainted(false);

        JButton TiendaButton = new JButton(tiendaboton);
        TiendaButton.setBorder(Main.emptyBorder);
        TiendaButton.setBackground(Main.transparentColor);
        TiendaButton.setOpaque(false);
        TiendaButton.setContentAreaFilled(false);
        TiendaButton.setBorderPainted(false);

        JButton armarioButton = new JButton(armarioboton);
        armarioButton.setBorder(Main.emptyBorder);
        armarioButton.setBackground(Main.transparentColor);
        armarioButton.setOpaque(false);
        armarioButton.setContentAreaFilled(false);
        armarioButton.setBorderPainted(false);

        JButton estadisticaButton = new JButton(statsboton);
        estadisticaButton.setBorder(Main.emptyBorder);
        estadisticaButton.setBackground(Main.transparentColor);
        estadisticaButton.setOpaque(false);
        estadisticaButton.setContentAreaFilled(false);
        estadisticaButton.setBorderPainted(false);

        JButton eleccionDeRol = new JButton(rolboton);
        eleccionDeRol.setBorder(Main.emptyBorder);
        eleccionDeRol.setBackground(Main.transparentColor);
        eleccionDeRol.setOpaque(false);
        eleccionDeRol.setContentAreaFilled(false);
        eleccionDeRol.setBorderPainted(false);

        JButton smurfear = new JButton(smurfboton);
        smurfear.setBorder(Main.emptyBorder);
        smurfear.setBackground(Main.transparentColor);
        smurfear.setOpaque(false);
        smurfear.setContentAreaFilled(false);
        smurfear.setBorderPainted(false);

        JButton inversiones = new JButton(inversionesboton);
        inversiones.setBorder(Main.emptyBorder);
        inversiones.setBackground(Main.transparentColor);
        inversiones.setOpaque(false);
        inversiones.setContentAreaFilled(false);
        inversiones.setBorderPainted(false);

        levelLabel = new JLabel();
        levelLabel.setIcon(cambiarNivel(usuario.getNivel(),usuario));

        JButton clickButton = new JButton(suelto);
        clickButton.setBorder(Main.emptyBorder);
        clickButton.setBackground(Main.transparentColor);
        clickButton.setOpaque(false);
        clickButton.setContentAreaFilled(false);
        clickButton.setBorderPainted(false);

        JButton closeButton = new JButton(suelto);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);


        minijuegoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "minijuego");
                minijuego.startMinijuego(panelPrincipal, cardLayout, usuario);
            }
        });

        salirButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarUsuarioComoJSON(usuario,"resources\\usuario.json");
                System.exit(0);
            }
        });

        configuracionButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Configuracion");
            }
        });

        TiendaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Tienda");
            }
        });

        armarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Armario");
            }
        });

        estadisticaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setEndTime(System.currentTimeMillis()); //Seteo tiempo de fin
                estadistica.actualizarEstadisticas(usuario);
                cardLayout.show(panelPrincipal, "Estadistica");
            }
        });
        eleccionDeRol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Rol");
            }
        });
        smurfear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Smurfear");
            }
        });

        inversiones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Inversiones");
            }
        });

        JPanel buttonPanel = new JPanel(); // Panel adicional para los botones
        buttonPanel.setLayout(new FlowLayout()); // Utilizamos FlowLayout para alinear los botones
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(minijuegoButton);
        buttonPanel.add(configuracionButton);
        buttonPanel.add(TiendaButton);
        buttonPanel.add(armarioButton);
        buttonPanel.add(estadisticaButton);
        buttonPanel.add(eleccionDeRol);
        buttonPanel.add(smurfear);
        buttonPanel.add(inversiones);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(Color.BLACK);
        bottomPanel.setPreferredSize(new Dimension(200, 100));
        bottomPanel.add(salirButton, BorderLayout.WEST);
        bottomPanel.add(buttonPanel, BorderLayout.CENTER);


        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setPreferredSize(new Dimension(200, 100));
        topPanel.add(levelLabel, BorderLayout.WEST);

        experienceLabel.setBorder(Main.emptyBorder);
        experienceLabel.setBackground(Main.transparentColor);
        experienceLabel.setOpaque(false);
        experienceLabel.setBorderPainted(false);
        topPanel.add(experienceLabel, BorderLayout.CENTER);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(clickButton, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        panel.setBackground(Color.BLACK);

        clickButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!isButtonPressed) {
                    gainExperience((int) (10 * usuario.getExperienceMultiplier()), usuario, experienceLabel);
                    usuario.sumarClick();
                }
            }

            public void mousePressed(MouseEvent e) {
                isButtonPressed = true;
                clickButton.setEnabled(false);
                clickButton.setIcon(suelto);
            }

            public void mouseReleased(MouseEvent e) {
                isButtonPressed = false;
                clickButton.setEnabled(true);
                clickButton.setIcon(suelto);
            }

        });

        return panel;
    }

    public boolean startTorneo(int level, Usuario usuario) {

        int limite = (int) ((usuario.getNivel() * 10) / 3);

        if (minijuego.getScore() < limite && usuario.getNivel() < 9) {
            System.out.println("Torneo Iniciado");
            cardLayout.show(panelPrincipal, "minijuego");
            minijuego.startMinijuego(panelPrincipal, cardLayout, usuario);
        }
        if (minijuego.getScore() >= limite) {
            minijuego.setScore(0);
            return true;
        }
        return false;
    }

    public ImageIcon cambiarNivel(int level, Usuario user) {
        ImageIcon spriteNivel = hierro;

        if (level == 2) {
            spriteNivel = bronce;
        } else if (level == 3) {
            spriteNivel = plata;
        } else if (level == 4) {
            spriteNivel = oro;
        } else if (level == 5) {
            spriteNivel = platino;
            user.agregarCoins(1000);
        } else if (level == 6) {
            spriteNivel = diamante;
        } else if (level == 7) {
            spriteNivel = ascendente;
        } else if (level == 8) {
            spriteNivel = inmortal;
        } else if (level >= 9) {
            spriteNivel = radiante;
        }

        return spriteNivel;
    }


    private void gainExperience(int amount, Usuario usuario, JProgressBar experienceLabel) {
        usuario.subirXP((amount * (1000 + usuario.obtenerNivelRango() + usuario.sumarBoost() + usuario.coachMayor().getNivel())));
        experienceLabel.setValue(usuario.getXp());

        if (usuario.getNivel() < 9) {
            if (usuario.getXp() >= usuario.getNivel() * 50000 && startTorneo(usuario.getNivel(), usuario)) {
                usuario.subirNivel();
                usuario.setPromoGanada(false);
                usuario.aumentaExperienceMultiplier();
                usuario.coachMayor().restarDuracion();
                usuario.eloboostMayor().restarDuracion();
                levelLabel.setIcon(cambiarNivel(usuario.getNivel(), usuario));

                if (!cambiarNivel(usuario.getNivel(), usuario).equals("Radiante")) {
                    usuario.setXp(0);
                }
            }
        } else {
            usuario.agregarCoins(2);
        }


        experienceLabel.setMaximum(usuario.getNivel() * 50000);
        experienceLabel.setValue(usuario.getXp());

    }

    private void PlayMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void guardarUsuarioComoJSON(Usuario usuario, String rutaArchivo) {
        Gson gson = new Gson();
        String json = gson.toJson(usuario);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}