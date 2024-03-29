package com.evaluationrest.evaluationrest.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity @Table(name="user_table")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
}
