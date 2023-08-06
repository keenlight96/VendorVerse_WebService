package com.webservice.service;

import com.webservice.model.Account;
import com.webservice.model.Message;

import java.util.List;

public interface IMessageService extends ICrudService<Message> {
    public List<Message> getAllBySenderAndReceiver(Account sender, Account receiver);
}
