import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tienda extends JPanel {
    private JButton closeButton;
    private JButton skin;
    private JButton boost;

    public Tienda(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar la ventana
        setLayout(new BorderLayout());

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        skin = new JButton("skin");
        skin.setBorder(Main.emptyBorder);
        skin.setBackground(Main.transparentColor);
        skin.setOpaque(false);
        skin.setContentAreaFilled(false);
        skin.setBorderPainted(false);

        boost = new JButton("boost");
        boost.setBorder(Main.emptyBorder);
        boost.setBackground(Main.transparentColor);
        boost.setOpaque(false);
        boost.setContentAreaFilled(false);
        boost.setBorderPainted(false);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 10, 0);
        buttonPanel.add(skin, gbc);

        gbc.gridy = 1;
        buttonPanel.add(boost, gbc);

        JPanel closeButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closeButtonPanel.setBackground(Color.BLACK);
        closeButtonPanel.add(closeButton);

        add(buttonPanel, BorderLayout.CENTER);
        add(closeButtonPanel, BorderLayout.PAGE_END);

        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        skin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Shop");
            }
        });

        boost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "Boost");
            }
        });
    }
}
