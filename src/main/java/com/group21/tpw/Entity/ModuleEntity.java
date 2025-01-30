package com.group21.tpw.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "module")
public class ModuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private byte[] doc;
    @ManyToOne
    private CourseEntity course;

}