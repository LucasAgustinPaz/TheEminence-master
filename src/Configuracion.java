import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Configuracion extends JPanel {
    private JButton closeButton;
    private JButton PlayMusic;
    private JButton StopMusic;
    private int estadoMusicaEnClase;
    //private Clip clip;

    public Configuracion(JPanel panelPrincipal, CardLayout cardLayout, int estadoMusica, Clip clip) {
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());
        estadoMusicaEnClase = estadoMusica;

        ImageIcon play = new ImageIcon("resources\\sprites\\startMusic.png");
        ImageIcon stop = new ImageIcon("resources\\sprites\\stopMusic.png");

        PlayMusic = new JButton(play);
        StopMusic = new JButton(stop);

        PlayMusic.setBorderPainted(true);
        PlayMusic.setContentAreaFilled(false);
        PlayMusic.setFocusPainted(false);
        PlayMusic.setOpaque(false);

        StopMusic.setBorderPainted(true); // cambiar esto antes de todo porque esta para testear
        StopMusic.setContentAreaFilled(false);
        StopMusic.setFocusPainted(false);
        StopMusic.setOpaque(false);

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1));
        buttonsPanel.add(PlayMusic);
        buttonsPanel.add(StopMusic);

        JPanel closeButtonPanel = new JPanel(new BorderLayout());
        closeButtonPanel.add(closeButton, BorderLayout.SOUTH);

        add(buttonsPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.WEST);

        PlayMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Estado " + estadoMusicaEnClase);
                if (estadoMusicaEnClase == 0) {
                    PlayMusic("resources\\musica\\melodia.wav", clip);
                    estadoMusicaEnClase = 1;
                }
            }
        });

        StopMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (estadoMusicaEnClase == 1) {
                    System.out.println("stoop nashe");
                    StopMusic(clip);
                    estadoMusicaEnClase = 0;
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });
    }


    private void PlayMusic(String filePath, Clip clip) {
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

    public void StopMusic(Clip clip) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}
