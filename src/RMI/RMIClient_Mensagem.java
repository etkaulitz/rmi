package RMI;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class RMIClient_Mensagem {
    static MensagemRMI_Interface mensagem;
    
    public void conectar() throws NotBoundException, MalformedURLException, RemoteException{
        
        System.setProperty("java.security.policy","file:./politicas.policy");
     
        
        Registry registry =LocateRegistry.getRegistry("127.0.0.1", 5003);
        mensagem=(MensagemRMI_Interface) registry.lookup("MensagemService");
        
       
    }   
    
    public MensagemRMI_Interface getMensagemBuffer(){
        return mensagem;
    }
}