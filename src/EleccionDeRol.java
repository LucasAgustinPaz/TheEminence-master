import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EleccionDeRol extends JPanel {
    private JButton closeButton;
    private JButton Duelista;
    private JButton Centinela;
    private JButton Smoker;
    private JButton Iniciador;

    public EleccionDeRol(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar el panel principal
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.insets = new Insets(10, 10, 10, 10);

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        Duelista = new JButton("Duelista");
        Centinela = new JButton("Centinela");
        Smoker = new JButton("Smoker");
        Iniciador = new JButton("Iniciador");

        buttonPanel.add(Duelista, gbc);
        buttonPanel.add(Centinela, gbc);
        buttonPanel.add(Smoker, gbc);
        buttonPanel.add(Iniciador, gbc);

        // Alinear el botón "X" a la izquierda y abajo
        add(closeButton, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.CENTER);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        Duelista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.DUELISTA));
                System.out.println(usuario.getRol());
            }
        });

        Centinela.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.CENTINELA));
                System.out.println(usuario.getRol());
            }
        });

        Smoker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.SMOKER));
                System.out.println(usuario.getRol());
            }
        });

        Iniciador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.INICIADOR));
                System.out.println(usuario.getRol());
            }
        });
    }
}
