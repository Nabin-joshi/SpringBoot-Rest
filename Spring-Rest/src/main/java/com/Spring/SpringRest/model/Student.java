package com.Spring.SpringRest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "studentnew")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  Id;
    private String name;
    private String email;
    private String password;
    private String date;

}
