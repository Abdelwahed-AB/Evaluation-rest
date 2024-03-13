package com.evaluationrest.evaluationrest.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AvailableMeetingRoomsRequest(
        @NotNull(message = "Start time is required")
        @FutureOrPresent(message = "Start time must be now or in the future")
        LocalDateTime start,
        @NotNull(message = "End time is required")
        @Future(message = "End time must be in the future")
        LocalDateTime end
) {
}
