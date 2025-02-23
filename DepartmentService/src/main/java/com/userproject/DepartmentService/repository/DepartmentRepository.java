package com.userproject.DepartmentService.repository;

import com.userproject.DepartmentService.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
