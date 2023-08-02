package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubscriberRepository extends JpaRepository<Subscriber, Integer> {
}
