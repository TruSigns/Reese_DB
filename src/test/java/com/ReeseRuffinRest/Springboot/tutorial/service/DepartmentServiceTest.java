package com.ReeseRuffinRest.Springboot.tutorial.service;

import com.ReeseRuffinRest.Springboot.tutorial.entity.Department;
import com.ReeseRuffinRest.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository;



    @BeforeAll

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Reese")
                        .departmentCode("1")
                        .departmentID(1L)
                        .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);

    }

    @Test
    @DisplayName("Det Data based on Valida Department Name")
    public void whenValidDepartmentName_ThenDepartmentShouldFound(){

        String departmentName = "IT";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        //Test to see if data is found in the DB
        assertEquals(departmentName, found.getDepartmentName());

    }



}