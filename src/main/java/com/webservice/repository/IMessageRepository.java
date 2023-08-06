package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface IMessageRepository extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where ((m.sender.id = :senderId and m.receiver.id = :receiverId) or (m.sender.id = :receiverId and m.receiver.id = :senderId))")
    List<Message> findAllBySenderAndReceiver(@Param("senderId") int senderId, @Param("receiverId") int receiverId);
}
