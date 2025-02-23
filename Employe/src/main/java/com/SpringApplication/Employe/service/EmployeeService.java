package com.SpringApplication.Employe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.SpringApplication.Employe.entity.Employe;
import com.SpringApplication.Employe.repository.EmployeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeRepository employeRepository;
	
	public List<Employe> getAllEmploye(){
		List<Employe> employe=employeRepository.findAll();
		
		return employe;
	}
	
	
	public Employe getEmploye(int id) {
		
		Employe employe=employeRepository.findById(id).get();
		
		return employe;
		}
	
	public Employe createEmploye(Employe employe) {
	return 	employeRepository.save(employe);
	}
	
	
public Employe updateEmploye(int id) {
		
		Employe employe=employeRepository.findById(id).get();
		employe.setName("Kumar");
		employe.setRole("Acc");
		employeRepository.save(employe);
		
		return employe;
	}


public Employe removeEmploye(int id) {
	Employe employe=employeRepository.findById(id).get();
	employeRepository.delete(employe);
	
	return employe;
}
}
