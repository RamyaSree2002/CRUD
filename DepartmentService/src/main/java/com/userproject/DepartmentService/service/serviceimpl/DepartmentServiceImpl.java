package com.userproject.DepartmentService.service.serviceimpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.userproject.DepartmentService.entity.Department;
import com.userproject.DepartmentService.repository.DepartmentRepository;
import com.userproject.DepartmentService.service.DepartmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
@Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
}


