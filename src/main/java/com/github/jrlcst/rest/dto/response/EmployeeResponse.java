package com.github.jrlcst.rest.dto.response;

import com.github.jrlcst.domain.model.Employee;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthday;
    private String gender;
    private String phoneNumber;

    public static EmployeeResponse createByEntity(Employee entity){
        return EmployeeResponse.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .birthday(entity.getBirthday())
                .gender(entity.getGender())
                .phoneNumber(entity.getPhoneNumber()).build();
    }
}
