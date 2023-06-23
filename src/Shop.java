import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Shop extends JPanel {
    private JButton sigSkin;
    private JButton antSkin;
    private JButton closeButton;
    private JButton currentSkinButton; // Botón adicional para mostrar la skin actual
    private int indiceActual = 0;
    private JLabel jLabelSkin;

    private List<ImageIcon> skins;

    public Shop(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLayout(new BorderLayout());
        setPreferredSize(screenSize);

        skins = new ArrayList<>();
        skins.add(new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_reaver.png"));
        skins.add(new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_prime.png"));
        skins.add(new ImageIcon("resources\\sprites\\Assets\\skins armas\\vandal_origin.png"));

        JDialog dialog = new JDialog();
        dialog.setUndecorated(true); // Remover la barra de título y bordes decorativos
        dialog.getContentPane().setBackground(Color.BLACK);

        closeButton = new JButton(Main.cerrar);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Arial", Font.BOLD, 18));
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        jLabelSkin = new JLabel(skins.get(indiceActual));
        jLabelSkin.setHorizontalAlignment(SwingConstants.CENTER);

        // Configurar la ventana
        dialog.setLayout(new BorderLayout());
        dialog.setPreferredSize(new Dimension(1920, 1080));

        sigSkin = new JButton(new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_adelante.png"));
        sigSkin.setFocusPainted(false);
        sigSkin.setBorderPainted(false);
        sigSkin.setContentAreaFilled(false);

        antSkin = new JButton(new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_atras.png"));
        antSkin.setFocusPainted(false);
        antSkin.setBorderPainted(false);
        antSkin.setContentAreaFilled(false);

        currentSkinButton = new JButton(new ImageIcon("resources\\sprites\\Assets\\UI\\botones HUB\\boton_skins.png"));
        currentSkinButton.setFocusPainted(false);
        currentSkinButton.setBorderPainted(false);
        currentSkinButton.setContentAreaFilled(false);

        currentSkinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (usuario.getCoins() > 2000) {
                    JDialog messageDialog = createMessageDialog(dialog, "Adquirida");
                    messageDialog.setVisible(true);
                    usuario.compra(2000);
                    usuario.getSkins().add(String.valueOf(skins.get(indiceActual)));
                } else {
                    JDialog messageDialog = createMessageDialog(dialog, "No te alcanza la plata");
                    messageDialog.setVisible(true);
                }
            }
        });

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JPanel innerButtonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBackground(Color.BLACK);
        innerButtonPanel.setBackground(Color.BLACK);

        innerButtonPanel.add(antSkin);
        innerButtonPanel.add(currentSkinButton);
        innerButtonPanel.add(sigSkin);

        buttonPanel.add(innerButtonPanel, BorderLayout.CENTER);
        buttonPanel.add(closeButton, BorderLayout.LINE_START);

        dialog.add(buttonPanel, BorderLayout.SOUTH);
        dialog.add(jLabelSkin, BorderLayout.CENTER);

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
                recorrerSiguienteSkin();
            }
        });

        antSkin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recorrerAnteriorSkin();
            }
        });
    }

    private void recorrerSiguienteSkin() {
        if (indiceActual < skins.size() - 1) {
            indiceActual++;
        } else {
            indiceActual = 0; // Volver al principio si alcanza el final de la lista
        }
        jLabelSkin.setIcon(skins.get(indiceActual));
    }

    private void recorrerAnteriorSkin() {
        if (indiceActual > 0) {
            indiceActual--;
        } else {
            indiceActual = skins.size() - 1; // Ir al final de la lista si alcanza el principio
        }
        jLabelSkin.setIcon(skins.get(indiceActual));
    }

    private JDialog createMessageDialog(JDialog parent, String message) {
        JDialog dialog = new JDialog(parent);
        dialog.setUndecorated(true);
        dialog.getContentPane().setBackground(Color.BLACK);
        dialog.setLayout(new BorderLayout());

        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.WHITE);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.add(messageLabel, BorderLayout.CENTER);

        JButton closeButton = new JButton(Main.cerrar);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFont(new Font("Arial", Font.BOLD, 14));
        closeButton.setFocusPainted(false);
        closeButton.setBorderPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setOpaque(false);
        buttonPanel.add(closeButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);

        return dialog;
    }
}
