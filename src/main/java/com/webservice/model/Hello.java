package com.webservice.model;

import com.webservice.model.Message;

public class Hello {
    private Message greeting;
    public Hello(Message greeting) {
        this.greeting = greeting;
    }

    public void setGreeting(Message greeting) {
        this.greeting = greeting;
    }

    public Message getGreeting() {
        return this.greeting;
    }
}
