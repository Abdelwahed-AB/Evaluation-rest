package com.evaluationrest.evaluationrest.mappers;

import com.evaluationrest.evaluationrest.dto.request.ReservationRequest;
import com.evaluationrest.evaluationrest.dto.response.ReservationResponse;
import com.evaluationrest.evaluationrest.entities.Reservation;

public interface IReservationMapper {
    Reservation reservationRequestToReservation(ReservationRequest reservationRequest);
    ReservationResponse reservationToReservationResponse(Reservation reservation);
}
