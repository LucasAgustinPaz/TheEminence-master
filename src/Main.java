import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();

        // Hilo para el juego
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Juego(usuario);
            }
        });

        // Hilo xp
        Thread hiloXp = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    usuario.subirXP(1 * (usuario.getVecesSmufeado()));
                    System.out.println(usuario.getXp());

                    try {
                        Thread.sleep(1000); // Esperar 1 segundo
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        hiloXp.start();

    }
}