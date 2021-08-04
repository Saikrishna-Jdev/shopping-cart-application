package com.sca.webapp.entity;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;

    @Column(name="user_name")
    private String name;

    @Column(name = "user_email")
    private String email;

    @Column(length = 128)
    private String password;




}
