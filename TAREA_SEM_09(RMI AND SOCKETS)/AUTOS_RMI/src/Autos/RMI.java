package Autos;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI extends Remote{
    public int ejecutar() throws RemoteException;
}
