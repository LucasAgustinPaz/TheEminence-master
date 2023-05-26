import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;

public class Minijuego extends JPanel{

    private static final int FRAME_WIDTH = 1920;
    private static final int FRAME_HEIGHT = 1080;
    private static final int OBJECT_SIZE = 50;
    private static final int CLICK_RADIUS = 30;
    private JButton closeButton;

    private int score;
    private int objectX;
    private int objectY;
    private static int vecesEjecutado = 30;
    private Timer timer;
    private boolean minijuegoIniciado = false;


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Minijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        score = 0;


        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1920, 1080));

        closeButton = new JButton("X");
        add(closeButton, BorderLayout.PAGE_END);
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
                resetMinijuego(panelPrincipal,cardLayout, usuario);
            }
        });

        // Agregar MouseListener para detectar clics en el objeto
        addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                checkClick(e.getX(), e.getY());
            }
        });
    }

    public void startMinijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        score=0;
        if (!minijuegoIniciado) {
            minijuegoIniciado = true;
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (vecesEjecutado > 0) {
                        repaint();
                        menos();
                        //System.out.println(vecesEjecutado);
                    } else {
                        resetMinijuego(panelPrincipal,cardLayout,usuario);
                    }
                }
            };

            int delay = 1000; // 1 segundo
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                public void run() {
                    actionListener.actionPerformed(null);
                }
            }, delay, delay);
        }

    }

    private void resetMinijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        int limite = (int)((usuario.getNivel()*10)/3);
        System.out.println(limite);
        if(score<limite) {
            minijuegoIniciado = false;
            vecesEjecutado = 30;
            score = 0;
        }
        else{cardLayout.show(panelPrincipal, "menu");
        usuario.setPromoGanada(true);}
    }


    public void menos(){
        vecesEjecutado--;
    }



    private void generateObjectPosition() {
        objectX = (int) (Math.random() * (FRAME_WIDTH - OBJECT_SIZE));
        objectY = (int) (Math.random() * (FRAME_HEIGHT - OBJECT_SIZE));
    }

    private void checkClick(int x, int y) {
        int centerX = objectX + OBJECT_SIZE / 2;
        int centerY = objectY + OBJECT_SIZE / 2;
        int distance = (int) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));
        int a = 0;

        if (distance <= CLICK_RADIUS) {
            score++;
            generateObjectPosition();
            repaint();
        }else {
<<<<<<< HEAD
            if(score > 0){
            score--;
            }
            generateObjectPosition();
            repaint();
        }
=======
            if(score>0){
            score--;
            }

            generateObjectPosition();
            repaint();
        }

>>>>>>> interfaz-estadisticas
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Dibujar el objeto negro
        g.setColor(Color.BLACK);
        g.fillOval(objectX, objectY, OBJECT_SIZE, OBJECT_SIZE);

        // Dibujar el puntaje
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String scoreText = "Score: " + score;
<<<<<<< HEAD
        String timeText = "Tiempo: " + vecesEjecutado;
=======
>>>>>>> interfaz-estadisticas

        int textWidth = g.getFontMetrics().stringWidth(scoreText);
        int textHeight = g.getFontMetrics().getHeight();
        int textX = 10; // Posición X en la esquina superior izquierda
        int textY = textHeight; // Posición Y en la esquina superior izquierda

        g.drawString(scoreText, textX, textY);
        g.drawString(timeText, textX, textY + textHeight); // Dibujar la variable vecesEjecutado

    }
}
