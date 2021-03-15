package net.zerobone.rmibp.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IBoss extends Remote {

    int getLvl() throws RemoteException;

    void setLvl(int lvl) throws RemoteException;

    void increaseLvl(int diff) throws RemoteException;

    void decreaseLvl(int diff) throws RemoteException;

}