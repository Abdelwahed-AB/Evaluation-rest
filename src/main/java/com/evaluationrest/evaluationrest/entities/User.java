package com.evaluationrest.evaluationrest.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user_table")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
}
