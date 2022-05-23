import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            System.out.println("New connection accepted");

            out.println("Please, enter your name");
            final String name = in.readLine();

            out.println("Hello, " + name + ". How old are you?");
            final String age = in.readLine();

            if (Integer.parseInt(age) >= 18) {
                out.println("Where are you from?");
                final String whereFrom = in.readLine();
                out.println("Very well " + name + ", you are " + age + " years old and you are from " + whereFrom + ". Have a nice day!");
            } else
                out.println("Sorry, you're under 18. Access denied.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
