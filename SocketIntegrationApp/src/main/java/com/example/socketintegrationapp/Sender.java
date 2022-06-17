package com.example.socketintegrationapp;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@Profile("Sender")
public class Sender {
    static Logger logger
            = LoggerFactory.getLogger(Receiver.class);

    public static void main(String[] args) throws IOException, TimeoutException {


    }
    public static void sendMessage(MessageEntity message, String QUEUE_NAME) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicPublish("",QUEUE_NAME,null,message.getMessageContent().getBytes(StandardCharsets.UTF_8));
        logger.debug("[!] Sent '" +message.getMessageContent()+ "'");
        channel.close();
        connection.close();
    }
}
