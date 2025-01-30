package com.group21.tpw.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "download")
public class DownloadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}