import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Juego extends JFrame {
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private Minijuego minijuego;
    private Configuracion configuracion;
    private Shop shop;
    private Armario armario;
    private Estadistica estadistica;
    private EleccionDeRol eleccionDeRol;
    private Smurfear smurfear;
    private panelInversiones inveriones;
    private JLabel levelLabel;
    private int estadoMusica;
    private Clip clip;
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

    public Juego(Usuario usuario, JProgressBar experienceLabel) {
        //PlayMusic("resources\\musica\\melodia.wav");
        usuario.setNivel(1);
        ;
        usuario.setXp(0);
        experienceMultiplier = 1.0;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        panelPrincipal = new JPanel();
        cardLayout = new CardLayout();
        panelPrincipal.setLayout(cardLayout);

        JPanel panelMenu = crearPanelMenu(usuario, experienceLabel);
        minijuego = crearPanelMinijuego(panelPrincipal, cardLayout,usuario);
        configuracion = crearPanelConfiguracion(panelPrincipal, cardLayout,estadoMusica);
        shop = crearPanelShop(panelPrincipal, cardLayout,usuario);
        armario = crearPanelArmario(panelPrincipal, cardLayout,usuario);
        estadistica = crearPanelEstadistica(panelPrincipal,cardLayout,usuario);
        eleccionDeRol = crearPanelEleccionesDeRol(panelPrincipal, cardLayout,usuario);
        smurfear = crearPanelSmurfear(panelPrincipal,cardLayout,usuario);
        inveriones = crearPanelInversiones(panelPrincipal, cardLayout, usuario);

        panelPrincipal.add(panelMenu, "menu");
        panelPrincipal.add(minijuego, "minijuego");
        panelPrincipal.add(configuracion, "Configuracion");
        panelPrincipal.add(shop, "Shop");
        panelPrincipal.add(armario, "Armario");
        panelPrincipal.add(estadistica,"Estadistica");
        panelPrincipal.add(eleccionDeRol,"Rol");
        panelPrincipal.add(smurfear,"Smurfear");
        panelPrincipal.add(inveriones,"Inversiones");

        cardLayout.show(panelPrincipal, "menu");

        add(panelPrincipal);
        setVisible(true);
    }

    private Minijuego crearPanelMinijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Minijuego minijuego = new Minijuego(panelPrincipal, cardLayout, usuario);
        return minijuego;
    }

    private Configuracion crearPanelConfiguracion(JPanel panelPrincipal, CardLayout cardLayout,int estadoMusica) {
        Configuracion configuracion = new Configuracion(panelPrincipal, cardLayout,estadoMusica);
        return configuracion;
    }

    private Shop crearPanelShop(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Shop shop = new Shop(panelPrincipal,cardLayout,usuario);
        return shop;
    }

    private Armario crearPanelArmario(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Armario armario = new Armario(panelPrincipal,cardLayout,usuario);
        return armario;
    }

   private Estadistica crearPanelEstadistica(JPanel panelPrincipal,CardLayout cardLayout, Usuario usuario) {
        Estadistica estadistica = new Estadistica(panelPrincipal, cardLayout,usuario);
        return estadistica;
    }

        private EleccionDeRol crearPanelEleccionesDeRol (JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario){
            EleccionDeRol eleccionDeRol = new EleccionDeRol(panelPrincipal, cardLayout, usuario);
            return eleccionDeRol;
        }
        private Smurfear crearPanelSmurfear(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario){
        Smurfear smurfear = new Smurfear(panelPrincipal, cardLayout, usuario);
        return smurfear;
        }
        private panelInversiones crearPanelInversiones(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario){
        panelInversiones inveriones = new panelInversiones(panelPrincipal, cardLayout, usuario);
        return  inveriones;
        }

        private JPanel crearPanelMenu (Usuario usuario, JProgressBar experienceLabel) {
            JPanel panel = new JPanel(new BorderLayout());

            JButton salirButton = new JButton("Salir");
            JButton configuracionButton = new JButton("Configuracion");
            JButton minijuegoButton = new JButton("Minijuego");
            JButton shopButton = new JButton("Shop");
            JButton armarioButton = new JButton("Armario");
            JButton estadisticaButton = new JButton("Estadistica");
            JButton eleccionDeRol = new JButton("Rol");
            JButton smurfear = new JButton("Smurfear");
            JButton inversiones = new JButton("Inversiones");

            levelLabel = new JLabel("Rango: " + cambiarNivel(usuario.getNivel()));
            JButton clickButton = new JButton(suelto);
            JButton closeButton = new JButton(apretado);

            minijuegoButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(panelPrincipal, "minijuego");
                    minijuego.startMinijuego(panelPrincipal, cardLayout, usuario);
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

            estadisticaButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
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
                public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Smurfear");}
            });

            inversiones.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {cardLayout.show(panelPrincipal, "Inversiones");}
            });

            JPanel buttonPanel = new JPanel(); // Panel adicional para los botones
            buttonPanel.setLayout(new FlowLayout()); // Utilizamos FlowLayout para alinear los botones
            buttonPanel.add(minijuegoButton);
            buttonPanel.add(configuracionButton);
            buttonPanel.add(shopButton);
            buttonPanel.add(armarioButton);
            buttonPanel.add(estadisticaButton);
            buttonPanel.add(eleccionDeRol);
            buttonPanel.add(smurfear);
            buttonPanel.add(inversiones);

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
                        gainExperience((int) (10 * experienceMultiplier),usuario,experienceLabel);
                        usuario.sumarClick();
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

        public boolean startTorneo ( int level, Usuario usuario){

            System.out.println("Torneo Iniciado");
           int limite = (int) ((usuario.getNivel() * 10) / 3);
            if (minijuego.getScore() < limite) {
                cardLayout.show(panelPrincipal, "minijuego");
                minijuego.startMinijuego(panelPrincipal, cardLayout, usuario);
            }
            if (minijuego.getScore() >= limite) {
                return true;
            }
            return false;
        }

        public String cambiarNivel ( int level){
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


        private void gainExperience ( int amount, Usuario usuario,JProgressBar experienceLabel){
            usuario.subirXP((amount * (1+usuario.obtenerNivelRango())+usuario.getVecesSmufeado()));
            experienceLabel.setValue(usuario.getXp());

            if(usuario.getTapsCount()< (usuario.obtenerNivelRango())*100){
                usuario.subirNivelRango();
            }

            if (usuario.getNivel() <= 9) {
               // System.out.println("userxp: " + usuario.getXp());
               // System.out.println("userxp: " + usuario.getNivel());

                if (usuario.getXp() >= usuario.getNivel() * 100 && startTorneo(usuario.getNivel(),usuario)){
                    minijuego.setScore(0);
                    usuario.subirNivel();
                    usuario.setPromoGanada(false);
                    experienceMultiplier += 0.6;
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

        }
   /* private void PlayMusic(String filePath) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            estadoMusica=1;
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }

    */
    }




