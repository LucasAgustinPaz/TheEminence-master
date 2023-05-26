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
    private Clip clip;

    public Configuracion(JPanel panelPrincipal, CardLayout cardLayout, int estadoMusica) {
        // Configurar la ventana
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1920, 1080));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        ImageIcon play = new ImageIcon("resources\\sprites\\startMusic.png");
        ImageIcon stop = new ImageIcon("resources\\sprites\\stopMusic.png");

        PlayMusic = new JButton(play);
        StopMusic = new JButton(stop);

        PlayMusic.setBorderPainted(false);
        PlayMusic.setContentAreaFilled(false);
        PlayMusic.setFocusPainted(false);
        PlayMusic.setOpaque(false);

        StopMusic.setBorderPainted(false);
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
                if (estadoMusica == 0) {
                    PlayMusic("resources\\musica\\melodia.wav",estadoMusica);
                }
            }
        });

        StopMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (estadoMusica == 1) {
                    StopMusic(estadoMusica);
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });
    }


    private void PlayMusic(String filePath,int estadoMusica) {
        try {
            File audioFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            estadoMusica = 1;
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void StopMusic(int estadoMusica) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            estadoMusica=0;
        }
    }

}
