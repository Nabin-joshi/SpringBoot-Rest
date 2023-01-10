package com.Spring.SpringRest.controller;

import com.Spring.SpringRest.model.Employee;
import com.Spring.SpringRest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


//    build create Employee Rest ApI

    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
        return  responseEntity;
    }


    @GetMapping("/view")
    public List<Employee> getAllEmployee(){
        List<Employee> employees = new ArrayList<>(employeeService.getEmployees());
        return employees;
    }

//    No need to use ResponseEntity
//@GetMapping("/view/{id}")
//    public ResponseEntity<Employee>  getEmployeeid(@PathVariable("id") long employeeid){
//        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid),HttpStatus.OK);
//}

    @GetMapping("/view/{id}")
    public Employee getEmployeeById(@PathVariable("id") long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

//    To convert Json to java object @RequestBody is used
    @PutMapping("/put/{id}")
    public Employee updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        Employee employee1 = employeeService.updateEmployee(employee,id);
        return employee1;
    }

    @DeleteMapping("{id}")
public String deleteById(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return "done";
}

}
