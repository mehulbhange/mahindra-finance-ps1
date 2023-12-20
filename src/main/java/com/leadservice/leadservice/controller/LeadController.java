package com.leadservice.leadservice.controller;

import com.leadservice.leadservice.entity.ErrorResponse;
import com.leadservice.leadservice.entity.ErrorResponseDetails;
import com.leadservice.leadservice.entity.Lead;
import com.leadservice.leadservice.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping("/lead")
    public ResponseEntity<?> createLead(@Valid @RequestBody Lead lead, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            // Extract validation errors and create a custom error response
            List<String> errors = bindingResult.getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.toList());
            ErrorResponse errorResponse = new ErrorResponse("error", new ErrorResponseDetails("E10010", errors));
            return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
        }
        return leadService.createLead(lead);
    }

    @GetMapping("/lead/{mobileNumber}")
    public ResponseEntity<?> getLeadsByMobileNumber(@PathVariable String mobileNumber) {
        return leadService.getLeadsByMobileNumber(mobileNumber);
    }
}
