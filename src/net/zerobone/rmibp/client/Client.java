package net.zerobone.rmibp.client;

import net.zerobone.rmibp.shared.IBoss;
import net.zerobone.rmibp.shared.Utils;

import java.io.FileNotFoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class Client {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Initializing...");

        Utils.initializeSecurityManager("client.policy");

        System.out.println("Security Manager active");

        try {

            Registry registry = LocateRegistry.getRegistry();

            for (String entry : registry.list()) {
                System.out.println("Found registry entry: " + entry);
            }

            IBoss boss = (IBoss)registry.lookup("IBoss");

            while (true) {

                int lvl = boss.getLvl();

                System.out.println("Current level of the boss: " + lvl);

                assert lvl >= 1;

                if (lvl == 1) {
                    System.out.println("Boss killed!");

                    int newLvl = 50 + new Random().nextInt(100);

                    System.out.println("Resetting lvl to " + newLvl);

                    boss.setLvl(newLvl);

                    break;

                }

                if (lvl % 2 == 0) {
                    boss.decreaseLvl(lvl / 2);
                }
                else {
                    boss.increaseLvl(lvl * 2 + 1);
                }

                try {
                    Thread.sleep(500);
                }
                catch (InterruptedException e) {
                    break;
                }

            }

        }
        catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }

    }

}