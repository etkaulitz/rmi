package RMI;


import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

//servidor padrao que faz a conexao tem o cliente e servidor

public class RMIServer {
    
    DAORMIClient msgBuffer;

    public RMIServer(DAORMIClient msgBuffer) throws AlreadyBoundException, MalformedURLException{
        this.msgBuffer=msgBuffer;
        System.setProperty("java.security.policy","file:./politicas.policy");
       
        
        try{
           System.setProperty("java.rmi.server.hostname", "127.0.0.1");
          
           DAORMIClientInterface stub=(DAORMIClientInterface) UnicastRemoteObject.exportObject(msgBuffer, 0);
           Registry registry=LocateRegistry.createRegistry(5003);
           registry.rebind("MensagemService", stub);
           System.out.println("funcionou");
        }catch(RemoteException re){
            re.getStackTrace();
        }
    }  
    

}