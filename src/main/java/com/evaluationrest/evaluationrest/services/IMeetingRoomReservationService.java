package com.evaluationrest.evaluationrest.services;

import com.evaluationrest.evaluationrest.entities.MeetingRoomReservation;

import java.util.List;

public interface IMeetingRoomReservationService {
    List<MeetingRoomReservation> findAll();
    MeetingRoomReservation findById(Long id);
    void createMeetingRoomReservation(MeetingRoomReservation MeetingRoomReservation);
    void updateMeetingRoomReservation(Long id, MeetingRoomReservation MeetingRoomReservation);
    void deleteMeetingRoomReservationById(Long id);
}
