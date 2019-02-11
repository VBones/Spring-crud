package com.bones.springcrud.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bones.springcrud.entity.Employee;
import com.bones.springcrud.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/list")
	public String listAllEmployees(Model theModel) {
		
		List<Employee> employees = employeeService.getEmployees();
		
		theModel.addAttribute("employees", employees);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAddEmployee")
	public String showFormForAddEmployee(Model theModel) {
		
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@Valid @ModelAttribute("employee") Employee theEmployee,
							   BindingResult theBindingResult) {
		
		if (theBindingResult.hasErrors()) {
			return "employee-form";
		}
		else {
			employeeService.saveEmployee(theEmployee);
			
			return "redirect:/employee/list";
		}
	}
	
	@GetMapping("/showFormForUpdateEmployee")
	public String showFormForUpdateEmployee(@RequestParam("employeeId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Employee theEmployee = employeeService.getEmployee(theId);
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("employee", theEmployee);
		
		// send over to our form
		return "employee-form";
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId, HttpSession session) {
		
		// delete the customer
		employeeService.deleteEmployee(theId);;
		
		return "redirect:/employee/list";
	}
	
}
