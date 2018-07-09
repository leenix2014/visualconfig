package com.dszy.visualconfig.config;

import com.dszy.visualconfig.ws.LogWebsocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class EndpointConfig {

    @Bean
    public LogWebsocketHandler logWebsocketHandler() {
        return new LogWebsocketHandler();
    }

    @Bean
    public ServerEndpointExporter endpointExporter() {
        return new ServerEndpointExporter();
    }
}
