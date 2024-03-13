package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {
}
