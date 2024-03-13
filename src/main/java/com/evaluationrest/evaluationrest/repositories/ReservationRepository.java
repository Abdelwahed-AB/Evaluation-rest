package com.evaluationrest.evaluationrest.repositories;

import com.evaluationrest.evaluationrest.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("from Reservation r where r.room.id = :roomId and (r.startTime <= :endDate and :startDate <= r.endTime)")
    List<Reservation> getRoomReservationsByInterval(Long roomId, LocalDateTime startDate, LocalDateTime endDate);
}
