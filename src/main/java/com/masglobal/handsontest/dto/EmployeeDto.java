package com.masglobal.handsontest.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public abstract class EmployeeDto {

    @EqualsAndHashCode.Include
    private int id;
    private String name;
    private String contractTypeName;
    private int roleId;
    private String roleName;
    private String roleDescription;
    private int hourlySalary;
    private int monthlySalary;
    private int calculatedAnnualSalary;

    public int getCalculatedAnnualSalary() {
        return calculateAnnualSalary();
    }

    /**
     * Solving Java Hands On Test
     * POINT 2.4
     * Method to calculate the annual salary based on the type of salary
     *
     * @return the calculated annual salary
     */
    public abstract int calculateAnnualSalary();

}
