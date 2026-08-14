package com.example.client.config;

import com.example.interfaces.ICabinet;

import com.example.models.AnimalDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import org.springframework.stereotype.Component;

@Component
public class RMIClientApplicationRunner implements ApplicationRunner {
    private final RmiProxyFactoryBean cabinetProxy;

    public RMIClientApplicationRunner(@Qualifier("cabinetProxy") RmiProxyFactoryBean cabinetProxy) {
        this.cabinetProxy = cabinetProxy;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        AnimalExotique tigre = new AnimalExotique("Tigre du Bengale");
        ICabinet cabinetService = (ICabinet) cabinetProxy.getObject();
        AnimalDTO animal = cabinetService.addAnimal("Tigrou", "Alice", "Bengale", tigre);
        System.out.println(" Animal envoyé au serveur !");
        System.out.println(" Envoi de l'animal : " + animal.getNom());
        System.out.println("Espèce : " + animal.getEspece());

    }
}
