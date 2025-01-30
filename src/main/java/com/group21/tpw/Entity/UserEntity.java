package com.group21.tpw.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity(name = "`user`")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private String password;
    @ManyToMany(mappedBy = "users", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private Set<CourseEntity> courses = new HashSet<>();
}
