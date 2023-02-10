import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 9090);
            System.out.println("Connected to server");
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("You: ");
                String message = sc.nextLine();
                output.writeUTF(message);
                message = input.readUTF();
                System.out.println("Server: " + message);
                if (message.equals("bye")) {
                    break;
                }
            }
            sc.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}