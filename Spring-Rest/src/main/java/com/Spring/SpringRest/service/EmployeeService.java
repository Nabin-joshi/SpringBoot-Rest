package com.Spring.SpringRest.service;

import com.Spring.SpringRest.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getEmployees();

    Employee getEmployeeById(long id);

    void deleteEmployee(long id);
    Employee updateEmployee(Employee employee,long id);


}
