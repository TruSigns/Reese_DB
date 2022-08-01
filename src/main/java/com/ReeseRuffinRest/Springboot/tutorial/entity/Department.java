package com.ReeseRuffinRest.Springboot.tutorial.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Department {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long departmentID;
   /* @NotBlank(message = "This is not valid. Please add department name")
    @Length(max = 5, min = 1)
    @Size(max = 10, min = 0)

    */
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;



}
