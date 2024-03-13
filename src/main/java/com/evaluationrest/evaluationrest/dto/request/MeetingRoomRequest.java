package com.evaluationrest.evaluationrest.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MeetingRoomRequest(
        @NotNull(message = "Label must be provided")
        @Size(min = 3, message = "Label length must be greater than 3")
        String label
) {
}
