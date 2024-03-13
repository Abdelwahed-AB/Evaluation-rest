package com.evaluationrest.evaluationrest.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotNull(message = "Username must be provided")
        @Size(min = 6, message = "Username length must be greater than 5")
        String username
) {
}
