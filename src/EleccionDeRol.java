import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EleccionDeRol extends JPanel {
    private JButton closeButton;
    private JButton duelistaButton;
    private JButton centinelaButton;
    private JButton controladorButton;
    private JButton iniciadorButton;

    private ImageIcon duelistaIcon = new ImageIcon("resources\\sprites\\Assets\\roles baldu\\rol_duelista.png");
    private ImageIcon centinelaIcon = new ImageIcon("resources\\sprites\\Assets\\roles baldu\\rol_centinela.png");
    private ImageIcon controladorIcon = new ImageIcon("resources\\sprites\\Assets\\roles baldu\\rol_controlador.png");
    private ImageIcon iniciadorIcon = new ImageIcon("resources\\sprites\\Assets\\roles baldu\\rol_iniciador.png");

    public EleccionDeRol(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar el panel principal
        setLayout(new BorderLayout());

        // Panel para los botones
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 0)); // 1 fila, 4 columnas
        buttonPanel.setBackground(Color.BLACK); // Establecer color de fondo

        duelistaButton = new JButton(duelistaIcon);
        duelistaButton.setBorder(Main.emptyBorder);
        duelistaButton.setBackground(Main.transparentColor);
        duelistaButton.setOpaque(false);
        duelistaButton.setContentAreaFilled(false);
        duelistaButton.setBorderPainted(false);

        centinelaButton = new JButton(centinelaIcon);
        centinelaButton.setBorder(Main.emptyBorder);
        centinelaButton.setBackground(Main.transparentColor);
        centinelaButton.setOpaque(false);
        centinelaButton.setContentAreaFilled(false);
        centinelaButton.setBorderPainted(false);

        controladorButton = new JButton(controladorIcon);
        controladorButton.setBorder(Main.emptyBorder);
        controladorButton.setBackground(Main.transparentColor);
        controladorButton.setOpaque(false);
        controladorButton.setContentAreaFilled(false);
        controladorButton.setBorderPainted(false);

        iniciadorButton = new JButton(iniciadorIcon);
        iniciadorButton.setBorder(Main.emptyBorder);
        iniciadorButton.setBackground(Main.transparentColor);
        iniciadorButton.setOpaque(false);
        iniciadorButton.setContentAreaFilled(false);
        iniciadorButton.setBorderPainted(false);


        buttonPanel.add(duelistaButton);
        buttonPanel.add(centinelaButton);
        buttonPanel.add(controladorButton);
        buttonPanel.add(iniciadorButton);

        // Alinear el botón "X" a la izquierda y abajo
        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButtonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.SOUTH);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        duelistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.DUELISTA));
                System.out.println(usuario.getRol());
            }
        });

        centinelaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.CENTINELA));
                System.out.println(usuario.getRol());
            }
        });

        controladorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.SMOKER));
                System.out.println(usuario.getRol());
            }
        });

        iniciadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setRol(String.valueOf(Roles.INICIADOR));
                System.out.println(usuario.getRol());
            }
        });
    }
}
