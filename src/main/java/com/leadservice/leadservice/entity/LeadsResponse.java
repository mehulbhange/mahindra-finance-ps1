package com.leadservice.leadservice.entity;

import lombok.Data;

import java.util.List;

@Data
public class LeadsResponse {
    private String status;
    private List<Lead> data;

    public LeadsResponse(List<Lead> data){
        this.status = "success";
        this.data = data;
    }

}
