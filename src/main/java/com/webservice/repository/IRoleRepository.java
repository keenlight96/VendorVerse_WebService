package com.webservice.repository;

import com.webservice.model.Account;
import com.webservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
