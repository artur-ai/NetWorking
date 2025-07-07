import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(2112);
            System.out.println("Server is starts. Waiting for users....");
            Socket socket = serverSocket.accept();
            System.out.println("Client has already connect");

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            byte[] buffer = new byte[1024];
            int read = inputStream.read(buffer);

            System.out.println(new String(buffer, 0, read));

            String message = "echo: " + new String(buffer, 0, read);
            outputStream.write(message.getBytes());
        } catch (IOException exception) {
            System.out.println("Could not be listen on port 2112");
            throw new RuntimeException(exception);
        }
    }
}
