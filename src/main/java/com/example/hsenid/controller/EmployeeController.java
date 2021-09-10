package com.example.hsenid.controller;

import com.example.hsenid.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.hsenid.service.EmployeeService;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/hi")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeService.getAllEmployees());
        return "hsenid";
    }

    //employee form
    @GetMapping("/showEmployeeForm")
    public String showEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return  "add_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // save employee to database
        employeeService.saveEmployee(employee);
        return "redirect:/hi";
    }

    @GetMapping("/showFromUpDate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {


        Employee employee = employeeService.getEmployeeById(id);


        model.addAttribute("employee", employee);
        return "update_employee";
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable(value = "id") long id) {
        this.employeeService.deleteEmployeeById(id);

        return "redirect:/hi";
    }
}
