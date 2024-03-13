package com.evaluationrest.evaluationrest.dto.response;

import java.time.LocalDateTime;

public record ReservationResponse(
        Long id,
        Long meetingRoomId,
        Long userId,
        LocalDateTime startTime,
        LocalDateTime endTime
) {
}
