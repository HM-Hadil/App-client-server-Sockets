import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(23);
            System.out.println(" attendre les connexions entrantes des clients.");

            Socket sock = ss.accept();
            System.out.println(" bloque l'exécution du programme jusqu'à ce qu'un client se connecte au serveur");

            //  Lecture du message du client
            InputStream is = sock.getInputStream();
            System.out.println("crée un flux d'entrée à partir du socket du client");
            InputStreamReader isr = new InputStreamReader(is);
            System.out.println("convertit les octets reçus du client en caractères ");
            BufferedReader br= new BufferedReader(isr);
            System.out.println(" lire les données envoyées par le client en texte brut, ligne par ligne");
            String s=br.readLine();
            System.out.println("Message du client de cmd : " + s);

            System.out.println("lit une ligne de texte envoyée par le client.");

            // Envoi d'une réponse au client dans cmd
            OutputStream os = sock.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("chaine de caractères");
            pw.flush();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
