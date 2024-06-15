package EquationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class EquationView extends JFrame {
    private JTextField equationInput = new JTextField(30);
    private JButton calculateButton = new JButton("Calculate");
    private JLabel resultLabel = new JLabel("Result: ");
    private JLabel termCountLabel = new JLabel("Term Count: ");

    public EquationView() {
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 150);

        panel.add(new JLabel("Enter Equation:"));
        panel.add(equationInput);
        panel.add(calculateButton);
        panel.add(resultLabel);
        panel.add(termCountLabel);

        this.add(panel);
    }

    public String getEquationInput() {
        return equationInput.getText();
    }

    public void setResult(String result) {
        resultLabel.setText("Result: " + result);
    }

    public void setTermCount(int count) {
        termCountLabel.setText("Term Count: " + count);
    }

    public void addCalculateListener(ActionListener listenForCalcButton) {
        calculateButton.addActionListener(listenForCalcButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
