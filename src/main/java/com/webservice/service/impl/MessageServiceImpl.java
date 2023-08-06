package com.webservice.service.impl;

import com.webservice.model.Account;
import com.webservice.model.Message;
import com.webservice.repository.IMessageRepository;
import com.webservice.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    IMessageRepository iMessageRepository;

    @Override
    public List<Message> getAll() {
        return iMessageRepository.findAll();
    }

    @Override
    public Message getById(int id) {
        return iMessageRepository.findById(id).get();
    }

    @Override
    public Message create(Message account) {
        return iMessageRepository.save(account);
    }

    @Override
    public Message edit(Message account) {
        return iMessageRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iMessageRepository.deleteById(id);
    }

    @Override
    public List<Message> getAllBySenderAndReceiver(Account sender, Account receiver) {
        List<Message> messages = iMessageRepository.findAllBySenderAndReceiver(sender.getId(), receiver.getId());
        messages.sort(new Comparator<Message>() {
            @Override
            public int compare(Message o1, Message o2) {
                return o1.getId() - o2.getId();
            }
        });
        return messages;
//        return iMessageRepository.findAll();
    }
}
