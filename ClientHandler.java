import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        try {
            this.inputStream = new ObjectInputStream(clientSocket.getInputStream());
            this.outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // Handle client requests and communicate with the model
        // You need to implement this part based on your specific requirements
    }
}
