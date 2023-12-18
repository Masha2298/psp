import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Student {
    private int ID;
    private String name;
    private int group;
    private int dormitoryNumber;
    private String dormitoryAddress;
    private int roomNumber;
    private int floor;

    Student(String name, int group, int dormitoryNumber, String dormitoryAddress, int roomNumber, int floor) {
        this.name = name;
        this.group = group;
        this.dormitoryNumber = dormitoryNumber;
        this.dormitoryAddress = dormitoryAddress;
        this.roomNumber = roomNumber;
        this.floor = floor;
    }

    Student(int ID, String name, int group, int dormitoryNumber, String dormitoryAddress, int roomNumber, int floor) {
        this.ID = ID;
        this.name = name;
        this.group = group;
        this.dormitoryNumber = dormitoryNumber;
        this.dormitoryAddress = dormitoryAddress;
        this.roomNumber = roomNumber;
        this.floor = floor;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getStudyGroup() {
        return group;
    }

    public int getDormitoryNumber() {
        return dormitoryNumber;
    }

    public String getDormitoryAddress() {
        return dormitoryAddress;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void printInfo() {
        System.out.println("----------------\nИмя студента: " + name + "\nГруппа: " + group + "\nНомер общежития: " + dormitoryNumber + "\nАдрес общежития: " +
                dormitoryAddress + "\nНомер команты: " + roomNumber + "\nЭтаж: " + floor);
    }

    public static boolean createStudent(String name, String group, String dormitoryNumber, String dormitoryAddress, String roomNumber, String floor) {
        String checking = checkInfo(name, group, dormitoryNumber, roomNumber, floor);

        if (checking == "true") {
            Student student = new Student(name, Integer.parseInt(group), Integer.parseInt(dormitoryNumber), dormitoryAddress, Integer.parseInt(roomNumber), Integer.parseInt(floor));
            DBConnector.addStudent(student);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, checking, "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public static boolean updateStudent(String id, String name, String group, String dormitoryNumber, String dormitoryAddress, String roomNumber, String floor) {
        String checking = checkInfo(id, name, group, dormitoryNumber, roomNumber, floor);

        if (checking == "true") {
            Student student = new Student(Integer.parseInt(id), name, Integer.parseInt(group), Integer.parseInt(dormitoryNumber), dormitoryAddress, Integer.parseInt(roomNumber), Integer.parseInt(floor));
            DBConnector.updateStudent(student);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, checking, "Ошибка", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    private static String checkInfo(String name, String group, String dormitoryNumber, String roomNumber, String floor) {
        if (isStringOnlyAlphabet(name) == false) {
            return "Вы неправильно ввели ФИО";
        }

        if (isStringOnlyDigits(group) == false) {
            return "Вы неправильно ввели номер группы";
        }

        if (isStringOnlyDigits(dormitoryNumber) == false || dormitoryNumber.length() > 3) {
            return "Вы неправильно ввели номер общежития";
        }

        if (isStringOnlyDigits(roomNumber) == false || roomNumber.length() > 3) {
            return "Вы неправильно ввели номер комнаты";
        }

        if (isStringOnlyDigits(floor) == false || floor.length() > 3) {
            return "Вы неправильно ввели этаж";
        }

        return "true";
    }

    private static String checkInfo(String id, String name, String group, String dormitoryNumber, String roomNumber, String floor) {
        if (isStringOnlyAlphabet(name) == false) {
            return "Вы неправильно ввели ФИО";
        }

        if (isStringOnlyDigits(group) == false) {
            return "Вы неправильно ввели номер группы";
        }

        if (isStringOnlyDigits(dormitoryNumber) == false || dormitoryNumber.length() > 3) {
            return "Вы неправильно ввели номер общежития";
        }

        if (isStringOnlyDigits(roomNumber) == false || roomNumber.length() > 3) {
            return "Вы неправильно ввели номер комнаты";
        }

        if (isStringOnlyDigits(floor) == false || floor.length() > 3) {
            return "Вы неправильно ввели этаж";
        }

        if (isStringOnlyDigits(id) == false) {
            return "Вы неправильно ввели ID сутдента";
        }

        return "true";
    }

    private static boolean isStringOnlyAlphabet(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
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