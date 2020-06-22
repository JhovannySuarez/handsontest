package com.masglobal.handsontest.mappers;

import com.masglobal.handsontest.domain.Employee;
import com.masglobal.handsontest.dto.EmployeeHourlyDto;
import com.masglobal.handsontest.dto.EmployeeMonthlyDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper()
public interface EmployeeMapper {

    EmployeeHourlyDto employeeToEmployeeHourlyDto(Employee employee);

    EmployeeMonthlyDto employeeToEmployeeMonthlyDto(Employee employee);

}
