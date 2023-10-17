package com.lh.source_sets;

import java.lang.annotation.Annotation;

/**
 * @author lh
 */
public class TestCustomAnnotatedEmployee {
    public static void main(String[] args) {
        CustomAnnotatedEmployee employee = new CustomAnnotatedEmployee(1,"John Doe");
        employee.getEmployeeDetails();

        Annotation compnayAnnotation = employee.getClass().getAnnotation(Company.class);

        Company company = (Company)compnayAnnotation;

        System.out.println("Company Name: "  + company.name());
        System.out.println("Company City: "  + company.city());
    }
}
