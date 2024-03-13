package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.MeetingRoomReservation;
import com.evaluationrest.evaluationrest.exceptions.MeetingRoomReservationNotFoundException;
import com.evaluationrest.evaluationrest.repositories.MeetingRoomReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingRoomReservationService implements IMeetingRoomReservationService{
    private final MeetingRoomReservationRepository MeetingRoomReservationRepository;

    @Override
    public List<MeetingRoomReservation> findAll() {
        return MeetingRoomReservationRepository.findAll();
    }

    @Override
    public MeetingRoomReservation findById(Long id) {
        return MeetingRoomReservationRepository.findById(id).orElseThrow(()->new MeetingRoomReservationNotFoundException(id));
    }

    @Override
    public void createMeetingRoomReservation(MeetingRoomReservation reservation) {
        reservation.setId(0L);
        MeetingRoomReservationRepository.save(reservation);
    }

    @Override
    public void updateMeetingRoomReservation(Long id, MeetingRoomReservation reservation) {
        reservation.setId(id);
        MeetingRoomReservationRepository.save(reservation);
    }

    @Override
    public void deleteMeetingRoomReservationById(Long id) {
        MeetingRoomReservation MeetingRoomReservation = findById(id);
        MeetingRoomReservationRepository.delete(MeetingRoomReservation);
    }
}
