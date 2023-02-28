package com.github.jrlcst.rest.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String gender;
    private String phoneNumber;
}