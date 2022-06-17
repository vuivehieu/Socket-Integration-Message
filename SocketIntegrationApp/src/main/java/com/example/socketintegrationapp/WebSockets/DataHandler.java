//package com.example.socketintegrationapp.WebSockets;
//
//import com.example.socketintegrationapp.Configs.HandshakeInterceptor;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.io.IOException;
//import java.util.ArrayList;
//
//@Component
//public class DataHandler extends TextWebSocketHandler {
//    private static final Log logger = LogFactory
//            .getLog(DataHandler.class);
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        super.afterConnectionEstablished(session);
//        System.out.println("Welcome" + session.getId());
//    }
//
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//        super.handleMessage(session, message);
//        logger.info(message.getPayload());
//        TextMessage returnMessage = new TextMessage(message.getPayload() + "return at server");
//        logger.info("Return Message: " + returnMessage.getPayload());
//        session.sendMessage(returnMessage);
//    }
//
//    private static ArrayList<WebSocketSession> sessions;
//
//    public void sendMessageToUser(TextMessage message) {
//        for (WebSocketSession session : sessions) {
//            if (session.getAttributes().get("websockt_deviceId").equals("123")) {
//                try {
//                    if (session.isOpen()) {
//                        session.sendMessage(message);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//        }
//
//    }
//}
