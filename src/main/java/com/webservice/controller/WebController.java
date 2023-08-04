package com.webservice.controller;

import com.webservice.model.Account;
import com.webservice.model.Hello;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WebController {
    @MessageMapping("/hello")
    @SendTo("/topic/hi")
    public Hello greeting(Account account) throws Exception {
        return new Hello("Hi, " + account.getUsername() + "!");
    }
}
