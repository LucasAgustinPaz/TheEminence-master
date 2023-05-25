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
    private List<String> skins;
    private int indiceActual;
    JLabel printSkin;
    private JLabel jLabelSkin;

    public Armario(JPanel panelPrincipal, CardLayout cardLayout) {
        skins = new ArrayList<String>();
        skins.add("Skin 1");
        skins.add("Skin 2");
        skins.add("Skin 3");
        indiceActual = 0;

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        jLabelSkin = new JLabel(skins.get(indiceActual));

        // Configurar la ventana
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));

        sigSkin = new JButton("Siguiente");
        sigSkin.setBorderPainted(false);
        sigSkin.setFocusPainted(false);
        sigSkin.setBackground(Color.blue);

        antSkin = new JButton("Anterior");
        antSkin.setBorderPainted(false);
        antSkin.setFocusPainted(false);
        antSkin.setBackground(Color.blue);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(antSkin);
        buttonPanel.add(sigSkin);
        buttonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.NORTH);
        add(jLabelSkin, BorderLayout.WEST);

        sigSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerSiguienteSkin();
            }
        });

        antSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerAnteriorSkin();
            }
        });

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });
    }

    private void recorrerSiguienteSkin() {
        if (indiceActual < skins.size() - 1) {
            indiceActual++;
        } else {
            indiceActual = 0; // Volver al principio si alcanza el final de la lista
        }
        jLabelSkin.setText(skins.get(indiceActual));
    }

    private void recorrerAnteriorSkin() {
        if (indiceActual > 0) {
            indiceActual--;
        } else {
            indiceActual = skins.size() - 1; // Ir al final de la lista si alcanza el principio
        }
        jLabelSkin.setText(skins.get(indiceActual));
    }
}
