package com.shajar.university.common.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column
    private String name;

    @Column(name = "is_deleted", nullable = false)
    private short isDeleted;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="graduate_project_id",referencedColumnName ="id")
    private GraduateProject graduateProject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var student = (Student) o;
        return Objects.equals(name, student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return String.format("Student[id='%d', name='%s']"
                , id, name);
    }
}
