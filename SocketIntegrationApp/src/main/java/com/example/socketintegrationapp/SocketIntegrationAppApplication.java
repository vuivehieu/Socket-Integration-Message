package com.example.socketintegrationapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SocketIntegrationAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SocketIntegrationAppApplication.class, args);
    }

}
