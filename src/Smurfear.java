import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Smurfear extends JPanel {
    private JButton closeButton;

    private JButton smurfear;


    public Smurfear(JPanel panelPrincipal,CardLayout cardLayout,Usuario usuario){
        // Configurar la ventana
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(800, 600));

        closeButton = new JButton("X");
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setBackground(Color.MAGENTA.darker());

        smurfear = new JButton("Smurfear");
        smurfear.setBorderPainted(false);
        smurfear.setFocusPainted(false);
        smurfear.setBackground(Color.MAGENTA.darker());



        add(closeButton, BorderLayout.PAGE_END);
        add(smurfear, BorderLayout.PAGE_END);



        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        smurfear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usuario.getNivel()>=6)
                {
                    usuario.setNivel(0);
                    usuario.aumentarBoosteoSmurf();
                    usuario.setXp(0);
                    usuario.setearNivelesRol();
                    usuario.borrarSkins();
                    usuario.setCoins(0);
                    usuario.setTorneosJugados(0);
                    usuario.setPromoGanada(false);
                    System.out.println("Smurfeado");
                }
                else {
                    System.out.println("no esmurfea");
                }
            }
        });


    }

}
