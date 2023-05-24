import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Armario extends JPanel {
    private JButton sigSkin;
    private JButton antSkin;



    private List<String> skins;
    private int indiceActual;
    private JLabel jLabelSkin;

    public Armario(JPanel panelPrincipal, CardLayout cardLayout) {
        skins = new ArrayList<>();
        skins.add("Skin 1");
        skins.add("Skin 2");
        skins.add("Skin 3");
        indiceActual = 0;

        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        sigSkin = new JButton("Siguiente");
        sigSkin.setBorderPainted(false);
        sigSkin.setFocusPainted(false);
        sigSkin.setBackground(Color.blue.darker());

        antSkin = new JButton("Anterio");
        antSkin.setBorderPainted(false);
        antSkin.setFocusPainted(false);
        antSkin.setBackground(Color.blue.darker());

        add(sigSkin,BorderLayout.NORTH);
        add(antSkin,BorderLayout.NORTH);

        sigSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {recorrerSiguienteSkin();}
        });

        antSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {recorrerAnteriorSkin();}
        });

    }

    private void recorrerSiguienteSkin() {
        if (indiceActual < skins.size() - 1) {
            indiceActual++;
            jLabelSkin.setText(skins.get(indiceActual));
        }
    }

    private void recorrerAnteriorSkin() {
        if (indiceActual > 0) {
            indiceActual--;
            jLabelSkin.setText(skins.get(indiceActual));
        }
    }

}

