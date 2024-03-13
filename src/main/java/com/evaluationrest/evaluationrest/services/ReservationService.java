package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.Reservation;
import com.evaluationrest.evaluationrest.exceptions.ReservationNotFoundException;
import com.evaluationrest.evaluationrest.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    private final ReservationRepository ReservationRepository;

    @Override
    public List<Reservation> findAll() {
        return ReservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return ReservationRepository.findById(id).orElseThrow(()->new ReservationNotFoundException(id));
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservation.setId(0L);
        ReservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Long id, Reservation reservation) {
        reservation.setId(id);
        ReservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        Reservation Reservation = findById(id);
        ReservationRepository.delete(Reservation);
    }

    @Override
    public boolean isRoomAvailable(Long roomId, LocalDateTime startDate, LocalDateTime endDate) {
        return false;
    }
}
