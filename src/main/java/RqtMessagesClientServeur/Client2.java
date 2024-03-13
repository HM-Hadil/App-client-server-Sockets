package RqtMessagesClientServeur;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 1414);
            InputStream is = s.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            //scanner.nextLine est une methode bloquante
            String message = sc.nextLine();
            pw.println(message);
            pw.flush();

            while (!message.equalsIgnoreCase("end")) {
                System.out.println("RqtClientServeur_Char.Serveur :" + br.readLine());
                pw.println("echo");
                pw.flush();
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);


        }
    }
}