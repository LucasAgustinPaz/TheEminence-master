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


    public Configuracion(JPanel panelPrincipal, CardLayout cardLayout,int estadoMusica){

        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        ImageIcon play = new ImageIcon("resources\\sprites\\startMusic.png");
        ImageIcon stop = new ImageIcon("resources\\sprites\\stopMusic.png");

        PlayMusic= new JButton(play);
        StopMusic = new JButton(stop);

        PlayMusic.setBorderPainted(false); // Eliminar el bordePlayMusic.setContentAreaFilled(false); // Eliminar el fondoPlayMusic.setFocusPainted(false); // Eliminar el resaltado de enfoquePlayMusic.setOpaque(false); // Hacer el botón transparente
        PlayMusic.setContentAreaFilled(false); // Eliminar el fondo
        PlayMusic.setFocusPainted(false); // Eliminar el resaltado de enfoque
        PlayMusic.setOpaque(false); // Hacer el botón transparente

        StopMusic.setBorderPainted(false); // Eliminar el borde
        StopMusic.setContentAreaFilled(false); // Eliminar el fondo
        StopMusic.setFocusPainted(false); // Eliminar el resaltado de enfoque
        StopMusic.setOpaque(false); // Hacer el botón transparente

        add(PlayMusic, BorderLayout.NORTH);
        add(StopMusic, BorderLayout.SOUTH);
        add(closeButton, BorderLayout.PAGE_END);


        PlayMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(estadoMusica==0) {
                    //PlayMusic("resources\\musica\\melodia.wav",estadoMusica);

                }

            }
        });

        StopMusic.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(estadoMusica==1) {
                  //  StopMusic(estadoMusica);
                }
            }
        });
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });



    }

/*
    private void PlayMusic(String filePath,int estadoMusica) {
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

    public void StopMusic(int estadoMusica) {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

 */

}
