package org.example.animaltalk.controller;

import ch.qos.logback.core.model.Model;
import org.example.animaltalk.entity.Message;
import org.example.animaltalk.repository.MessageRepository;
import org.example.animaltalk.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // 전체 조회
    @GetMapping
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    // 저장
    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.save(message);
    }

    //삭제
    @DeleteMapping("/{id}")
    public void deleteMessage(@PathVariable long id){
        messageService.deleteMessage(id);
    }

    //수정
    @PutMapping("/{id}")
    public Message updateMessage(@PathVariable long id, @RequestBody Message message) {
        return messageService.updateMessage(id, message);
    }
}
