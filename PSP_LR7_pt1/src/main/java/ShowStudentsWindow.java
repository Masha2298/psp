import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ShowStudentsWindow extends JFrame {
    private int windowWidth = 700;
    private int windowHeight = 400;
    private JTable table;
    ShowStudentsWindow() {
        super("Просмотр студентов");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        Font font = new Font("Arial", Font.PLAIN, 20);

        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList = DBConnector.getStudents();

        // Получаем количество столбцов
        int rowCount = studentArrayList.size();

        // Создание данных для таблицы
        Object[][] data = new Object[rowCount][7];

        for (int i = 0; i < rowCount; i++) {
            data[i][0] = studentArrayList.get(i).getID();
            data[i][1] = studentArrayList.get(i).getName();
            data[i][2] = studentArrayList.get(i).getStudyGroup();
            data[i][3] = studentArrayList.get(i).getDormitoryNumber();
            data[i][4] = studentArrayList.get(i).getDormitoryAddress();
            data[i][5] = studentArrayList.get(i).getRoomNumber();
            data[i][6] = studentArrayList.get(i).getFloor();
        }

        // Заголовки столбцов
        String[] columnNames = {"ID", "ФИО", "№ группы", "№ общежития", "Адрес общежития", "№ команаты", "Этаж"};

        // Создание таблицы
        JTable table = new JTable(data, columnNames);

        // Создание панели с прокруткой, чтобы можно было прокручивать таблицу
        JScrollPane scrollPane = new JScrollPane(table);

        scrollPane.setSize(665, 340);
        scrollPane.setLocation(10, 10);

        panel.add(scrollPane);

        setContentPane(panel);
        setSize(windowWidth, windowHeight);
    }
}
