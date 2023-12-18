import javax.swing.*;
import java.awt.*;

public class UpdateStudentWindow extends JFrame {
    private int windowWidth = 375;
    private int windowHeight = 560;
    UpdateStudentWindow() {
        super("Редактирование студента");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font font = new Font("Arial", Font.PLAIN, 20);

        JLabel nameLabel = new JLabel("ФИО студента");
        nameLabel.setBounds(30, 10, 300, 20);
        panel.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setSize(300, 30);
        nameField.setLocation(30, 30);
        nameField.setFont(font);
        panel.add(nameField);

        JLabel groupNumberLabel = new JLabel("Номер группы");
        groupNumberLabel.setBounds(30, 70, 300, 20);
        panel.add(groupNumberLabel);

        JTextField groupNumberField = new JTextField();
        groupNumberField.setSize(300, 30);
        groupNumberField.setLocation(30, 90);
        groupNumberField.setFont(font);
        panel.add(groupNumberField);

        JLabel dormitoryNumberLabel = new JLabel("Номер общежития");
        dormitoryNumberLabel.setBounds(30, 130, 300, 20);
        panel.add(dormitoryNumberLabel);

        JTextField dormitoryNumberField = new JTextField();
        dormitoryNumberField.setSize(300, 30);
        dormitoryNumberField.setLocation(30, 150);
        dormitoryNumberField.setFont(font);
        panel.add(dormitoryNumberField);

        JLabel dormitoryAddressLabel = new JLabel("Адрес общежития");
        dormitoryAddressLabel.setBounds(30, 190, 300, 20);
        panel.add(dormitoryAddressLabel);

        JTextField dormitoryAddressField = new JTextField();
        dormitoryAddressField.setSize(300, 30);
        dormitoryAddressField.setLocation(30, 210);
        dormitoryAddressField.setFont(font);
        panel.add(dormitoryAddressField);

        JLabel roomNumberLabel = new JLabel("Номер комнаты");
        roomNumberLabel.setBounds(30, 250, 300, 20);
        panel.add(roomNumberLabel);

        JTextField roomNumberField = new JTextField();
        roomNumberField.setSize(300, 30);
        roomNumberField.setLocation(30, 270);
        roomNumberField.setFont(font);
        panel.add(roomNumberField);

        JLabel floorLabel = new JLabel("Этаж");
        floorLabel.setBounds(30, 310, 300, 20);
        panel.add(floorLabel);

        JTextField floorField = new JTextField();
        floorField.setSize(300, 30);
        floorField.setLocation(30, 330);
        floorField.setFont(font);
        panel.add(floorField);

        JLabel IDLabel = new JLabel("ID студента");
        IDLabel.setBounds(30, 370, 300, 20);
        panel.add(IDLabel);

        JTextField IDField = new JTextField();
        IDField.setSize(300, 30);
        IDField.setLocation(30, 390);
        IDField.setFont(font);
        panel.add(IDField);

        JButton okButton = new JButton("Добавить");
        okButton.setBounds(30, 440, 300, 50);
        panel.add(okButton);

        setContentPane(panel);
        setSize(windowWidth, windowHeight);

        okButton.addActionListener(e -> {
            boolean result = Student.updateStudent(IDField.getText(), nameField.getText(), groupNumberField.getText(), dormitoryNumberField.getText(),
                    dormitoryAddressField.getText(), roomNumberField.getText(), floorField.getText());

            if (result == true) {
                nameField.setText("");
                groupNumberField.setText("");
                dormitoryNumberField.setText("");
                dormitoryAddressField.setText("");
                roomNumberField.setText("");
                floorField.setText("");
                IDField.setText("");
            }
        });
    }
}
