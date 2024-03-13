package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

    @Query("from MeetingRoom room where room not in (select r.room from Reservation r where r.startTime <= :end and :start <= r.endTime)")
    List<MeetingRoom> getAvailableRooms(LocalDateTime start, LocalDateTime end);
}
