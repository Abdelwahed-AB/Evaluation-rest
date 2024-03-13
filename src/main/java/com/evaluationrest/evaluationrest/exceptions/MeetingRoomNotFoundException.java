package com.evaluationrest.evaluationrest.exceptions;

public class MeetingRoomNotFoundException extends RuntimeException{
    public MeetingRoomNotFoundException(Long id) {
        super("MeetingRoom with id :[ "+id+" ] not found.");
    }
}
