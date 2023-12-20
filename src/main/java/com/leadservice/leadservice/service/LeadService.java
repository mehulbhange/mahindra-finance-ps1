package com.leadservice.leadservice.service;

import com.leadservice.leadservice.entity.Lead;
import com.leadservice.leadservice.entity.LeadsResponse;
import com.leadservice.leadservice.entity.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LeadService {
    ResponseEntity<SuccessResponse> createLead(Lead lead);
    ResponseEntity<LeadsResponse> getLeadsByMobileNumber(String mobileNumber);
}
