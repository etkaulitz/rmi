
//responsavel por conversar com o client

package RMI;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;


public class ClienteRMI {
      
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException {
        
        RMIClient cliente=new RMIClient();
        cliente.conectar();
        
        cliente.getMensagemBuffer().incluir(0, "Joao");
        cliente.getMensagemBuffer().incluir(1, "Jose");
        
        cliente.getMensagemBuffer().alterar(0,"Joaquim");
        
        cliente.getMensagemBuffer().excluir(1);
        
        List<String> listagem=cliente.getMensagemBuffer().consultarPorNome("Joaquim");
        
        for(String linha:listagem){
            System.out.println(linha);
        }
    }
}