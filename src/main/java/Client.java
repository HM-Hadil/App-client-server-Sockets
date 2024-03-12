import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 123); // Remplacez "adresse_ip_du_serveur" par l'adresse IP réelle du serveur
            // Envoi du message au serveur
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.println("Bonjour, serveur!");

            // Lecture de la réponse du serveur
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String response = br.readLine();
            System.out.println("Réponse du serveur : " + response);
        }

        catch(IOException e){
            e.printStackTrace();
        }

        }
}
