
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingJavaApplication extends JFrame implements ActionListener {
    // Components
    private JTextField textField;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] functionButtons = new JButton[5]; // +, -, *, /, %
    private JButton addButton, subButton, mulButton, divButton, modButton, eqButton, clrButton, delButton;
    private JPanel panel;

    // Variables for calculation
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor
    public SwingJavaApplication() {
        // Frame setup
        this.setTitle("Calculator App");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 550);
        this.setLayout(null);

        // Text field
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setEditable(false);
        this.add(textField);

        // Function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        modButton = new JButton("%");
        eqButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("Del");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = modButton;

        // Add action listeners to function buttons
        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
        }

        eqButton.addActionListener(this);
        clrButton.addActionListener(this);
        delButton.addActionListener(this);

        // Number buttons
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
        }

        // Panel for buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        for (int i = 1; i <= 9; i++) {
            panel.add(numberButtons[i]);
        }
        panel.add(functionButtons[0]); // +
        panel.add(numberButtons[0]);
        panel.add(eqButton); // =
        panel.add(functionButtons[1]); // -

        panel.add(functionButtons[2]); // *
        panel.add(functionButtons[3]); // /
        panel.add(functionButtons[4]); // %

        this.add(panel);

        // Clear and delete buttons
        clrButton.setBounds(50, 420, 100, 50);
        delButton.setBounds(250, 420, 100, 50);
        this.add(clrButton);
        this.add(delButton);

        // Make frame visible
        this.setVisible(true);
    }

    // Action handling
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText() + i);
            }
        }

        if (e.getSource() == clrButton) {
            textField.setText("");
            num1 = 0;
            num2 = 0;
            operator = '\0';
        }

        if (e.getSource() == delButton) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                textField.setText(text.substring(0, text.length() - 1));
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if (e.getSource() == modButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText("");
        }

        if (e.getSource() == eqButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        textField.setText("Error");
                        return;
                    }
                    break;
                case '%':
                    result = num1 % num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
    }

    // Main method
    public static void main(String[] args) {
        new SwingJavaApplication();
    }
}
