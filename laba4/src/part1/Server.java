package part1;
import java.net.*;
import java.io.*;


public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

                double[] salaries = (double[]) in.readObject();

                double[] taxes = new double[salaries.length];
                for (int i = 0; i < salaries.length; i++) {
                    if (salaries[i] < 100000) {
                        taxes[i] = salaries[i] * 0.05;
                    } else if (salaries[i] < 500000) {
                        taxes[i] = salaries[i] * 0.1;
                    } else {
                        taxes[i] = salaries[i] * 0.15;
                    }
                }

                out.writeObject(taxes);

                in.close();
                out.close();
                socket.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
