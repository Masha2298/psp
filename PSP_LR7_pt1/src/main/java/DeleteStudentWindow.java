import javax.swing.*;
import java.awt.*;

public class DeleteStudentWindow extends JFrame {
    private int windowWidth = 375;
    private int windowHeight = 200;

    DeleteStudentWindow() {
        super("Удаление студента");
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font font = new Font("Arial", Font.PLAIN, 20);

        JLabel IDLabel = new JLabel("ID студента");
        IDLabel.setBounds(30, 10, 300, 20);
        panel.add(IDLabel);

        JTextField IDField = new JTextField();
        IDField.setSize(300, 30);
        IDField.setLocation(30, 30);
        IDField.setFont(font);
        panel.add(IDField);

        JButton deleteButton = new JButton("Удалить студента");
        deleteButton.setBounds(30, 70, 300, 50);
        panel.add(deleteButton);

        setContentPane(panel);
        setSize(windowWidth, windowHeight);

        deleteButton.addActionListener(e -> {
            String tempID = IDField.getText();
            if (isStringOnlyDigits(tempID) == false) {
                JOptionPane.showMessageDialog(null, "Вы неправильно ввели ID студента", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
            else {
                int ID = Integer.parseInt(tempID);
                boolean result = DBConnector.deleteStudent(ID);

                if (result == true) {
                    IDField.setText("");
                }
            }
        });
    }

    private static boolean isStringOnlyDigits(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
}
