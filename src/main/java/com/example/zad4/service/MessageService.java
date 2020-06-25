package com.example.zad4.service;

import com.example.zad4.model.Message;
import com.example.zad4.model.MessageDto;
import com.example.zad4.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Service
public class MessageService {

    MessageRepository messageRepository;

    final String uri = "https://{key}.api.mailchimp.com/3.0/";
    final String key = "ac2b9948ee9be5425bf9ac98d0ff5ac1-us10";

    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    public void handleMessage(Message message){

        Map<String, String> params = new HashMap<String, String>();
        params.put("key", key);

        MessageDto messageDto = new MessageDto(message.getSubject(), message.getAddressee(), message.getContent());

        RestTemplate restTemplate = new RestTemplate();
//        MessageDto result =  restTemplate.postForObject ( uri, messageDto, MessageDto.class, params);

        System.out.println("handling message...");
        messageRepository.save(message);
    }
}
