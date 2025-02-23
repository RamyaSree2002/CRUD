package com.SpringApplication.Employe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.SpringApplication.Employe.entity.Employe;
import com.SpringApplication.Employe.repository.EmployeRepository;
import com.SpringApplication.Employe.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employes")
	public List<Employe> getAllEmploye(){
		List<Employe> employe=employeeService.getAllEmploye();
		
		return employe;
	}
	
	@GetMapping("/employe/{id}")
	public Employe getEmploye(@PathVariable int id) {
		
	Employe employe=employeeService.getEmploye(id);
	
	return employe;
	}
	
	@PostMapping("/employe/add")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Employe createEmploye(@RequestBody Employe employe) {
	return	employeeService.createEmploye(employe);
		
	}
	
	@PutMapping("/employe/update/{id}")
	public Employe updateEmploye(@PathVariable int id) {
		
		Employe employe=employeeService.updateEmploye(id);
		
		
		return employe;
	}
	
	@DeleteMapping("/employe/delete/{id}")
	public Employe removeEmploye(@PathVariable int id) {
		Employe employe=employeeService.removeEmploye(id);
		
		
		return employe;
	}
}
