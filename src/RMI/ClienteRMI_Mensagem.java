package RMI;



import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;


public class ClienteRMI_Mensagem {
      
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, InterruptedException, IOException {
        
        RMIClient_Mensagem client = new RMIClient_Mensagem();
        client.conectar();
        
        
      //envio da mensagem via rmi

        List<String> buffer = new ArrayList<String>();
        String msg_servidor = "";
        String username = "";
        System.out.println("nome");
        Scanner input_username = new Scanner(new InputStreamReader(System.in, "UTF-8"));
        username = input_username.nextLine();
        System.out.println("mensagem:");
        
        while (true) 
        {
            buffer.add(client.getMensagemBuffer().get_mensagem());
            Thread.sleep(1000);
            buffer.add(client.getMensagemBuffer().get_mensagem());
            if(buffer.get(0) == buffer.get(1))
            {
                buffer.clear();
            }
            else
            {
                msg_servidor = buffer.get(1);
                
                buffer.clear();
            }
           
            Scanner input = new Scanner(new InputStreamReader(System.in, "UTF-8"));
            String texto = input.nextLine();
            client.getMensagemBuffer().put_mensagem(username + ": " + texto);
        }
    }
}