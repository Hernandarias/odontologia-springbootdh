package com.dhbackend.odontologia_integradorfinal.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends Exception {

    private Object resourceId;

    public ResourceNotFoundException() {
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Object resourceI) {
        super(message);
        this.resourceId = resourceId;
    }

    public Object getResourceId() {
        return resourceId;
    }
}
