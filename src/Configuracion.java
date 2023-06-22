import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Configuracion extends JPanel {
    private JButton closeButton;
    private JButton playMusic;
    private JButton stopMusic;
    private int estadoMusicaEnClase;
    private Clip clip;

    public Configuracion(JPanel panelPrincipal, CardLayout cardLayout, int estadoMusica, Clip clip) {
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        estadoMusicaEnClase = estadoMusica;
        this.clip = clip;

        ImageIcon play = new ImageIcon("resources\\sprites\\startMusic.png");
        ImageIcon stop = new ImageIcon("resources\\sprites\\stopMusic.png");

        playMusic = new JButton(play);
        playMusic.setBorder(Main.emptyBorder);
        playMusic.setBackground(Main.transparentColor);
        playMusic.setOpaque(false);
        playMusic.setContentAreaFilled(false);
        playMusic.setBorderPainted(false);

        stopMusic = new JButton(stop);
        stopMusic.setBorder(Main.emptyBorder);
        stopMusic.setBackground(Main.transparentColor);
        stopMusic.setOpaque(false);
        stopMusic.setContentAreaFilled(false);
        stopMusic.setBorderPainted(false);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        buttonsPanel.add(playMusic, gbc);

        gbc.gridy = 1;
        buttonsPanel.add(stopMusic, gbc);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButtonPanel.add(closeButton);

        add(buttonsPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.PAGE_END);

        playMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (estadoMusicaEnClase == 0) {
                    System.out.println("ESTADO 0 ENTRA PLAY");
                    estadoMusicaEnClase = 1;
                    playMusic("resources\\musica\\melodia.wav");
                }
            }
        });

        stopMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (estadoMusicaEnClase == 1) {
                    System.out.println("ESTADO 1 ENTRA STOP");
                    estadoMusicaEnClase = 0;
                    stopMusic();
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });
    }

    private void playMusic(String filePath) {
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

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
}