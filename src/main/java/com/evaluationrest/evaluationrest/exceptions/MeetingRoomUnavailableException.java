package com.evaluationrest.evaluationrest.exceptions;

import java.time.LocalDateTime;

public class MeetingRoomUnavailableException extends RuntimeException{
    public MeetingRoomUnavailableException(Long roomId, LocalDateTime start, LocalDateTime end) {
        super("Room with id[ "+roomId+" ] is unavailable at interval: start[ "+start+" ] end[ " + end + " ].");
    }
}
