package part2;
import java.net.*;
import java.io.*;
import java.util.*;
public class Client {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Enter x, y, z: ");
                double[] params = new double[3];
                for (int i = 0; i < 3; i++) {
                    params[i] = scanner.nextDouble();
                }

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baos);
                out.writeObject(params);

                byte[] requestBuffer = baos.toByteArray();
                DatagramPacket request = new DatagramPacket(requestBuffer, requestBuffer.length, InetAddress.getLocalHost(), 1234);
                socket.send(request);

                byte[] responseBuffer = new byte[1024];
                DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length);
                socket.receive(response);

                ByteArrayInputStream bais = new ByteArrayInputStream(response.getData());
                DataInputStream in = new DataInputStream(bais);

                double result = in.readDouble();

                System.out.println("Result: " + result);

                out.close();
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
