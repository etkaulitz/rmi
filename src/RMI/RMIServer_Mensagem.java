package RMI;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class RMIServer_Mensagem {
    
    MensagemRMI_Imp msgBuffer;

    public RMIServer_Mensagem(MensagemRMI_Imp msgBuffer) throws AlreadyBoundException, MalformedURLException{
        this.msgBuffer=msgBuffer;
        System.setProperty("java.security.policy","file:./politicas.policy");
       
        
        try{
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
               
           MensagemRMI_Interface stub=(MensagemRMI_Interface) UnicastRemoteObject.exportObject(msgBuffer, 0);
           Registry registry=LocateRegistry.createRegistry(5003);
           registry.rebind("MensagemService", stub);
        
        }catch(RemoteException re){
            re.getStackTrace();
        }
    }  
    

}
