import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        // Create components
        JLabel amountLabel = new JLabel("Enter Amount:");
        JTextField amountField = new JTextField();

        JLabel fromCurrencyLabel = new JLabel("From Currency (USD/EUR):");
        JTextField fromCurrencyField = new JTextField();

        JLabel toCurrencyLabel = new JLabel("To Currency (USD/EUR):");
        JTextField toCurrencyField = new JTextField();

        JButton convertButton = new JButton("Convert");
        JLabel resultLabel = new JLabel("Result: ", JLabel.CENTER);

        // Add components to frame
        frame.add(amountLabel);
        frame.add(amountField);
        frame.add(fromCurrencyLabel);
        frame.add(fromCurrencyField);
        frame.add(toCurrencyLabel);
        frame.add(toCurrencyField);
        frame.add(convertButton);
        frame.add(resultLabel);

        // Add action listener to the Convert button
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String fromCurrency = fromCurrencyField.getText().toUpperCase();
                    String toCurrency = toCurrencyField.getText().toUpperCase();

                    double conversionRate = getConversionRate(fromCurrency, toCurrency);
                    if (conversionRate != -1) {
                        double result = amount * conversionRate;
                        resultLabel.setText("Result: " + result + " " + toCurrency);
                    } else {
                        resultLabel.setText("Invalid currency code.");
                    }
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid amount.");
                }
            }

            private double getConversionRate(String from, String to) {
                // Mock conversion rates for USD and EUR
                if (from.equals("USD") && to.equals("EUR")) {
                    return 0.85; // 1 USD = 0.85 EUR
                } else if (from.equals("EUR") && to.equals("USD")) {
                    return 1.18; // 1 EUR = 1.18 USD
                } else if (from.equals(to)) {
                    return 1.0; // Same currency
                } else {
                    return -1; // Invalid currency code
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}

