import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        JProgressBar experienceLabel =new JProgressBar();

        // Hilo para el juego
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Juego(usuario,experienceLabel);
            }
        });

        // Hilo xp
        Thread hiloXp = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    usuario.subirXP((usuario.getVecesSmufeado()));
                   // System.out.println(usuario.getXp());
                    experienceLabel.setValue(usuario.getXp());

                    try {
                        Thread.sleep(1000); // Esperar 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        hiloXp.start();

        // Hilo de coins pasivas
        Thread hiloInversiones = new Thread(new Runnable() {
            public void run() {
                while (true) {
                        usuario.gananciaInversiones();
                        System.out.println(usuario.getCoins());

                    try {
                        Thread.sleep(2000); // Esperar 2 segundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        hiloInversiones.start();

    }
}