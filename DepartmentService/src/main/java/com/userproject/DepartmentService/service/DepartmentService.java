package com.userproject.DepartmentService.service;

import com.userproject.DepartmentService.entity.Department;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);
}
