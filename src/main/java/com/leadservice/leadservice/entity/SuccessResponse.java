package com.leadservice.leadservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class SuccessResponse {

    private String status;
    private String data;

    public SuccessResponse(){
        this.status = "success";
        this.data = "Created Leads Successfully";
    }

}
