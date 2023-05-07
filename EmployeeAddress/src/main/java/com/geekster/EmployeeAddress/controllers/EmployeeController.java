package com.geekster.EmployeeAddress.controllers;

import com.geekster.EmployeeAddress.models.Address;
import com.geekster.EmployeeAddress.models.Employee;
import com.geekster.EmployeeAddress.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {



//    PUT /employees/{id} - update an employee by id
//    DELETE /employees/{id} - delete an employee by id

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/multiple")
    public String addEmployees(@RequestBody List<Employee> employees) {
        return employeeService.insertEmployees(employees);
    }

//    get all employees data
    @GetMapping(value = "/all")
    public List<Employee> getAllEmployees(){
        return employeeService.fetchAllEmployees();
    }

//    get specific employee by their employeeId
    @GetMapping(value = "/byId/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }


//    delete based on employeeId
    @DeleteMapping(value = "/byId/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.removeEmployeeById(id);
    }

//    update state of address based on employeeId
    @PutMapping(value = "/byId/{id}/state/{state}")
    public void updateEmployeeById(@PathVariable Long id,@PathVariable String state){
        employeeService.updateEmployeeById(id,state);
    }
}
