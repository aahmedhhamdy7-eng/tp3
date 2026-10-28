package Server;
import java.io.*;
import java.net.*;
import common.Operation;
public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            while (true) {
                Operation o = (Operation) in.readObject();
                if (o.op == 'q') break;


                if (o.op == '+') o.resultat = o.a + o.b;
                else if (o.op == '-') o.resultat = o.a - o.b;
                else if (o.op == '*') o.resultat = o.a * o.b;
                else if (o.op == '/') o.resultat = o.a / o.b;
                int total = Serveur.incrementer();
                System.out.println(o.a + " " + o.op + " " + o.b + " = " + o.resultat
                        + "   | Opérations traitées : " + total);

                out.writeObject(o);
            }
            socket.close();
        } catch (Exception e) {
            System.out.println("Client déconnecté");
        }
    }
}