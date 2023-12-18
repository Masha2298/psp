package part2;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(1234)) {
            System.out.println("Server started");
            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);
                System.out.println("Client connected");

                ByteArrayInputStream bais = new ByteArrayInputStream(request.getData());
                ObjectInputStream in = new ObjectInputStream(bais);

                double[] params = (double[]) in.readObject();
                double result = calculateFunction(params);

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baos);
                out.writeDouble(result);

                byte[] responseBuffer = baos.toByteArray();
                DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length, request.getAddress(), request.getPort());
                socket.send(response);

                in.close();
                out.close();
                System.out.println("Client disconnected");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static double calculateFunction(double[] params) {
        double x = params[0];
        double y = params[1];
        double z = params[2];

        double cos = Math.cos(x - Math.PI / 6);
        double sin = Math.sin(y);
        double e = Math.exp(0.5);
        double pow = Math.pow(z, 2) / 3 - Math.pow(z, 5) / 5;

        return 2 * cos / (e + Math.pow(sin, 2)) * (1 + pow);
    }
}
