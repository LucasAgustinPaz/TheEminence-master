import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        String objetoString = usuario.toString();
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

    public void cargar(String objetoString){
        try {
            FileWriter archivo = new FileWriter("archivo.txt");
            BufferedWriter escritor = new BufferedWriter(archivo);
            // Escribir la cadena en el archivo
            escritor.write(objetoString);
            // Cerrar el BufferedWriter
            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}