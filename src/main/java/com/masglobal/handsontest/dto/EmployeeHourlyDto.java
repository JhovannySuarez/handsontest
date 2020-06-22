package com.masglobal.handsontest.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * Solving Java Hands On Test
 * POINT 2.1 DTO (Data Transfer Object) Class for the Hourly type Contract
 *
 * @author Jhovanny Andrés Suárez Arenas
 * @version 1.0
 */
@NoArgsConstructor
public class EmployeeHourlyDto extends EmployeeDto {

    @Builder
    public EmployeeHourlyDto(int id, String name, String contractTypeName, int roleId, String roleName, String roleDescription, int hourlySalary, int monthlySalary, int calculatedAnnualSalary) {
        super(id, name, contractTypeName, roleId, roleName, roleDescription, hourlySalary, monthlySalary, calculatedAnnualSalary);
    }

    @Override
    public int calculateAnnualSalary() {
        return 120 * this.getHourlySalary() * 12;
    }
}
