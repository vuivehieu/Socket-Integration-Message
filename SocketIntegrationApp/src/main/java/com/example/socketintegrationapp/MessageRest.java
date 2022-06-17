package com.example.socketintegrationapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;


@RequestMapping("/hehe")
@RequestScope
public class MessageRest {
    @Autowired
    SocketEndpoint socketEndpoint;

    @PostMapping("/send")
    public void sendMessage(@RequestParam("key") String key, @RequestParam("message") String message){
        socketEndpoint.send(message,key);
    }

    @GetMapping("/keys")
    public String keys() {
        return socketEndpoint.getKeys().toString();
    }
}
