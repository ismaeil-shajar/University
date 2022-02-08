package com.shajar.university.common.data.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table
public class GraduateProject extends BaseProject {

//    public static final String FIND_ALL = "GraduateProject.findAll";


    @Column
    private String year;
    @Column
    private String discription;

    @Column(name = "is_deleted", nullable = false)
    private short isDeleted;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="university_project_id",referencedColumnName ="id")
    private UniversityProject universityProject;

    @JsonIgnore
    @OneToMany(mappedBy = "graduateProject",targetEntity = Student.class)
    private List<Student> students;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var graduateProject = (GraduateProject) o;
        return Objects.equals(super.getName(), graduateProject.getName())
        && Objects.equals(year, graduateProject.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getName(), year);
    }

    @Override
    public String toString() {
        return String.format("GraduateProject[id='%d', name='%s', year='%s']"
                , super.getId(), super.getName(),year);
    }
}
