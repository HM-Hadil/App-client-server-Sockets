import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {

    public static void main(String[] args) {
        ServerSocket ss;

        try{
            ss=new ServerSocket(23);
            System.out.println("j'attend une demande de connexion");
            Socket s= ss.accept();
            System.out.println("client accepté avec les informaton");

            BufferedReader br = new BufferedReader(new InputStreamReader(
            PrintWriter pw = new PrintWriter(s.getOutputStream)
            ));
            while (true){
                System.out.println("Client",);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
