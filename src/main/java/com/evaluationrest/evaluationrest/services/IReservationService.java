package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.Reservation;

import java.util.List;

public interface IReservationService {
    List<Reservation> findAll();
    Reservation findById(Long id);
    void createReservation(Reservation Reservation);
    void updateReservation(Long id, Reservation Reservation);
    void deleteReservationById(Long id);

}
