import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.io.File;

public class Estadistica extends JPanel {
    private JButton closeButton;
    private JLabel clicks;
    private JLabel gainCoins;
    private JLabel tournamentsPlayed;
    private JLabel horasJugadas;

    public Estadistica(JPanel panelPrincipal, CardLayout cardLayout, Usuario user) {
        setLayout(new BorderLayout());

        // Cargar la imagen de fondo desde una ruta específica
        ImageIcon backgroundImage = new ImageIcon("resources\\sprites\\Assets\\UI\\fondo_blur.png");

        // Crear un JLabel con el ImageIcon como fondo
        JLabel backgroundLabel = new JLabel(backgroundImage) {
            @Override
            public Dimension getPreferredSize() {
                Container parent = getParent();
                if (parent != null) {
                    return parent.getSize(); // Hacer que la imagen de fondo ocupe el espacio del contenedor principal
                }
                return super.getPreferredSize();
            }
        };
        backgroundLabel.setLayout(new BorderLayout());
        add(backgroundLabel, BorderLayout.CENTER);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
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

        Font customFont = null;
        try {
            // Carga la fuente personalizada desde el archivo .ttf
            customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources\\sprites\\Assets\\BebasNeue-Regular.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            // Registra la fuente personalizada en el entorno gráfico
            ge.registerFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Font chelseaFont = customFont.deriveFont(Font.BOLD, 16); // Deriva la fuente con el estilo y tamaño deseados

        clicks = new JLabel("Clicks totales:");
        clicks.setFont(chelseaFont); // Establece la fuente personalizada en el JLabel
        clicks.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        clicks.setForeground(Color.WHITE); // Establece la tipografía en blanco
        statisticsPanel.add(clicks);

        gainCoins = new JLabel("Monedas Ganadas:");
        gainCoins.setFont(chelseaFont); // Establece la fuente personalizada en el JLabel
        gainCoins.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        gainCoins.setForeground(Color.WHITE); // Establece la tipografía en blanco
        statisticsPanel.add(gainCoins);

        tournamentsPlayed = new JLabel("Torneos Jugados:");
        tournamentsPlayed.setFont(chelseaFont); // Establece la fuente personalizada en el JLabel
        tournamentsPlayed.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        tournamentsPlayed.setForeground(Color.WHITE); // Establece la tipografía en blanco
        statisticsPanel.add(tournamentsPlayed);

        horasJugadas = new JLabel("Horas Jugadas:");
        horasJugadas.setFont(chelseaFont); // Establece la fuente personalizada en el JLabel
        horasJugadas.setBorder(new EmptyBorder(verticalSpacing, 0, 0, 0));
        horasJugadas.setForeground(Color.WHITE); // Establece la tipografía en blanco
        statisticsPanel.add(horasJugadas);

        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false); // Hacer que el panel sea transparente
        centerPanel.add(statisticsPanel);

        // Establecer el fondo transparente para el panel de estadísticas
        statisticsPanel.setOpaque(false);
        // Hacer que los componentes del panel de estadísticas sean transparentes
        setComponentsTransparent(statisticsPanel);

        backgroundLabel.add(centerPanel); // Agregar el centroPanel al backgroundLabel

        setOpaque(false); // Hacer que el panel principal también sea transparente
    }

    public void actualizarEstadisticas(Usuario usuario) {
        clicks.setText("Clicks totales: " + usuario.getTapsCount());
        gainCoins.setText("Monedas Ganadas: " + usuario.getCoins());
        tournamentsPlayed.setText("Torneos Jugados: " + usuario.getTorneosJugados());
        horasJugadas.setText("Minutos Jugados: " + usuario.sumarMinutos());
    }

    private void setComponentsTransparent(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JComponent) {
                ((JComponent) component).setOpaque(false);
                if (component instanceof Container) {
                    setComponentsTransparent((Container) component);
                }
            }
        }
    }
}
