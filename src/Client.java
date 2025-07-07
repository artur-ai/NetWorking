import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        try {
            Socket socket = new Socket("localhost", 2112);
            Scanner scanner = new Scanner(System.in);

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            System.out.println("Enter your message to server: ");
            String message = scanner.nextLine();

            outputStream.write(message.getBytes());

            byte[] buffer = new byte[1024];
            int read = inputStream.read(buffer);
            System.out.println(new String(buffer, 0, read));
        } catch (IOException exception) {
            System.out.println("Could not connect with port 2112");
            throw new RuntimeException(exception);
        }
    }
}
