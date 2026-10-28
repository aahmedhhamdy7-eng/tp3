package Client;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import common.Operation;

public class Client {
    public static void main(String[] args) throws Exception {
        String adresse = (args.length > 0) ? args[0] : "localhost";

        Socket socket = new Socket(adresse, 1234);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Opérateur (+ - * /) ou q pour quitter : ");
            char op = sc.next().charAt(0);

            if (op == 'q') {
                out.writeObject(new Operation(0, 'q', 0));
                break;
            }

            System.out.print("Nombre 1 : ");
            double a = sc.nextDouble();
            System.out.print("Nombre 2 : ");
            double b = sc.nextDouble();

            out.writeObject(new Operation(a, op, b));
            Operation reponse = (Operation) in.readObject();
            System.out.println("Résultat = " + reponse.resultat);
        }
        socket.close();
    }
}
