package com.webservice.controller;

import com.webservice.model.Message;
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

    @PostMapping("/allBySenderAndReceiver")
    public ResponseEntity<List<Message>> getAllBySenderAndReceiver(@RequestBody Message message) {
        return new ResponseEntity<>(iMessageService.getAllBySenderAndReceiver(message.getSender(), message.getReceiver()), HttpStatus.OK);
    }

}
