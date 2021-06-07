package com.example.springrestcrud.EmployeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.springrestcrud.EmployeeManagementSystem.domain.Employee;
import com.example.springrestcrud.EmployeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	//display list of employees
	@GetMapping("/viewHomePage")
	public String viewHomePage(Model model)
	{
		model.addAttribute("listEmployees",employeeService.getAllEmployees());
	    return "index";
	}
	
	@GetMapping("/")
	public String login()
	{
	    return "login";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) 
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@GetMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) 
	{
	    //save Employee to database
		employeeService.saveEmployee(employee);
		return "redirect:/viewHomePage";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id , Model model) 
	{
	    //get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		//set employee as a model attribute to pre-populate the form 
		model.addAttribute("employee", employee);
		return "update_employee";
		
	}
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable (value ="id") long id)
	{
		//call employee delete
		this.employeeService.deleteEmployeeById(id);
		return "redirect:/viewHomePage";
	}
	
}
