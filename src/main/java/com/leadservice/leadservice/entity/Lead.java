package com.leadservice.leadservice.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lead {

    @Id
    @Column(nullable = false, unique = true)
    private Integer leadId;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name should contain alphabets only and not null")
    private String firstName;

    @Column
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Middle name should contain alphabets only")
    private String middleName;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name should contain alphabets only and not null")
    private String lastName;

    @Column(nullable = false)
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number should be exact 10 digits and valid")
    private String mobileNumber;

    @Column(nullable = false)
    @Pattern(regexp = "^(Male|Female|Others)$", message = "Gender must be Male, Female, or Others")
    private String gender;


    @Column(nullable = false)
    @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(\\d{4})$", message = "Please provide the valid date in dd/mm/yyyy format only ")
    private String dob;

    @Column(nullable = false)
    @Email(message = "Please provide the valid email e.g: john@gmail.com")
    private String email;


}
