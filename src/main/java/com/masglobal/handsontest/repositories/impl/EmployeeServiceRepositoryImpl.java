package com.masglobal.handsontest.repositories.impl;

import com.masglobal.handsontest.domain.Employee;
import com.masglobal.handsontest.repositories.EmployeeServiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Solving Java Hands On Test
 * POINT 1.  Class repository that consumes the API: http://masglobaltestapi.azurewebsites.net/api/employees
 *
 * @version 1.0
 * @author Jhovanny Andrés Suárez Arenas
 */
@Slf4j
@Component
public class EmployeeServiceRepositoryImpl implements EmployeeServiceRepository {

    private static final String SERVICE_HOST = "http://masglobaltestapi.azurewebsites.net";
    private static final String SERVICE_PATH = "/api/Employees/";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Employee> findAllEmployees() {

        try {
            Employee[] response = restTemplate.getForObject(SERVICE_HOST + SERVICE_PATH, Employee[].class);
            return response != null ? Arrays.asList(response) : Collections.emptyList();
        } catch (Exception e) {
            log.error("Error trying to get the data " + e.getMessage());
        }
        return Collections.emptyList();
    }
}
