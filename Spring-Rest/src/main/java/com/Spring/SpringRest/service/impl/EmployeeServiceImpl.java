package com.Spring.SpringRest.service.impl;

import com.Spring.SpringRest.exception.ResourceNotFoundException;
import com.Spring.SpringRest.model.Employee;
import com.Spring.SpringRest.repository.EmployeeRepository;
import com.Spring.SpringRest.repository.StudentRepository;
import com.Spring.SpringRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class EmployeeServiceImpl implements EmployeeService {
    private  EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               StudentRepository studentRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>(employeeRepository.findAll());
        return employees;
    }

    @Override
    public Employee getEmployeeById(long id) {
       Optional<Employee> employee = employeeRepository.findById(id);
       if(employee.isPresent()){
           return employee.get();
       }else {
           throw new ResourceNotFoundException("Employee","Id",id);
       }

    }


    @Override
    public void deleteEmployee(long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id","Id",id));
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
//        check if the employee exist with given id
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

}
