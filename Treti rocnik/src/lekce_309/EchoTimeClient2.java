package lekce_309;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class EchoTimeClient2 implements Closeable {
    private final Socket socket;
    private final Scanner input;
    private final BufferedWriter output;

    public static void main(String[] args) {
        try (EchoTimeClient2 ec = new EchoTimeClient2("127.0.0.1", 10000)) {
            ec.write(new Scanner(System.in).nextLine());
            System.out.println(ec.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EchoTimeClient2(String name, int port) throws IOException {
        this.socket = new Socket(name, port);
        this.input = new Scanner(socket.getInputStream());
        this.output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    public String read() throws IOException {
        System.out.println("reading");
        return input.nextLine();
    }

    public void write(String line) throws IOException {
        System.out.println("writing");
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
