package Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {



    public static void main(String[] args) {
        int numeroClient = 0;

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println( " - en attente de clients...");

            while (true) {
                Socket socket = serverSocket.accept();   // bloquant jusqu'a une connexion
                numeroClient++;

                // Adresse IP + port du client
                System.out.println("Client n" + numeroClient + " connecte : "
                        + socket.getRemoteSocketAddress());

                // Un thread dedie par client
                new ClientHandler(socket, numeroClient).start();
            }
        } catch (IOException e) {
            System.err.println("Erreur serveur : " + e.getMessage());
        }
    }
}
