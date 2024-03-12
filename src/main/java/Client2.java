import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",1234);
            BufferedReader br = new BufferedReader(new InputStreamReader());
            PrintWriter pw = new PrintWriter(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            //scanner.nextLine est une methode bloquante
            String message = sc.nextLine();
            pw.println(message);
            pw.flush();

            while (!message.equalsIgnoreCase("end")){
                System.out.println("Serveur :" +br.readLine());
                pw.println("echo");
                pw.flush();
            }




        }

         catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);


    }
}
