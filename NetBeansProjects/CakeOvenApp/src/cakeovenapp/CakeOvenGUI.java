/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cakeovenapp;

/**
 *
 * @author anudari
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CakeOvenGUI extends JFrame {
    private JTextField nameField, weightField, dateField;
    private JTextArea displayArea;
    private Oven oven = new Oven();

    public CakeOvenGUI() {
        setTitle("Cake Oven");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("Cake Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("Weight (grams):"));
        weightField = new JTextField();
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Best Before (YYYY-MM-DD):"));
        dateField = new JTextField();
        inputPanel.add(dateField);

        add(inputPanel, BorderLayout.NORTH);

        // Buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Cake");
        JButton removeButton = new JButton("Remove Cake");
        JButton showButton = new JButton("Show Cakes");
        JButton exitButton = new JButton("Exit");
        JButton topCakeButton = new JButton("Top Cake");
       
        buttonPanel.add(topCakeButton);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(showButton);
        buttonPanel.add(exitButton);

        add(buttonPanel, BorderLayout.CENTER);

        // Display Area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.SOUTH);

        // Action Listeners
        addButton.addActionListener(e -> addCake());
        removeButton.addActionListener(e -> removeCake());
        showButton.addActionListener(e -> showCakes());
        exitButton.addActionListener(e -> System.exit(0));
        topCakeButton.addActionListener(e -> showTopCake());

    }

   private void addCake() {
    try {
        String name = nameField.getText().trim();
        int weight = Integer.parseInt(weightField.getText().trim());
        String bestBefore = dateField.getText().trim();
        String timeAdded = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Basic input check
        if (name.isEmpty() || bestBefore.isEmpty()) {
            displayArea.setText("Please fill in all fields.");
            return;
        }

        // Validate best-before date (within 14 days)
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime bestBeforeDate = LocalDateTime.parse(bestBefore + "T00:00:00");
        if (bestBeforeDate.isBefore(today) || bestBeforeDate.isAfter(today.plusDays(14))) {
            displayArea.setText("Best-before date must be within 14 days from today.");
            return;
        }

        Cake cake = new Cake(name, weight, bestBefore, timeAdded);
        String result = oven.addCake(cake);
        displayArea.setText(result);

    } catch (NumberFormatException ex) {
        displayArea.setText("Please enter a valid number for weight.");
    } catch (Exception ex) {
        displayArea.setText("Please enter the date in the correct format: YYYY-MM-DD.");
    }
}

    private void removeCake() {
        String result = oven.removeCake();
        displayArea.setText(result);
    }

    private void showCakes() {
        String result = oven.showCakes();
        displayArea.setText(result);
    }

    public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(() -> {
        new CakeOvenGUI().setVisible(true);
    });
}
    private void showTopCake() {
    String result = oven.peekTopCake();
    displayArea.setText(result);
    // Added extra detail to the label
      // Added extra detail to the label

}
}