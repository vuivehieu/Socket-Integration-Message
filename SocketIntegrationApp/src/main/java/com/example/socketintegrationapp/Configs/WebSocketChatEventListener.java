//package com.example.socketintegrationapp.Configs;
//
//import com.example.socketintegrationapp.MessageEntity;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//@Component
//public class WebSocketChatEventListener {
//
//    @Autowired
//    private SimpMessageSendingOperations messageTemplate;
//
//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event){
//        System.out.println("Receive a new web socket connection");
//    }
//
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event){
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//
//        Long id = (Long) headerAccessor.getSessionAttributes().get("id");
//        if(id!= null){
//            MessageEntity message = new MessageEntity();
//            message.setMessageContent("Leave");
//            message.setSender(id);
//            messageTemplate.convertAndSend("/topic/public", message);
//        }
//
//    }
//}
