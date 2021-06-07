package com.example.springrestcrud.EmployeeManagementSystem.repository;
import  com.example.springrestcrud.EmployeeManagementSystem.domain.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{
	
	
}
	