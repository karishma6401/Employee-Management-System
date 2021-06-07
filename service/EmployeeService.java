package com.example.springrestcrud.EmployeeManagementSystem.service;

import java.util.List;

import com.example.springrestcrud.EmployeeManagementSystem.domain.Employee;

public interface EmployeeService {
   List<Employee> getAllEmployees();
   void saveEmployee(Employee employee);
   Employee getEmployeeById(long id);
   void deleteEmployeeById(long id);
   
}
	