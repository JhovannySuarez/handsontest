package com.masglobal.handsontest.factory;

import com.masglobal.handsontest.domain.Employee;
import com.masglobal.handsontest.dto.EmployeeDto;
import com.masglobal.handsontest.dto.EmployeeMonthlyDto;
import com.masglobal.handsontest.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Solving Java Hands On Test
 * POINT 2.2 Simple Factory Class to create the concrete classes depending on the type of contract.
 *
 * @author Jhovanny Andrés Suárez Arenas
 * @version 1.0
 */
@Component
public class EmployeeFactory {

    @Autowired
    public EmployeeMapper employeeMapper;

    public EmployeeDto getEmployeeDto(Employee employee) {
        String typeOfContract = employee.getContractTypeName();

        if ("HourlySalaryEmployee".equalsIgnoreCase(typeOfContract)) {
            return employeeMapper.employeeToEmployeeHourlyDto(employee);
        } else if ("MonthlySalaryEmployee".equalsIgnoreCase(typeOfContract)) {
            EmployeeMonthlyDto employeeToEmployeeMonthlyDTO = employeeMapper.employeeToEmployeeMonthlyDto(employee);
            return employeeToEmployeeMonthlyDTO;
        }
        return null;
    }
}
