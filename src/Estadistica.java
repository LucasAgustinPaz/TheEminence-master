import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Estadistica extends JPanel {
    private JButton closeButton;
    private JLabel clicks;
    private JLabel gainCoins;
    private JLabel tournamentsPlayed;
    private JLabel horasJugadas;

    public Estadistica(JPanel panelPrincipal, CardLayout cardLayout, Usuario user) {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);
        closeButtonPanel.add(closeButton);

        add(closeButtonPanel, BorderLayout.PAGE_END);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        JPanel statisticsPanel = new JPanel();
        statisticsPanel.setLayout(new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS));

        int verticalSpacing = 50; // Ajusta el espacio vertical entre los JLabels

        Font chelseaFont = new Font("Arial", Font.BOLD, 16); // Crea la instancia de la fuente Chelsea Market

        clicks = new JLabel("Clicks totales:");
        clicks.setFont(chelseaFont); // Establece la fuente Chelsea Market en el JLabel
        clicks.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        statisticsPanel.add(clicks);

        gainCoins = new JLabel("Monedas Ganadas:");
        gainCoins.setFont(chelseaFont); // Establece la fuente Chelsea Market en el JLabel
        gainCoins.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        statisticsPanel.add(gainCoins);

        tournamentsPlayed = new JLabel("Torneos Jugados:");
        tournamentsPlayed.setFont(chelseaFont); // Establece la fuente Chelsea Market en el JLabel
        tournamentsPlayed.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        statisticsPanel.add(tournamentsPlayed);

        horasJugadas = new JLabel("Horas Jugadas:");
        horasJugadas.setFont(chelseaFont); // Establece la fuente Chelsea Market en el JLabel
        horasJugadas.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        statisticsPanel.add(horasJugadas);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.add(statisticsPanel);

        add(centerPanel, BorderLayout.CENTER);
    }

    public void actualizarEstadisticas(Usuario usuario) {
        clicks.setText("Clicks totales: " + usuario.getTapsCount());
        gainCoins.setText("Monedas Ganadas: " + usuario.getCoins());
        tournamentsPlayed.setText("Torneos Jugados: " + usuario.getTorneosJugados());
        horasJugadas.setText("Minutos Jugados: " + usuario.sumarMinutos());
    }
}
