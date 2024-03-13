package ServeurMultiThreads;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServeurMT extends Thread {

    public static void main(String[] args) {
        new ServeurMT().start();
    }

    @Override
    public void run() {
        ServerSocket socketserver;
        Socket socketduserveur;

        try {
            socketserver = new ServerSocket(2024);
            System.out.println("Le serveur est à l'écoute du port " + socketserver.getLocalPort());
            while (true) {
                socketduserveur = socketserver.accept();
                System.out.println("client accepté avec l adresse ip");
                System.out.println(socketduserveur.getInetAddress());

                new Conversation(socketduserveur).start();
            }


        } catch (IOException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException(e);
        }

    }

    public class Conversation extends Thread {
        private Socket socket;

        private String name;
        public Conversation(Socket socket) {
            this.socket = socket;
        }
        //methode run qui contient les input et output stream
        public void run () {

            try {
                OutputStream os= socket.getOutputStream();
                InputStream is=socket.getInputStream();
                InputStreamReader istrm= new InputStreamReader(is);
                OutputStreamWriter outsw= new OutputStreamWriter(os);
                //Un BufferedReader permet de lire par ligne.
                BufferedReader bfreader = new BufferedReader(istrm);
                BufferedWriter bfrwriter= new BufferedWriter(outsw);

                PrintWriter pw = new PrintWriter(bfrwriter,true);
                Scanner sc = new Scanner(System.in);
                String messageClient;
                String messageServeur;

                this.name = bfreader.readLine();

                while (true) {
                    //Je reçois le message du client
                    messageClient = bfreader.readLine();
                    //lecture du message
                    System.out.println(name+": " + messageClient); // trace locale

                    //Teste
                    if (messageClient.equals("END")){
                    pw.println("vous etes déconnecté"); break;}
                    //J'envoie un message au client
                    System.out.println("Envoyer un message au client "); // trace locale
                    messageServeur = sc.nextLine();
                    pw.println(messageServeur); // renvoi d'un écho

                }

                pw.close();
                bfreader.close();//pred.close();
                socket.close();

            }

            catch (IOException e) {
                throw new RuntimeException(e);
            }


        }



    }
}