package com.example.socketintegrationapp.WebSockets;

import com.example.socketintegrationapp.SocketEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@Configuration
public class WebSocketConfiguration {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        ServerEndpointExporter serverEndpointExporter = new ServerEndpointExporter();

        serverEndpointExporter.setAnnotatedEndpointClasses(SocketEndpoint.class);
        return serverEndpointExporter;
    }
}
