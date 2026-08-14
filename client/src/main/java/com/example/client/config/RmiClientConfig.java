package com.example.client.config;

import com.example.interfaces.ICabinet;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;
import java.util.logging.Logger;

@Configuration
public class RmiClientConfig {

    public final Logger logger = Logger.getLogger(this.getClass().getName());

    @Bean
    RmiProxyFactoryBean cabinetProxy() {
        String rmiServerURL = String.format("rmi://localhost:1099/%s", ICabinet.class.getSimpleName());
        logger.info("URL du serveur RMI : " + rmiServerURL);
        RmiProxyFactoryBean proxy = new RmiProxyFactoryBean();
        proxy.setServiceUrl(rmiServerURL);
        proxy.setServiceInterface(ICabinet.class);
        return proxy;
    }
}
