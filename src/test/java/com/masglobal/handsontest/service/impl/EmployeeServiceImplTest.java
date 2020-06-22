package com.masglobal.handsontest.service.impl;

import com.masglobal.handsontest.domain.Employee;
import com.masglobal.handsontest.dto.EmployeeDto;
import com.masglobal.handsontest.repositories.EmployeeServiceRepository;
import com.masglobal.handsontest.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeServiceRepository employeeServiceRepository;

    @Autowired
    private EmployeeService employeeService;

    @BeforeEach
    public void setup() {

        List<Employee> employees = new ArrayList<>();

        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Juan");
        employee.setRoleName("Administrator");
        employee.setContractTypeName("HourlySalaryEmployee");
        employee.setHourlySalary(60000);
        employee.setMonthlySalary(80000);
        employees.add(employee);

        employee = new Employee();
        employee.setId(2);
        employee.setName("Sebastian");
        employee.setRoleName("Contractor");
        employee.setContractTypeName("MonthlySalaryEmployee");
        employee.setHourlySalary(60000);
        employee.setMonthlySalary(80000);
        employees.add(employee);

        when(employeeServiceRepository.findAllEmployees()).thenReturn(employees);
    }

    @Test
    public void shouldReturnEmployeeByGivenID() {
        Optional<EmployeeDto> employee = employeeService.getEmployeeById(1);
        Assertions.assertTrue(employee.isPresent());
    }

    @Test
    public void shouldReturnCorrectCalculatedAnnualSalaryForHourlyContract() {
        int annualSalary = 120 * 60000 * 12;
        Optional<EmployeeDto> employee = employeeService.getEmployeeById(1);
        Assertions.assertTrue(employee.isPresent());
        Assertions.assertEquals(annualSalary, employee.get().getCalculatedAnnualSalary());
    }

    @Test
    public void shouldReturnCorrectCalculatedAnnualSalaryForMonthlyContract() {
        int annualSalary = 80000 * 12;
        Optional<EmployeeDto> employee = employeeService.getEmployeeById(2);
        Assertions.assertTrue(employee.isPresent());
        Assertions.assertEquals(annualSalary, employee.get().getCalculatedAnnualSalary());
    }

}