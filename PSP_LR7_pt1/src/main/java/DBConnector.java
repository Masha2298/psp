import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    // Параметры подключения к базе данных
    private static String url = "jdbc:mysql://localhost:3306/Students_PSP7";
    private static String username = "root";
    private static String password = "";

    public static void addStudent(Student student) {
        // Устанавливаем соединение с базой данных
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            String insertQuery = "INSERT INTO Students (name, studyGroup, dormitoryNumber, dormitoryAddress, roomNumber, floor) VALUES (?, ?, ?, ?, ?, ?)";

            // Создаем подготовленное выражение
            try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
                // Устанавливаем значения параметров
                statement.setString(1, student.getName());
                statement.setInt(2, student.getStudyGroup());
                statement.setInt(3, student.getDormitoryNumber());
                statement.setString(4, student.getDormitoryAddress());
                statement.setInt(5, student.getRoomNumber());
                statement.setInt(6, student.getFloor());

                // Выполняем запрос на вставку
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "Новая запись добавлена в базу данных", "Успех", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Не удалось добавить новую запись в базу данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при подключении к базе данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
    }

    public static ArrayList<Student> getStudents() {
        // Устанавливаем соединение с базой данных
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Соединение с базой данных установлено!");

            // Создаем SQL-запрос для выборки всех записей
            String selectQuery = "SELECT * FROM Students";

            // Создаем объект Statement для выполнения запроса
            try (Statement statement = connection.createStatement()) {
                // Выполняем запрос и получаем результат в виде объекта ResultSet
                ResultSet resultSet = statement.executeQuery(selectQuery);

                ArrayList<Student> studentsArrayList = new ArrayList<>();

                // Обрабатываем результаты запроса
                while (resultSet.next()) {
                    // Извлекаем значения из текущей строки результата
                    Student student = new Student(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("studyGroup"), resultSet.getInt("dormitoryNumber"),
                            resultSet.getString("dormitoryAddress"),  resultSet.getInt("roomNumber"), resultSet.getInt("floor"));

                    studentsArrayList.add(student);
                }

                return studentsArrayList;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при подключении к базе данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }

        return null;
    }

    public static boolean deleteStudent(int ID) {
        // Устанавливаем соединение с базой данных
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Соединение с базой данных установлено!");

            // Создаем SQL-запрос для удаления студента по ID
            String deleteQuery = "DELETE FROM students WHERE id = " + ID;

            // Создаем объект Statement для выполнения запроса
            try (Statement statement = connection.createStatement()) {
                // Выполняем запрос
                int rowsAffected = statement.executeUpdate(deleteQuery);

                // Проверяем количество удаленных строк
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Студент с ID " + ID + " успешно удалён", "Успех", JOptionPane.INFORMATION_MESSAGE);
                    System.out.println("Студент с ID " + ID + " успешно удален.");
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Студент с ID " + ID + " не найден", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    System.out.println("Студент с ID " + ID + " не найден.");
                    return false;
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ошибка при подключении к базе данных", "Ошибка", JOptionPane.ERROR_MESSAGE);
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
            return false;
        }
    }

    public static void updateStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // ID студента, запись которого необходимо обновить
            int studentId = student.getID();

            // Новые значения для обновления записи
            String newName = "Новое имя";
            int newAge = 20;

            // Создаем SQL-запрос для обновления записи по ID
            String updateQuery = "UPDATE students SET name = '" + student.getName() + "', studyGroup = '" + student.getStudyGroup() +
                     "', dormitoryNumber = '" + student.getDormitoryNumber() + "',dormitoryAddress = '" + student.getDormitoryAddress() +
                    "', roomNumber = '" + student.getRoomNumber() + "', floor = '" + student.getFloor() + "' WHERE id = " + studentId;

            // Создаем объект Statement для выполнения запроса
            try (Statement statement = connection.createStatement()) {
                // Выполняем запрос
                int rowsAffected = statement.executeUpdate(updateQuery);

                // Проверяем количество обновленных строк
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Запись с ID " + studentId + " успешно обновлена", "Успех", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Запись с ID " + studentId + " не найдена", "Ошибка", JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch (SQLException e) {
            System.out.println("Ошибка при подключении к базе данных: " + e.getMessage());
        }
    }
}
