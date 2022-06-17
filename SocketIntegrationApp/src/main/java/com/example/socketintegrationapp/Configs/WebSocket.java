//package com.example.socketintegrationapp.Configs;
//
//import com.example.socketintegrationapp.WebSockets.DataHandler;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.*;
//
//@Configuration
//@EnableWebSocket
//public class WebSocket implements WebSocketConfigurer {
//    @Autowired
//    DataHandler dataHandler;
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(dataHandler,"/data");
//    }
//
//
//}
