package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.MeetingRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomReservationRepository extends JpaRepository<MeetingRoomReservation, Long> {
}
