package ServeurMultiThreads;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Socket socket;

        try {

            socket = new Socket("localhost", 2024);
            //pour recevoir des chaines de caractères
            InputStream is=socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);

            //pour envoyer des chaines de carctères
            OutputStream os= socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            //pour lire du clavier
            Scanner sc = new Scanner(System.in);
            String message="";
            while(!message.equalsIgnoreCase("end")) {
                //envoyer une chaine de caractère
                message=sc.nextLine();
                pw.println(message);
                pw.flush();

                //recevoir
                System.out.println("serveur:"+br.readLine());


            }

            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
