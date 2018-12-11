import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Client implements Runnable{
    private String url;
    private int port;
    private Socket socket;
    PrintWriter writer;

    public Client(String url, int port) throws IOException {
        this.url = url;
        this.port = port;
        socket = new Socket(url, port);
    }

    void sendMessage(String message) throws IOException {
        writer.println("["+message+"]");
    }

    void close() throws IOException {
        socket.close();
    }

    public void run() {
        try {

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));

            for(;;)
                System.out.println(reader.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
