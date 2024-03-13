package ServeurMultiThreads.Principe;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadClass extends Thread {
    //Les attributs de la classe
//Le constructeur de la classe
//Les méthodes de la classe

    @Override
    //methode run qui est responsable de l'acceptage
    public void run(){
        try {
            ServerSocket ss=new ServerSocket(7777);
            while(true){
                //accepter et attendre de nouveau une nouvelle connexion
                Socket socket=ss.accept();
                ////Affecter un thread qui s'occupe à communiquer avec le client
                new Conversation(socket).start();


            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args){
        // creer des objets de notre class et lancer thread principal par la methode start()
        //start() basé sur la methode run() elle execute run()
        //donc on creer les threads et on faire appel au methode start()
        ThreadClass t1= new ThreadClass();
        ThreadClass t2= new ThreadClass();
        t1.start(); t2.start();
    }
    public class Conversation extends Thread {
        Socket socket;

        public Conversation(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while(true){
                //input et output Streams
            }


        }
    }
}
