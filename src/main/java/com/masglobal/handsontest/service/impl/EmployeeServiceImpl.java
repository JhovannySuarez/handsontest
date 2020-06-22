package com.masglobal.handsontest.service.impl;

import com.masglobal.handsontest.domain.Employee;
import com.masglobal.handsontest.dto.EmployeeDto;
import com.masglobal.handsontest.factory.EmployeeFactory;
import com.masglobal.handsontest.repositories.EmployeeServiceRepository;
import com.masglobal.handsontest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Solving Java Hands On Test
 * POINT 2. Business Logic layer to retrieve the employees’ information
 *
 * @version 1.0
 * @author Jhovanny Andrés Suárez Arenas
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeFactory employeeFactory;

    @Autowired
    private EmployeeServiceRepository employeeServiceRepository;

    /**
     * Method to find an Employee by ID with Big-O Complexity Θ(n)
     * @param id
     * @return
     */
    @Override
    public Optional<EmployeeDto> getEmployeeById(int id) {
        List<EmployeeDto> employees = getAllEmployees();
        return employees.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeServiceRepository.findAllEmployees();
        return employees.stream().map(employeeFactory::getEmployeeDto).collect(Collectors.toList());
    }
}
