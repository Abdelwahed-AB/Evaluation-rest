package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {
}
