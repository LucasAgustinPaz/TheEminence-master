import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;

public class Minijuego extends JPanel {

    private static final int OBJECT_SIZE = 50;
    private static final int CLICK_RADIUS = 30;
    private JButton closeButton;
    private JLabel victoria;

    private int score;
    private int objectX;
    private int objectY;
    private static int vecesEjecutado = 30;
    private Timer timer;
    private boolean minijuegoIniciado = false;
    private boolean isTimerRunning = false;
    private boolean ganada = false;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Minijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        score = 0;

        // Configurar la ventana
        adaptarVentana();

        setLayout(new FlowLayout());

        closeButton = new JButton("X");
        add(closeButton);
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        victoria = new JLabel("Victoria");
        add(victoria);
        victoria.setVisible(false);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!ganada) {
                    usuario.setPromoGanada(true);
                }
                usuario.agregarCoins(score);
                victoria.setVisible(false);
                cardLayout.show(panelPrincipal, "menu");
                // resetMinijuego(panelPrincipal,cardLayout, usuario);
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
        adaptarVentana();
        resetMinijuego(panelPrincipal, cardLayout, usuario);
        if (!minijuegoIniciado) {
            score = 0;
            minijuegoIniciado = true;
            usuario.sumarTorneos();
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    if (vecesEjecutado > 0) {
                        repaint();
                        menos();
                        //System.out.println(vecesEjecutado);
                    } else {
                        resetMinijuego(panelPrincipal, cardLayout, usuario);
                    }
                }
            };
            if (!isTimerRunning) {
                int delay = 1000; // 1 segundo
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(new TimerTask() {
                    public void run() {
                        actionListener.actionPerformed(null);
                    }
                }, delay, delay);

                isTimerRunning = true;
            }
        }
    }

    private void resetMinijuego(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        int limite = (int) ((usuario.getNivel() * 10) / 3);
        System.out.println(limite);

        if (score < limite) {
            minijuegoIniciado = false;
            vecesEjecutado = 30;
            score = 0;
        } else {
            minijuegoIniciado = true;
            victoria.setVisible(true);
            ganada = true;
        }
    }

    public void menos() {
        vecesEjecutado--;
    }

    private void adaptarVentana() {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        if (gd.isFullScreenSupported()) {
            gd.setFullScreenWindow(SwingUtilities.getWindowAncestor(this));
        }
    }

    private void generateObjectPosition() {
        objectX = (int) (Math.random() * (getWidth() - OBJECT_SIZE));
        objectY = (int) (Math.random() * (getHeight() - OBJECT_SIZE));
    }

    private void checkClick(int x, int y) {
        int centerX = objectX + OBJECT_SIZE / 2;
        int centerY = objectY + OBJECT_SIZE / 2;
        int distance = (int) Math.sqrt(Math.pow(x - centerX, 2) + Math.pow(y - centerY, 2));

        if (distance <= CLICK_RADIUS) {
            score++;
            generateObjectPosition();
            repaint();
        } else {
            if (score > 0) {
                score--;
            }
            generateObjectPosition();
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar el objeto negro
        g.setColor(Color.BLACK);
        g.fillOval(objectX, objectY, OBJECT_SIZE, OBJECT_SIZE);

        // Dibujar el puntaje
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        String scoreText = "Score: " + score;
        String timeText = "Tiempo: " + vecesEjecutado;

        int textWidth = g.getFontMetrics().stringWidth(scoreText);
        int textHeight = g.getFontMetrics().getHeight();
        int textX = 10; // Posición X en la esquina superior izquierda
        int textY = textHeight; // Posición Y en la esquina superior izquierda

        g.drawString(scoreText, textX, textY);
        g.drawString(timeText, textX, textY + textHeight); // Dibujar la variable vecesEjecutado
    }
}
