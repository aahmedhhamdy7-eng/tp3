package Server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class ClientHandler extends Thread {
    private final Socket s;
    private final int n;

    public ClientHandler(Socket s, int n) {
        this.s = s;
        this.n = n;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);

            out.println("Vous etes le client numero " + n);

            String ligne;
            while ((ligne = in.readLine()) != null) {
                System.out.println("Client n" + n + " : " + ligne);
                out.println("Echo : " + ligne);
            }
            s.close();
        } catch (IOException e) {
            System.out.println("Client n" + n + " deconnecte");
        }
    }
}