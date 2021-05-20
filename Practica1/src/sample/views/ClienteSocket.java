package sample.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClienteSocket {

    private Socket client;
    private InetAddress host;

    public void connectToServer(){
        try {

            host = InetAddress.getLocalHost();
            client = new Socket(host, 5000);

            BufferedReader entrada = new BufferedReader(new InputStreamReader(client.getInputStream()));
            System.out.println(entrada.readLine());
            PrintStream salida = new PrintStream(client.getOutputStream());
            salida.println("Hello Boysss ♥:");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
