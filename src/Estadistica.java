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

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        JPanel closeButtonPanel = new JPanel(new BorderLayout());
        closeButtonPanel.add(closeButton, BorderLayout.SOUTH);

        add(closeButtonPanel, BorderLayout.WEST);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        JPanel statisticsPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(statisticsPanel, BoxLayout.Y_AXIS);
        statisticsPanel.setLayout(boxLayout);

        int verticalSpacing = 10; // Ajusta el espacio vertical entre los JLabels
        clicks = new JLabel("Clicks totales: " + user.getTapsCount());
        clicks.setBorder(new EmptyBorder(0, 20, verticalSpacing, 0));
        statisticsPanel.add(clicks);

        gainCoins = new JLabel("Monedas Ganadas: " + user.getCoins());
        gainCoins.setBorder(new EmptyBorder(0, 20, verticalSpacing, 0));
        statisticsPanel.add(gainCoins);

        tournamentsPlayed = new JLabel("Torneos Jugados: " + user.getTorneosJugados());
        tournamentsPlayed.setBorder(new EmptyBorder(0, 20, verticalSpacing, 0));
        statisticsPanel.add(tournamentsPlayed);

        horasJugadas = new JLabel("Horas Jugadas: " + user.getHorasJugadas());
        horasJugadas.setBorder(new EmptyBorder(0, 20, verticalSpacing, 0));
        statisticsPanel.add(horasJugadas);

        add(statisticsPanel, BorderLayout.CENTER);
    }
}
