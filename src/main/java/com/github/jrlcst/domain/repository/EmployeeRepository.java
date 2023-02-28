package com.github.jrlcst.domain.repository;

import com.github.jrlcst.domain.model.Employee;
import com.github.jrlcst.domain.exception.CustomException;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import java.util.UUID;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public Employee findByUUID(UUID uuid) {
        return find("id", uuid).list().stream().findFirst().orElseThrow(() -> new CustomException("This Employee not exists"));
    }
}
