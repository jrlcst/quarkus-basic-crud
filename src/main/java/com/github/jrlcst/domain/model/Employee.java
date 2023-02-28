package com.github.jrlcst.domain.model;

import com.github.jrlcst.rest.dto.request.EmployeeRequest;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "gender")
    private String gender;

    @Column(name = "phone_number")
    private String phoneNumber;

    public static Employee createByRequest(EmployeeRequest request) {
        return Employee.builder()
                .id(request.getId())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .birthday(request.getBirthday())
                .gender(request.getGender())
                .phoneNumber(request.getPhoneNumber()).build();
    }

    public static Employee updateByRequest(Employee entity, EmployeeRequest request) {
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setBirthday(request.getBirthday());
        entity.setPhoneNumber(request.getPhoneNumber());
        entity.setGender(request.getGender());
        return entity;
    }
}
