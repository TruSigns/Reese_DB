package com.ReeseRuffinRest.Springboot.tutorial.controller;

import com.ReeseRuffinRest.Springboot.tutorial.entity.Department;
import com.ReeseRuffinRest.Springboot.tutorial.service.DepartmentService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XmlVisitor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.awt.*;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;
    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Reese")
                .departmentCode("IT3")
                .departmentName("IT")
                .departmentID(4L)
                .build();


    }

    @Test
    void saveDepartment() throws Exception {

         Department inputdepartment = Department.builder()
                .departmentAddress("Reese")
                .departmentCode("IT3")
                .departmentName("IT")
                .departmentID(4L)
                .build();

        Mockito.when(departmentService.saveDepartment(inputdepartment))
                .thenReturn(department);

        mockMvc.perform(post("/Department")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(" \"departmentName\": \"Reese\",\n" +
                                "\"departmentAddress\" : \"East River Rd\",\n" +
                                " \"departmentCode\":\"1\""))
                .andExpect(status().isOk())


    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(4L))
                .thenReturn(department);

        mockMvc.perform(get("/Department/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName").value(department.getDepartmentName()));



    }
}