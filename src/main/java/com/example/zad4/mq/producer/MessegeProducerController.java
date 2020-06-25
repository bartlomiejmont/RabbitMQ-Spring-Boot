package com.example.zad4.mq.producer;

import com.example.zad4.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessegeProducerController {

    private AmqpTemplate rabbitTemplate;



    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message){
        rabbitTemplate.convertAndSend("firstExchange","key.1",message);
        return message;
    }

}
