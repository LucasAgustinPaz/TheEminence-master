import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Armario extends JPanel {
    private JButton sigSkin;
    private JButton antSkin;
    private JButton closeButton;
    private int indiceActual;
    private JLabel jLabelSkin;

    ImageIcon atras = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_atras.png");
    ImageIcon adelante = new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_adelante.png");

    public Armario(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        indiceActual = 0;

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        jLabelSkin = new JLabel(usuario.getSkins().get(indiceActual));
        jLabelSkin.setHorizontalAlignment(SwingConstants.CENTER);

        // Configurar la ventana
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(1920, 1080));

        sigSkin = new JButton(adelante);
        sigSkin.setBorder(Main.emptyBorder);
        sigSkin.setBackground(Main.transparentColor);
        sigSkin.setOpaque(false);
        sigSkin.setContentAreaFilled(false);
        sigSkin.setBorderPainted(false);

        antSkin = new JButton(atras);
        antSkin.setBorder(Main.emptyBorder);
        antSkin.setBackground(Main.transparentColor);
        antSkin.setOpaque(false);
        antSkin.setContentAreaFilled(false);
        antSkin.setBorderPainted(false);

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JPanel innerButtonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.BLACK);
        innerButtonPanel.setBackground(Color.BLACK);

        innerButtonPanel.add(antSkin);
        innerButtonPanel.add(sigSkin);

        buttonPanel.add(innerButtonPanel, BorderLayout.CENTER);
        buttonPanel.add(closeButton, BorderLayout.LINE_START);

        add(buttonPanel, BorderLayout.SOUTH);
        add(jLabelSkin, BorderLayout.CENTER);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        sigSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerSiguienteSkin(usuario);
            }
        });

        antSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerAnteriorSkin(usuario);
            }
        });
    }

    private void recorrerSiguienteSkin(Usuario usuario) {
        if (indiceActual < usuario.getSkins().size() - 1) {
            indiceActual++;
        } else {
            indiceActual = 0; // Volver al principio si alcanza el final de la lista
        }
        jLabelSkin.setIcon(new ImageIcon(usuario.getSkins().get(indiceActual)));
    }

    private void recorrerAnteriorSkin(Usuario usuario) {
        if (indiceActual > 0) {
            indiceActual--;
        } else {
            indiceActual = usuario.getSkins().size() - 1; // Ir al final de la lista si alcanza el principio
        }
        jLabelSkin.setIcon(new ImageIcon(usuario.getSkins().get(indiceActual)));
    }
}
