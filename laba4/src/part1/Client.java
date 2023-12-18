package part1;
import java.net.*;
import java.io.*;
import java.util.*;
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234)) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter salaries (comma separated): ");
                String[] salariesStr = scanner.nextLine().split(",");
                double[] salaries = new double[salariesStr.length];
                for (int i = 0; i < salariesStr.length; i++) {
                    salaries[i] = Double.parseDouble(salariesStr[i]);
                }

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

                out.writeObject(salaries);

                double[] taxes = (double[]) in.readObject();

                System.out.print("Taxes: ");
                for (double tax : taxes) {
                    System.out.print(tax + " ");
                }
                System.out.println();

                out.close();
                in.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
