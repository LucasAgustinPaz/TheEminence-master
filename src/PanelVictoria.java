import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PanelVictoria extends JPanel {
    private JButton closeButton;
    private JButton mostrarVictoria;
    private ImageIcon botonVictoria = new ImageIcon("resources\\sprites\\Assets\\UI\\panel_victoria.png");

    public PanelVictoria(JPanel panelPrincipal, CardLayout cardLayout, Usuario user) {
        // Configurar la ventana
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        mostrarVictoria = new JButton(botonVictoria);
        mostrarVictoria.setBorder(Main.emptyBorder);
        mostrarVictoria.setBackground(Color.BLACK);
        mostrarVictoria.setOpaque(false);
        mostrarVictoria.setContentAreaFilled(false);
        mostrarVictoria.setBorderPainted(false);
        mostrarVictoria.setVisible(true);

        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);

        add(mostrarVictoria);
        buttonsPanel.add(mostrarVictoria);

        gbc.gridy = 1;

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButtonPanel.add(closeButton);

        add(buttonsPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.PAGE_END);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}