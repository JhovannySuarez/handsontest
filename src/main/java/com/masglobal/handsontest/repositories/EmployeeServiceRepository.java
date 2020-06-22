package com.masglobal.handsontest.repositories;

import com.masglobal.handsontest.domain.Employee;

import java.util.List;

public interface EmployeeServiceRepository {

    List<Employee> findAllEmployees();

}
