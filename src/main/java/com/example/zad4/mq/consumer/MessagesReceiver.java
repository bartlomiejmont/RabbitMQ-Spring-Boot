package com.example.zad4.mq.consumer;

import com.example.zad4.model.Message;
import com.example.zad4.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class MessagesReceiver {

    MessageService messageService;

    @RabbitListener(queues = "firstQueue", containerFactory = "jsaFactory")
    public void handleMessage (Message message){
        messageService.handleMessage(message);
    }

}
