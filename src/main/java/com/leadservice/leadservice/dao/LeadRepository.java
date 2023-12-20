package com.leadservice.leadservice.dao;

import com.leadservice.leadservice.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeadRepository extends JpaRepository<Lead, Integer> {
    Optional<List<Lead>> findByMobileNumber(String mobileNumber);

}
