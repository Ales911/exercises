package com.example.exercises.patterns.builder.employee;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    
    @Test
    public void EmployeeBuilderTest() {

        // GIVEN
        String name = "name1";
        String company = "company1";
        
        // WHEN
        Employee employee = new Employee.EmployeeBuilder(name, company).hasCar(true).hasBike(true).build();
        System.out.println(employee);
        
        // Then
        assertEquals(name, employee.name());
        assertEquals(company, employee.company());
        assertTrue(employee.hasCar());
        assertTrue(employee.hasBike());
    }

}
