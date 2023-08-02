package com.webservice.service.impl;

import com.webservice.model.Subscriber;
import com.webservice.repository.ISubscriberRepository;
import com.webservice.service.ISubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImpl implements ISubscriberService {
    @Autowired
    ISubscriberRepository iSubscriberRepository;

    @Override
    public List<Subscriber> getAll() {
        return iSubscriberRepository.findAll();
    }

    @Override
    public Subscriber getById(int id) {
        return iSubscriberRepository.findById(id).get();
    }

    @Override
    public Subscriber create(Subscriber account) {
        return iSubscriberRepository.save(account);
    }

    @Override
    public Subscriber edit(Subscriber account) {
        return iSubscriberRepository.save(account);
    }

    @Override
    public void deleteById(int id) {
        iSubscriberRepository.deleteById(id);
    }
}
