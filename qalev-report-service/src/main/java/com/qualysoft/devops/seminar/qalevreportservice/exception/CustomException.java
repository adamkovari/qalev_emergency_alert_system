package com.qualysoft.devops.seminar.qalevreportservice.exception;

import com.qualysoft.devops.seminar.qalevreportservice.dto.response.Response;
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
}