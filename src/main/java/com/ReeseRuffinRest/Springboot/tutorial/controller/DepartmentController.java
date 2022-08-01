package com.ReeseRuffinRest.Springboot.tutorial.controller;

import com.ReeseRuffinRest.Springboot.tutorial.entity.Department;
import com.ReeseRuffinRest.Springboot.tutorial.error.DepartmentNotFoundException;
import com.ReeseRuffinRest.Springboot.tutorial.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/department")
    public Department saveDepartment(@Valid @RequestBody Department department){

        //log the information when person logs in

        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/department")
    public List<Department> fetchDepartmentList() {

        LOGGER.info("Inside fetchDepartment of DepartmentController");
        return departmentService.fetchDepartmentList();

    }

    @GetMapping("/department/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId)
            throws DepartmentNotFoundException {
        LOGGER.info("Inside fetchDepartment of DepartmentController looking for ID");
        return departmentService.fetchDepartmentById(departmentId);



    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {

        departmentService.deleteDepartmentById(departmentId);

        return "The department is deleted";



    }

    @PostMapping("/department/{id}")
    public Department updateDepartment(@Valid @PathVariable("id") Long departmentId,
                                   @RequestBody Department department ){

        return departmentService.updateDepartment(departmentId, department);


    }

    @GetMapping("/department/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){

        return departmentService.fetchDepartmentByName(departmentName);


    }


}
