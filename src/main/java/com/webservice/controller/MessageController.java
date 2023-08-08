package com.webservice.controller;

import com.webservice.model.Message;
import com.webservice.service.IAccountService;
import com.webservice.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    IMessageService iMessageService;
    @Autowired
    IAccountService iAccountService;

    @PostMapping("/allBySenderAndReceiver")
    public ResponseEntity<List<Message>> getAllBySenderAndReceiver(@RequestBody Message message) {
        return new ResponseEntity<>(iMessageService.getAllBySenderAndReceiver(message.getSender(), message.getReceiver()), HttpStatus.OK);
    }

    @PostMapping("/hi/{senderId}/{receiverId}")
    public ResponseEntity<String> hiMessage(@PathVariable int senderId, @PathVariable int receiverId) {
        Message message = new Message();
        message.setSender(iAccountService.getById(senderId));
        message.setReceiver(iAccountService.getById(receiverId));
        message.setMessage("Hi");

        iMessageService.create(message);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
