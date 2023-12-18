package part2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;

import java.util.Date;
public class ProductRegistrationApp extends JFrame {
    private JTextField productNameField;
    private JTextField quantityField;
    private JComboBox<String> categoryComboBox;
    private JTextArea logTextArea;

    public ProductRegistrationApp() {
        setTitle("Регистрация поступлений товаров");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel productNameLabel = new JLabel("Наименование товара:");
        productNameField = new JTextField();
        JLabel quantityLabel = new JLabel("Количество:");
        quantityField = new JTextField();
        JLabel categoryLabel = new JLabel("Категория:");
        String[] categories = {"Продукты", "Бытовая химия", "Одежда", "Электроника"};
        categoryComboBox = new JComboBox<>(categories);
        JButton registerButton = new JButton("Зарегистрировать");
        logTextArea = new JTextArea();
        logTextArea.setEditable(false);

        panel.add(productNameLabel);
        panel.add(productNameField);
        panel.add(quantityLabel);
        panel.add(quantityField);
        panel.add(categoryLabel);
        panel.add(categoryComboBox);
        panel.add(registerButton);
        panel.add(new JLabel()); // Empty cell for alignment
        panel.add(new JLabel("Журнал поступлений:"));
        panel.add(new JLabel()); // Empty cell for alignment
        panel.add(new JScrollPane(logTextArea));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerProduct();
            }
        });

        add(panel);
    }

    private void registerProduct() {
        String productName = productNameField.getText();
        String quantityStr = quantityField.getText();
        String category = (String) categoryComboBox.getSelectedItem();

        if (!productName.isEmpty() && !quantityStr.isEmpty()) {
            try {
                int quantity = Integer.parseInt(quantityStr);
                String entry = String.format("[%s] %s - %d шт.", getCurrentDate(), productName, quantity);
                logTextArea.append(entry + "\n");

                // Можно сохранить данные в файл, если необходимо
                // saveToFile(entry);

                // Очистим поля после регистрации
                productNameField.setText("");
                quantityField.setText("");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Введите корректное количество", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Заполните все поля", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        return dateFormat.format(new Date());
    }

    private void saveToFile(String entry) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("laba5.txt", true))) {
            writer.write(entry + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductRegistrationApp().setVisible(true);
            }
        });
    }
}