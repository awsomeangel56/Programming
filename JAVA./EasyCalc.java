import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EasyCalc extends JFrame implements ActionListener {
    private JTextField display = new JTextField();
    private double num1 = 0;
    private char operator = ' ';

    public EasyCalc() {
        setTitle("Calculator");
        setSize(250, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 24));
        add(display, BorderLayout.NORTH);
        
        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "C", "=", "+"};
        
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(this);
            panel.add(button);
        }
        
        add(panel, BorderLayout.CENTER);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.matches("[0-9]")) {
            display.setText(display.getText() + command);
        } else if (command.equals("C")) {
            display.setText("");
            num1 = 0;
            operator = ' ';
        } else if (command.equals("=")) {
            double num2 = Double.parseDouble(display.getText());
            double result = switch (operator) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num2 == 0 ? Double.NaN : num1 / num2;
                default -> num2;
            };
            display.setText(result == result ? String.valueOf(result) : "Error");
        } else {
            num1 = Double.parseDouble(display.getText());
            operator = command.charAt(0);
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            EasyCalc calculator = new EasyCalc();
            calculator.setVisible(true);
        });
    }
}
