package com.webservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String avatar;
    private Date birthday;
    private String phoneNumber;
    @ManyToOne
    private Role role;
    @ManyToOne
    private AccountStatus status;


}
