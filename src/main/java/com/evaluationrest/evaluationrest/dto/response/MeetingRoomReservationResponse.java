package com.evaluationrest.evaluationrest.dto.response;

import java.time.LocalDateTime;

public record MeetingRoomReservationResponse(
        Long id,
        Long meetingRoomId,
        Long userId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
