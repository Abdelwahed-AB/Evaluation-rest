package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.MeetingRoomReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomReservationRepository extends JpaRepository<MeetingRoomReservation, Long> {
}
