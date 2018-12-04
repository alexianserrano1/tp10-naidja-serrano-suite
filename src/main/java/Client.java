import java.io.IOException;
import java.net.Socket;

public class Client {
    private String url;
    private int port;
    private Socket socket;

    public Client(String url, int port) throws IOException {
        this.url = url;
        this.port = port;
        socket = new Socket(url, port);
    }

    void sendMessage(String message) {

    }
}
