package com.qualysoft.devops.seminar.qalevackservice.exception;

import com.qualysoft.devops.seminar.qalevackservice.dto.response.Response;
import org.springframework.stereotype.Component;

@Component
public class CustomException {

    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException() {
            super(Response.Status.NOT_FOUND.name());
        }
    }

    public static class DuplicateEntityException extends RuntimeException {
        public DuplicateEntityException() {
            super(Response.Status.DUPLICATE_ENTITY.name());
        }
    }

    public static class BadRequestException extends RuntimeException {

        public BadRequestException() {
            super(Response.Status.BAD_REQUEST.name());
        }
    }

    public static class Exception extends RuntimeException {

        public Exception() {
            super(Response.Status.EXCEPTION.name());
        }

        public Exception(String message) {
            super(message);
        }
    }
}