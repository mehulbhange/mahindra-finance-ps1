package com.leadservice.leadservice.exceptions;

import com.leadservice.leadservice.entity.ErrorResponse;
import com.leadservice.leadservice.entity.ErrorResponseDetails;
import lombok.Data;

import java.util.Collections;

@Data
public class LeadAlreadyExistsException extends RuntimeException{
    private final ErrorResponse errorResponse;

    public LeadAlreadyExistsException(Integer leadId) {
        super("Lead Already Exists in the database");
        // Create the ErrorResponse object with details
        this.errorResponse = new ErrorResponse(
                "error",
                new ErrorResponseDetails("E10010", Collections.singletonList("Lead Already Exists in the database with the lead id " + leadId))
        );
    }

}
