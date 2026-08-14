package com.example.client;

import com.example.interfaces.IAnimal;
import com.example.interfaces.ICabinet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import javax.swing.*;


@SpringBootApplication(scanBasePackages = {
        "com.example.client.config",
})
public class ClientApplication {

    public static void main(String[] args) {

       ConfigurableApplicationContext context = SpringApplication.run(ClientApplication.class, args);
        ICabinet cabinetService = context.getBean(ICabinet.class);
        javax.swing.SwingUtilities.invokeLater(() -> {
            Cabinet cabinet = new Cabinet(cabinetService);
            cabinet.setVisible(true);
        });
    }
}


