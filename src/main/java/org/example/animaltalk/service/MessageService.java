package org.example.animaltalk.service;

import org.example.animaltalk.entity.Message;
import org.example.animaltalk.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository){
        this.messageRepository=messageRepository;
    }

    //저장
    public Message save(Message message){
        return messageRepository.save(message);
    }

    //전체 조회
    public List<Message> getMessages(){
        return messageRepository.findAll();
    }

    //삭제
    public void deleteMessage(Long id){
        messageRepository.deleteById(id);
    }

    //수정
    public Message updateMessage(Long id, Message updateMessage){
        Message message= messageRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("메세지 없음"));

        message.setMessage(updateMessage.getMessage());
        return messageRepository.save(message);
    }
}
