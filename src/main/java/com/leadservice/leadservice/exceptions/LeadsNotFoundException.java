package com.leadservice.leadservice.exceptions;

import com.leadservice.leadservice.entity.ErrorResponse;
import com.leadservice.leadservice.entity.ErrorResponseDetails;
import lombok.Data;

import java.util.Collections;

@Data
public class LeadsNotFoundException extends RuntimeException{

    private final ErrorResponse errorResponse;

    public LeadsNotFoundException(String mobileNumber) {
        super("No Lead found with the mobile number");
        // Create the ErrorResponse object with details
        this.errorResponse = new ErrorResponse(
                "error",
                new ErrorResponseDetails("E10011", Collections.singletonList("No Lead found with the mobile number "+ mobileNumber))
        );
    }

}
