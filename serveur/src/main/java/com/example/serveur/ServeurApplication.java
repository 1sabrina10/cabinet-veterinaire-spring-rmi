package com.example.serveur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Logger;

@SpringBootApplication(scanBasePackages = {
        "com.example.serveur.config",
        "com.example.serveur.Impl"
})
public class ServeurApplication {
    private static Logger logger = Logger.getLogger(ServeurApplication.class.getSimpleName());

    public static void main(String[] args) throws Exception {


       System.setProperty("java.rmi.server.codebase","file:/home/user/Téléchargements/client/target/classes/");

        System.setProperty("java.security.policy", "file:/home/user/Téléchargements/serveur/src/main/resources/security.policy");

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        LocateRegistry.createRegistry(1099);
        SpringApplication.run(ServeurApplication.class, args);
        logger.info(" RMI Registry lancé sur le port 1099");
    }
}



