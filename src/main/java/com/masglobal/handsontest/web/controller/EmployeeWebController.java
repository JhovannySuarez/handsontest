package com.masglobal.handsontest.web.controller;

import com.masglobal.handsontest.dto.EmployeeDto;
import com.masglobal.handsontest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequestMapping("/")
@Controller
public class EmployeeWebController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String getEmployeeById(Model model, @RequestParam(value = "employeeId", required = false) Integer id) {
        List<EmployeeDto> employees;
        if (id == null) {
            employees = employeeService.getAllEmployees();

        } else {
            Optional<EmployeeDto> employee = employeeService.getEmployeeById(id);
            employees = employee.isPresent() ? Collections.singletonList(employee.get()) : Collections.emptyList();
        }

        model.addAttribute("employees", employees);
        return "employee";
    }
}
