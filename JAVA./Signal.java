import java.awt.*;
import javax.swing.*;

public class Signal extends JFrame {
    public Signal() {
        setTitle("Traffic Light");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JRadioButton red = new JRadioButton("Red"), yellow = new JRadioButton("Yellow"), green = new JRadioButton("Green");
        ButtonGroup group = new ButtonGroup(); 
        group.add(red); 
        group.add(yellow); 
        group.add(green);

        JPanel lightPanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK); 
                g.fillRect(100, 50, 100, 300);
                g.setColor(red.isSelected() ? Color.RED : Color.DARK_GRAY); 
                g.fillOval(125, 75, 50, 50);
                g.setColor(yellow.isSelected() ? Color.YELLOW : Color.DARK_GRAY); 
                g.fillOval(125, 175, 50, 50);
                g.setColor(green.isSelected() ? Color.GREEN : Color.DARK_GRAY); 
                g.fillOval(125, 275, 50, 50);
            }
        };

        red.addActionListener(e -> lightPanel.repaint());
        yellow.addActionListener(e -> lightPanel.repaint());
        green.addActionListener(e -> lightPanel.repaint());

        add(new JPanel(new GridLayout(3, 1)) {{ 
            add(red); 
            add(yellow); 
            add(green); }}, 
            BorderLayout.WEST);
        add(lightPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> 
        new Signal().setVisible(true));
    }
}
