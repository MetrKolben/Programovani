package lekce_309;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer2 implements Closeable {
    private final ServerSocket server;
    private final Socket socket;
    private final Scanner input;
    private final BufferedWriter output;

    public static void main(String[] args) {
        try (EchoServer2 ec = new EchoServer2(10000)) {
            while (true) {
                System.out.println("waiting for a message");
                String line = ec.read();
                System.out.println("got: " + line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EchoServer2(int port) throws IOException {
        System.out.println("create server socket");
        this.server = new ServerSocket(port);
        System.out.println("listening");
        socket = server.accept();
        this.input = new Scanner(socket.getInputStream());
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public String read() throws IOException {
        return input.nextLine();
    }

    public void write(String line) throws IOException {
        output.write(line);
        output.newLine();
        output.flush();
    }

    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
