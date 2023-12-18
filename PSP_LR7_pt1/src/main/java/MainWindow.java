import javax.swing.*;

public class MainWindow extends JFrame {
    private int windowWidth = 375;
    private int windowHeight = 500;
    MainWindow() {
        super("Лабораторная 7 (часть 1)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton addButton = new JButton("Добавить студента");
        addButton.setBounds(30, 30, 300, 50);
        panel.add(addButton);

        JButton readButton = new JButton("Просмотерть студентов");
        readButton.setBounds(30, 100, 300, 50);
        panel.add(readButton);

        JButton updateButton = new JButton("Редактировать студента");
        updateButton.setBounds(30, 170, 300, 50);
        panel.add(updateButton);

        JButton deleteButton = new JButton("Удалить студента");
        deleteButton.setBounds(30, 240, 300, 50);
        panel.add(deleteButton);

        setContentPane(panel);
        setSize(windowWidth, windowHeight);

        addButton.addActionListener(e -> {
            JFrame studentWindow = new AddStudentWindow("Добавление нового студента");
            studentWindow.setVisible(true);
        });

        readButton.addActionListener(e -> {
            JFrame showStudentsWindow = new ShowStudentsWindow();
            showStudentsWindow.setVisible(true);
        });

        updateButton.addActionListener(e -> {
            JFrame updateStudentWindow = new UpdateStudentWindow();
            updateStudentWindow.setVisible(true);
        });

        deleteButton.addActionListener(e -> {
            JFrame deleteStudentWindow = new DeleteStudentWindow();
            deleteStudentWindow.setVisible(true);
        });
    }
}
