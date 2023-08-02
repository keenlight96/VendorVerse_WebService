package com.webservice.repository;

import com.webservice.model.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountStatusRepository extends JpaRepository<AccountStatus, Integer> {
}
