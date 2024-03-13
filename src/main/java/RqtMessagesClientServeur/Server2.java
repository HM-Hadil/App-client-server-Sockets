package RqtMessagesClientServeur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) {
        ServerSocket ss;

        try {
            ss = new ServerSocket(1414);
            System.out.println("J'attends une demande de connexion");
            Socket s = ss.accept();
            System.out.println("RqtClientServeur_Char.Client accepté avec les informations");

            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter pw = new PrintWriter(s.getOutputStream());

            String message;
            while ((message = br.readLine()) != null) {
                System.out.println("RqtClientServeur_Char.Client: " + message);
                if (message.equalsIgnoreCase("end")) {
                    break; // Sortir de la boucle si le client envoie "end"
                }
                pw.println("Message de serveur  : " + message); // Envoyer une réponse au client
                pw.flush();
            }

            // Fermer les flux et les sockets
            br.close();
            pw.close();
            s.close();
            ss.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
