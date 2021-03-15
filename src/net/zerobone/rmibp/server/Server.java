package net.zerobone.rmibp.server;

import net.zerobone.rmibp.shared.IBoss;
import net.zerobone.rmibp.shared.Utils;

import java.io.FileNotFoundException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Initializing...");

        Utils.initializeSecurityManager("server.policy");

        System.out.println("Security Manager active");

        try {

            // stubs

            Boss boss = new Boss(80);

            IBoss bossStub = (IBoss)UnicastRemoteObject.exportObject(boss, 0);

            System.out.println("Stubs created");

            Registry registry = LocateRegistry.createRegistry(1099);

            System.out.println("Registry created.");

            // add the stubs to the registry

            registry.bind("IBoss", bossStub);

        }
        catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

        System.out.println("Server started.");

    }

}