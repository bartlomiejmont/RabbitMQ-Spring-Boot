package com.example.zad4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MessageDto {
    private String subject;
    private String addressee;
    private String content;
}
