import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelBoost extends JPanel {
    private JButton closeButton;
    private JButton Mouse;
    private JButton Teclado;
    private JButton Auriculares;
    private JButton RGB;
    private JButton MousePad;
    private JButton Coach1;
    private JButton Coach2;
    private JButton Coach3;
    private JButton Coach4;
    private JButton Coach5;
    private JButton eloBoost1;
    private JButton eloBoost2;
    private JButton eloBoost3;
    private JButton eloBoost4;
    private JButton eloBoost5;

    ImageIcon auriculares = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_auriculares.png");
    ImageIcon led = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_led.png");
    ImageIcon mouse = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_mouse.png");
    ImageIcon mousepad = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_mousepad.png");
    ImageIcon teclado = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_teclado.png");
    ImageIcon coach_1 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_1.png");
    ImageIcon coach_2 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_2.png");
    ImageIcon coach_3 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_3.png");
    ImageIcon coach_4 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_4.png");
    ImageIcon coach_5 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_coach_5.png");
    ImageIcon eloboost_1 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_1.png");
    ImageIcon eloboost_2 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_2.png");
    ImageIcon eloboost_3 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_3.png");
    ImageIcon eloboost_4 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_4.png");
    ImageIcon eloboost_5 = new ImageIcon("resources\\sprites\\Assets\\UI\\botones SHOP\\btn_eloboost_5.png");

    public PanelBoost(JPanel panelPrincipal, CardLayout cardLayout, Usuario usuario) {
        // Configurar la ventana
        setLayout(new BorderLayout());

        closeButton = new JButton(Main.cerrar);
        closeButton.setBorder(Main.emptyBorder);
        closeButton.setBackground(Main.transparentColor);
        closeButton.setOpaque(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setBorderPainted(false);

        Teclado = new JButton(teclado);
        Teclado.setBorder(Main.emptyBorder);
        Teclado.setBackground(Main.transparentColor);
        Teclado.setOpaque(false);
        Teclado.setContentAreaFilled(false);
        Teclado.setBorderPainted(false);

        Mouse = new JButton(mouse);
        Mouse.setBorder(Main.emptyBorder);
        Mouse.setBackground(Main.transparentColor);
        Mouse.setOpaque(false);
        Mouse.setContentAreaFilled(false);
        Mouse.setBorderPainted(false);

        Auriculares = new JButton(auriculares);
        Auriculares.setBorder(Main.emptyBorder);
        Auriculares.setBackground(Main.transparentColor);
        Auriculares.setOpaque(false);
        Auriculares.setContentAreaFilled(false);
        Auriculares.setBorderPainted(false);

        RGB = new JButton(led);
        RGB.setBorder(Main.emptyBorder);
        RGB.setBackground(Main.transparentColor);
        RGB.setOpaque(false);
        RGB.setContentAreaFilled(false);
        RGB.setBorderPainted(false);

        MousePad = new JButton(mousepad);
        MousePad.setBorder(Main.emptyBorder);
        MousePad.setBackground(Main.transparentColor);
        MousePad.setOpaque(false);
        MousePad.setContentAreaFilled(false);
        MousePad.setBorderPainted(false);

        Coach1 = new JButton(coach_1);
        Coach1.setBorder(Main.emptyBorder);
        Coach1.setBackground(Main.transparentColor);
        Coach1.setOpaque(false);
        Coach1.setContentAreaFilled(false);
        Coach1.setBorderPainted(false);

        Coach2 = new JButton(coach_2);
        Coach2.setBorder(Main.emptyBorder);
        Coach2.setBackground(Main.transparentColor);
        Coach2.setOpaque(false);
        Coach2.setContentAreaFilled(false);
        Coach2.setBorderPainted(false);

        Coach3 = new JButton(coach_3);
        Coach3.setBorder(Main.emptyBorder);
        Coach3.setBackground(Main.transparentColor);
        Coach3.setOpaque(false);
        Coach3.setContentAreaFilled(false);
        Coach3.setBorderPainted(false);

        Coach4 = new JButton(coach_4);
        Coach4.setBorder(Main.emptyBorder);
        Coach4.setBackground(Main.transparentColor);
        Coach4.setOpaque(false);
        Coach4.setContentAreaFilled(false);
        Coach4.setBorderPainted(false);

        Coach5 = new JButton(coach_5);
        Coach5.setBorder(Main.emptyBorder);
        Coach5.setBackground(Main.transparentColor);
        Coach5.setOpaque(false);
        Coach5.setContentAreaFilled(false);
        Coach5.setBorderPainted(false);

        eloBoost1 = new JButton(eloboost_1);
        eloBoost1.setBorder(Main.emptyBorder);
        eloBoost1.setBackground(Main.transparentColor);
        eloBoost1.setOpaque(false);
        eloBoost1.setContentAreaFilled(false);
        eloBoost1.setBorderPainted(false);

        eloBoost2 = new JButton(eloboost_2);
        eloBoost2.setBorder(Main.emptyBorder);
        eloBoost2.setBackground(Main.transparentColor);
        eloBoost2.setOpaque(false);
        eloBoost2.setContentAreaFilled(false);
        eloBoost2.setBorderPainted(false);

        eloBoost3 = new JButton(eloboost_3);
        eloBoost3.setBorder(Main.emptyBorder);
        eloBoost3.setBackground(Main.transparentColor);
        eloBoost3.setOpaque(false);
        eloBoost3.setContentAreaFilled(false);
        eloBoost3.setBorderPainted(false);

        eloBoost4 = new JButton(eloboost_4);
        eloBoost4.setBorder(Main.emptyBorder);
        eloBoost4.setBackground(Main.transparentColor);
        eloBoost4.setOpaque(false);
        eloBoost4.setContentAreaFilled(false);
        eloBoost4.setBorderPainted(false);

        eloBoost5 = new JButton(eloboost_5);
        eloBoost5.setBorder(Main.emptyBorder);
        eloBoost5.setBackground(Main.transparentColor);
        eloBoost5.setOpaque(false);
        eloBoost5.setContentAreaFilled(false);
        eloBoost5.setBorderPainted(false);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 5, 20, 20));
        buttonPanel.setBackground(Main.transparentColor);
        buttonPanel.add(Teclado);
        buttonPanel.add(Mouse);
        buttonPanel.add(Auriculares);
        buttonPanel.add(RGB);
        buttonPanel.add(MousePad);
        buttonPanel.add(Coach1);
        buttonPanel.add(Coach2);
        buttonPanel.add(Coach3);
        buttonPanel.add(Coach4);
        buttonPanel.add(Coach5);
        buttonPanel.add(eloBoost1);
        buttonPanel.add(eloBoost2);
        buttonPanel.add(eloBoost3);
        buttonPanel.add(eloBoost4);
        buttonPanel.add(eloBoost5);

        JPanel closePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        closePanel.setBackground(Color.BLACK);
        closePanel.add(closeButton);

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelPrincipal, "menu");
            }
        });

        add(buttonPanel, BorderLayout.CENTER);
        add(closePanel, BorderLayout.PAGE_END);
    }
}
