package com.SpringApplication.Employe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringApplication.Employe.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}
