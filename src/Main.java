import com.google.gson.Gson;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static final ImageIcon cerrar = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_salir.png");
    public static final ImageIcon Default = new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_default.png");
    public static final ImageIcon origin = new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_origin.png");
    public static final ImageIcon prime = new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_prime.png");
    public static final ImageIcon reaven = new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_origin.png");

    // Eliminar el borde del botón
    public static final Border emptyBorder = BorderFactory.createEmptyBorder();
    // Eliminar el fondo del botón
    public static final Color transparentColor = new Color(0, 0, 0, 0);
    public static void main(String[] args) {
        Usuario usuario = leerArchivoComoObjeto("resources\\usuario.json");
        JProgressBar experienceLabel =new JProgressBar();


        // Sobrescribir la apariencia de la JProgressBar
        experienceLabel.setUI(new BasicProgressBarUI() {
            @Override
            protected void paintDeterminate(Graphics g, JComponent c) {
                Graphics2D g2d = (Graphics2D) g;
                int barWidth = experienceLabel.getWidth();
                int barHeight = experienceLabel.getHeight();

                // Definir el color de fondo
                g2d.setColor(Color.black); // Cambiar el color aquí

                // Dibujar el fondo
                g2d.fillRect(0, 0, barWidth, barHeight);

                // Definir el color de progreso
                g2d.setColor(Color.MAGENTA.darker()); // Cambiar el color aquí
                int progressWidth = (int) (barWidth * progressBar.getPercentComplete());
                g2d.fillRect(0, 0, progressWidth, barHeight);

            }
        });


        // Hilo para el juego
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Juego(usuario,experienceLabel);
            }
        });



        // Hilo xp
        Thread hiloXpAndCoins = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    usuario.subirXP((usuario.sumarBoost()*10) + (usuario.getVecesSmufeado()) + (usuario.eloboostMayor().getNivel()*10));
                    usuario.gananciaInversiones();
                    System.out.println("coins: "+usuario.getCoins());
                    System.out.println("userxp: " + usuario.getXp());
                    experienceLabel.setValue(usuario.getXp());

                    try {
                        Thread.sleep(1000); // Esperar 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        hiloXpAndCoins.start();
    }

    public static Usuario leerArchivoComoObjeto(String rutaArchivo) {
        Gson gson = new Gson();
        File archivo = new File(rutaArchivo);

        if (!archivo.exists()) {
            Usuario nuevoUsuario = new Usuario();
            guardarObjetoComoJSON(nuevoUsuario, rutaArchivo);
            return nuevoUsuario;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String json = reader.readLine();
            return gson.fromJson(json, Usuario.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void guardarObjetoComoJSON(Object objeto, String rutaArchivo) {
        Gson gson = new Gson();
        String json = gson.toJson(objeto);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}