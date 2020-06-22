package com.masglobal.handsontest.service;

import com.masglobal.handsontest.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<EmployeeDto> getEmployeeById(int id);

    List<EmployeeDto> getAllEmployees();
}
