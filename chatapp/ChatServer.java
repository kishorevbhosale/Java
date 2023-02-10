import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9090);
            System.out.println("Server started on port 9090");
            Socket socket = server.accept();
            System.out.println("Client connected");
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                String message = input.readUTF();
                System.out.println("Client: " + message);
                System.out.print("You: ");
                message = sc.nextLine();
                output.writeUTF(message);
                if (message.equals("bye")) {
                    break;
                }
            }
            sc.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}