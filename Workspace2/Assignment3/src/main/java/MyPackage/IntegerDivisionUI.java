package MyPackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntegerDivisionUI {
    public static void main(String[] args) {
        // Create the frame
        JFrame frame = new JFrame("Integer Division");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null);

        // Create the labels
        JLabel label1 = new JLabel("Num1:");
        label1.setBounds(30, 30, 100, 30);
        frame.add(label1);

        JLabel label2 = new JLabel("Num2:");
        label2.setBounds(30, 70, 100, 30);
        frame.add(label2);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(30, 110, 100, 30);
        frame.add(resultLabel);

        // Create the text fields
        JTextField num1Field = new JTextField();
        num1Field.setBounds(100, 30, 200, 30);
        frame.add(num1Field);

        JTextField num2Field = new JTextField();
        num2Field.setBounds(100, 70, 200, 30);
        frame.add(num2Field);

        JTextField resultField = new JTextField();
        resultField.setBounds(100, 110, 200, 30);
        resultField.setEditable(false);
        frame.add(resultField);

        // Create the button
        JButton divideButton = new JButton("Divide");
        divideButton.setBounds(150, 150, 100, 30);
        frame.add(divideButton);

        // Add action listener to the button
        divideButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the input numbers
                    int num1 = Integer.parseInt(num1Field.getText());
                    int num2 = Integer.parseInt(num2Field.getText());

                    // Perform division
                    if (num2 == 0) {
                        throw new ArithmeticException("Cannot divide by zero");
                    }

                    int result = num1 / num2;
                    resultField.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid integers", "Number Format Exception", JOptionPane.ERROR_MESSAGE);
                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(frame, "Cannot divide by zero", "Arithmetic Exception", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Set frame visibility
        frame.setVisible(true);
    }
}
