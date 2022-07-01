package com.custom.marketPlace.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {

    private final String errorCode;
    private String message;

    public void setParams(Object...params) {
        message = String.format(message, params);
    }

    public String get() {
        return String.format("%s: %s", errorCode, message);
    }
}
