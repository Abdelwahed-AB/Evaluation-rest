package com.evaluationrest.evaluationrest.exceptions;

public class MeetingRoomReservationNotFoundException extends RuntimeException{
    public MeetingRoomReservationNotFoundException(Long id) {
        super("MeetingRoomReservation with id :[ "+id+" ] not found.");
    }
}
