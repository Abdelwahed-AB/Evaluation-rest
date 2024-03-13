package com.evaluationrest.evaluationrest.exceptions;

import java.time.LocalDateTime;

public class InvalidDateIntervalException extends RuntimeException{
    public InvalidDateIntervalException(LocalDateTime start, LocalDateTime end) {
        super("Invalid date interval: start[ "+ start + " ] end[ "+ end + " ].");
    }
}
