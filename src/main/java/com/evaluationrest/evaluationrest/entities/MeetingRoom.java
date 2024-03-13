package com.evaluationrest.evaluationrest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MeetingRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
}