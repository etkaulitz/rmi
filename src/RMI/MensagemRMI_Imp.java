package RMI;



import java.rmi.RemoteException;


public class MensagemRMI_Imp implements MensagemRMI_Interface {


    
    String mensagem;

    
    protected MensagemRMI_Imp(String mensagem) throws RemoteException{
        super();
    }

    @Override
    public void put_mensagem(String txt) 
    {
        mensagem = txt;
    }
    
    @Override
    public String get_mensagem()
    {
        return mensagem;
    }    
}
