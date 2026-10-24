package Client;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket();
        s.connect(new InetSocketAddress(InetAddress.getByName("localhost"), 1234));

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(in.readLine());

        String texte;
        while ((texte = clavier.readLine()) != null) {
            out.println(texte);
            System.out.println(in.readLine());
        }
        s.close();
    }
}
