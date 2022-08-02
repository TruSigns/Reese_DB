package com.ReeseRuffinRest.Springboot.tutorial.repository;

import com.ReeseRuffinRest.Springboot.tutorial.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;


    @BeforeEach
    void setUp() {

        Department department = Department.builder()
                .departmentName("Mechanical")
                .departmentCode("ME - 011")
                .departmentAddress("NC")
                .build();

        entityManager.persist(department);

    }

    @Test
    public void WhenFindById_ThenReturnDepartment(){
        Department department = departmentRepository.findById(1L).get();
        assertEquals(department.getDepartmentName(), "Mechanical");
    }
}