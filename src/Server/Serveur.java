package Server;
import java.net.*;

public class Serveur {
    private static int compteur = 0;
    public static synchronized int incrementer() {
        compteur++;
        return compteur;
    }

    public static void main(String[] args) throws Exception {
        ServerSocket serveur = new ServerSocket(1234);
        System.out.println("Serveur démarré sur le port 1234...");

        while (true) {
            Socket socket = serveur.accept();          // attend un client
            System.out.println("Nouveau client connecté");
            new ClientHandler(socket).start();         // un thread par client
        }
    }
}
