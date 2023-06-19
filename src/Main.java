import com.google.gson.Gson;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = leerArchivoComoObjeto("D:\\Facultad\\Programacion 3\\Proyecto final\\resources\\usuario.json");
        JProgressBar experienceLabel =new JProgressBar();


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
                    usuario.subirXP((usuario.sumarBoost()) + (usuario.getVecesSmufeado()));
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