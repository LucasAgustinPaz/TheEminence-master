import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

class Gameplay extends JPanel {
    private int level;
    private int experience;
    private JLabel levelLabel;
    private JProgressBar experienceLabel;
    private JButton clickButton;
    private JButton closeButton;
    private JLabel spriteLabel;
    private double experienceMultiplier;
    private boolean isButtonPressed = false;
    private JButton botonMinijuego;
    private Clip clip;
    private ImageIcon suelto = new ImageIcon("C:\\Datos\\programacion\\proyecto final\\TheEminence2-master\\resources\\sprites\\button1.png");
    private ImageIcon apretado = new ImageIcon("C:\\Datos\\programacion\\proyecto final\\TheEminence2-master\\resources\\sprites\\button2.png");

    public Gameplay() {
        level = 1;
        experience = 0;
        experienceMultiplier = 1.0;

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        configurarComponentes();

        addComponents();

        verificacionesMouse();
    }

    public void addComponents() {
        add(levelLabel, BorderLayout.WEST);
        add(experienceLabel, BorderLayout.CENTER);
        add(clickButton, BorderLayout.EAST);
        add(closeButton, BorderLayout.PAGE_END);
        add(botonMinijuego);
    }

    public void verificacionesMouse() {
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Juego juego = (Juego) SwingUtilities.getWindowAncestor(Gameplay.this);
                juego.getContentPane().remove(Gameplay.this);
                juego.getCardLayout().show(juego.getPanelPrincipal(), "menu");
            }
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
    }

    public void configurarComponentes() {
        levelLabel = new JLabel("Rango: " + cambiarNivel(level));
        experienceLabel = new JProgressBar();
        botonMinijuego = new JButton("minijuego");

        botonMinijuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Juego juego = (Juego) SwingUtilities.getWindowAncestor(Gameplay.this);
                juego.getCardLayout().show(juego.getPanelPrincipal(), "minijuego");
            }
        });

        experienceLabel.setMinimum(0);
        experienceLabel.setMaximum(level * 100);
        experienceLabel.setValue(experience);

        spriteLabel = new JLabel();

        spriteLabel.setIcon(suelto);

        clickButton = new JButton(suelto);

        clickButton.setBorderPainted(false); // Eliminar el borde
        clickButton.setContentAreaFilled(false); // Eliminar el fondo
        clickButton.setFocusPainted(false); // Eliminar el resaltado de enfoque
        clickButton.setOpaque(false); // Hacer el botón transparente

        closeButton = new JButton("X");

        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

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

}