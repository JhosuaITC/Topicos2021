package sample;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;

public class ServiddorrSocket {
    private ServerSocket servidor;
    private Socket client;

    public void startServer(){
       int cont = 0;
        try {
            servidor = new ServerSocket(5000);
            System.out.println("Server Start..♥.♥.♥.♥. ");
            //int cont = 0;
            while (true){
                client = servidor.accept();
                cont ++;
                System.out.println("Llega el cliente :" + cont);

                PrintStream escritura= new PrintStream(client.getOutputStream());
                escritura.println("Sean Bienvenidos ♥_♥ usted es el cliente " + cont + ":");

                BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
                System.out.println(entrada.readLine());

                client.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
