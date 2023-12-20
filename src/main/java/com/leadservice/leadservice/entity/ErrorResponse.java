package com.leadservice.leadservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String status;
    private ErrorResponseDetails errorResponse;

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status='" + status + '\'' +
                ", errorResponse=" + errorResponse +
                '}';
    }
}

