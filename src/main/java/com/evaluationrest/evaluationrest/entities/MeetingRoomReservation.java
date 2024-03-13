package com.evaluationrest.evaluationrest.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class MeetingRoomReservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private MeetingRoom room;
}
