package net.zerobone.rmibp.shared;

import java.io.File;
import java.io.FileNotFoundException;

public class Utils {

    public static void initializeSecurityManager(String policyPath) throws FileNotFoundException {

        if (System.getSecurityManager() == null) {

            if (new File(policyPath).isFile()) {
                System.setProperty("java.security.policy", policyPath);
                System.setSecurityManager(new SecurityManager());
            }
            else {
                throw new FileNotFoundException("Policy '" + policyPath + "' not found.");
            }

        }

    }

}