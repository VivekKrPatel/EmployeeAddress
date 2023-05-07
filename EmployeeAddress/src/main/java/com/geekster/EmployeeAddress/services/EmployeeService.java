package com.geekster.EmployeeAddress.services;

import com.geekster.EmployeeAddress.models.Address;
import com.geekster.EmployeeAddress.models.Employee;
import com.geekster.EmployeeAddress.repositories.IEmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    IEmployeeRepo iEmployeeRepo;

    public String insertEmployees(List<Employee> employees) {
        Iterable<Employee> added = iEmployeeRepo.saveAll(employees);

        if(added != null){
            return "Added succesfully...";
        }
        return "Failed...";
    }

    public List<Employee> fetchAllEmployees() {
        return iEmployeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return iEmployeeRepo.findById(id);
    }

    public void removeEmployeeById(Long id) {
        iEmployeeRepo.deleteById(id);
    }

    public void updateEmployeeById(Long id,String state) {
//        get employee object
        Optional<Employee> findedEmp = iEmployeeRepo.findById(id);
        Employee employeeDetails = findedEmp.get();
        employeeDetails.getAddress().setState(state);
        iEmployeeRepo.save(employeeDetails);
    }
}
