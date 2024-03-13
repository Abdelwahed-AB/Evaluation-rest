package com.evaluationrest.evaluationrest.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record MeetingRoomReservationRequest(
        @NotNull(message = "User id is required")
        Long userId,
        @NotNull(message = "Meeting room id is required")
        Long meetingRoomId,
        @NotNull(message = "Reservation start time is required")
        @FutureOrPresent(message = "Reservation start time must be now or in the future")
        LocalDateTime startTime,
        @NotNull(message = "Reservation end time is required")
        @Future(message = "Reservation end time must be in the future")
        LocalDateTime endTime
) {
}
