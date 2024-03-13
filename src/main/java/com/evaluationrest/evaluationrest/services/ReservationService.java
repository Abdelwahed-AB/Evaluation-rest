package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.Reservation;
import com.evaluationrest.evaluationrest.exceptions.InvalidDateIntervalException;
import com.evaluationrest.evaluationrest.exceptions.MeetingRoomUnavailableException;
import com.evaluationrest.evaluationrest.exceptions.ReservationNotFoundException;
import com.evaluationrest.evaluationrest.repositories.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    private final IMeetingRoomService meetingRoomService;
    private final IUserService userService;

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElseThrow(()->new ReservationNotFoundException(id));
    }

    @Override
    public void createReservation(Reservation reservation) {
        reservation.setId(0L);
        //check if room & user exist
        userService.findById(reservation.getUser().getId());
        meetingRoomService.findById(reservation.getRoom().getId());

        LocalDateTime start = reservation.getStartTime();
        LocalDateTime end = reservation.getEndTime();
        if(start.isAfter(end)){
            throw new InvalidDateIntervalException(start, end);
        }

        if(!isRoomAvailable(reservation.getRoom().getId(), start, end)) {
            throw new MeetingRoomUnavailableException(reservation.getRoom().getId(), start, end);
        }
        reservationRepository.save(reservation);
    }

    @Override
    public void updateReservation(Long id, Reservation reservation) {
        reservation.setId(id);
        reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservationById(Long id) {
        Reservation Reservation = findById(id);
        reservationRepository.delete(Reservation);
    }

    @Override
    public boolean isRoomAvailable(Long roomId, LocalDateTime startDate, LocalDateTime endDate) {
        List<Reservation> roomReservationsByInterval = reservationRepository.getRoomReservationsByInterval(roomId, startDate, endDate);
        return roomReservationsByInterval.isEmpty();
    }
}
