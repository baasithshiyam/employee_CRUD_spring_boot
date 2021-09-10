package com.example.hsenid.service;

import com.example.hsenid.model.Employee;
import com.example.hsenid.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmployeeServiceImplementation implements EmployeeService {
    @Autowired

    private EmployeeRepository employeeRepository;

    @Override

    public List< Employee > getAllEmployees() {
        return  employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        Employee employee = null;
        if (optionalEmployee.isPresent()){
            employee = optionalEmployee.get();

        }else {
            throw new RuntimeException ("id is not found");
        }
        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }


}
