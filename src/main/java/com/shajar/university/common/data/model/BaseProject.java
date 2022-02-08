package com.shajar.university.common.data.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class BaseProject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column( nullable = false)
    private String name;
}
