package com.webservice.repository;

import com.webservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {
    Account findByUsername(String username);
    @Query(nativeQuery = true, value = "SELECT * FROM Account where username= :username and password= :password")
    Account getAccountLogin(@Param("username") String username, @Param("password") String password);

    @Query(nativeQuery = true, value = "select ac.* from Account ac join (" +
            "select m.sender_id as accId from Message m where m.receiver_id = :userId union select" +
            " m.receiver_id as accId from Message m where m.sender_id = :userId" +
            ") as acc on ac.id = acc.accId")
    List<Account> getReceiversOfAccountId(@Param("userId") int accountId);
}
