package com.leadservice.leadservice.service;

import com.leadservice.leadservice.dao.LeadRepository;
import com.leadservice.leadservice.entity.Lead;
import com.leadservice.leadservice.entity.LeadsResponse;
import com.leadservice.leadservice.entity.SuccessResponse;
import com.leadservice.leadservice.exceptions.LeadAlreadyExistsException;
import com.leadservice.leadservice.exceptions.LeadsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LeadServiceImpl implements LeadService{
    @Autowired
    private LeadRepository leadRepo;

    @Override
    public ResponseEntity<SuccessResponse> createLead(Lead lead) {
        Optional<Lead> existing = leadRepo.findById(lead.getLeadId());
        if (existing.isPresent()){
            throw new LeadAlreadyExistsException(lead.getLeadId());
        }
        leadRepo.save(lead);
        return ResponseEntity.ok(new SuccessResponse());
    }

    @Override
    public ResponseEntity<LeadsResponse> getLeadsByMobileNumber(String mobileNumber) {
        Optional<List<Lead>> leads = leadRepo.findByMobileNumber(mobileNumber);
        if (!leads.get().isEmpty() ) {
            return new ResponseEntity<>(new LeadsResponse(leads.get()),HttpStatus.OK);
        }
        else
            throw new LeadsNotFoundException(mobileNumber);
    }

}
