package com.example.serveur.config;
import com.example.interfaces.ICabinet;
import com.example.serveur.Impl.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
public class RMIServerApplicationRunner implements ApplicationRunner {

    private final IcabinetImpl cabinetService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    public RMIServerApplicationRunner(IcabinetImpl cabinetService) {
        this.cabinetService = cabinetService;
    }

    @Override
    public void run(ApplicationArguments args) {
    }

    @Bean
    public RmiServiceExporter cabinetExporter(ICabinet cabinetService) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(cabinetService);
        exporter.setServiceInterface(ICabinet.class);
        exporter.setServiceName(ICabinet.class.getSimpleName());
        exporter.setRegistryPort(1099);
        logger.info("Service RMI Cabinet démarré sur le port 1099");
        return exporter;
    }
}
