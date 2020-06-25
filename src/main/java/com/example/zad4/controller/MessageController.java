package com.example.zad4.controller;

import com.example.zad4.model.Message;
import com.example.zad4.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Message>> getAll() {
        List<Message> messages = messageService.getAll();
        return ResponseEntity.ok().body(messages);
    }

}
