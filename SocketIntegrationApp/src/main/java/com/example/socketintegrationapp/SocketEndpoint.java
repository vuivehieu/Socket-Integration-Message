package com.example.socketintegrationapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint(value = "/chat/{key}")
public class SocketEndpoint {
    private static final Logger LOGGER = LoggerFactory.getLogger(SocketEndpoint.class);
    private Map<String,List<Session>> sessions = new HashMap<>();
    private Session Ssession;

    private List<Session> sessionList;

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("key") String key){
        if(Ssession==null){
            Ssession = session;
        }
        LOGGER.info("Message received from session ID: {}, message {}, key {}",session.getId(),message,key);
        for (Session s:sessions.get(key)) {
            if(s!=session && s.isOpen()){
                Ssession.getAsyncRemote().sendText(message);
            }
        }
        sessions.get(key).parallelStream().forEach(session1 -> {
            if (session == session1){
                return;
            }
            session1.getAsyncRemote().sendText(message);
        });
        this.send(message,key);
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("key") String key){
        LOGGER.info("Session opened ID: {}, key {}", session.getId(), key);
        sessions.computeIfAbsent(key, k -> new ArrayList<>());
        if(sessions.get(key)!=null){
            if(sessionList!=null){
            sessionList = sessions.get(key);
                sessionList.add(session);
            }
            else{
                sessionList = new ArrayList<>();
                sessionList.add(session);
            }
        }
        sessions.put(key,sessionList);
        System.out.println("session = "+ sessionList.size());
    }

    @OnClose
    public void onClose(Session session, @PathParam("key") String key) {
        LOGGER.info("Session closed ID: {}, key {}", session.getId(), key);
        sessions.get(key).remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable, @PathParam("key") String key) {
        LOGGER.error("Session error. Removing session ID: {}, key {}", session.getId(),key, throwable);
        sessions.get(key).remove(session);
        try {
            session.close();
        } catch (IOException ex) {
            LOGGER.warn("Error closing session ID: {}, key {}", session.getId(), key);
        }
    }

    public void send(String message, String key){
        if(!sessions.containsKey(key)){
            LOGGER.warn("Key {} not found!!", key);
            return;
        }
        sessions.get("key").parallelStream().forEach(session -> {
            session.getAsyncRemote().sendText(message);
        });
    }

    public List<String> getKeys(){
        return new ArrayList<>(sessions.keySet());
    }




}
