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
public class UniversityProject extends BaseProject {

//    public static final String FIND_ALL = "UniversityProject.findAll";

    @Column
    private String discription;
    @Column
    private String faculty;
    @Column
    private String department;

    @Column(name = "is_deleted", nullable = false)
    private short isDeleted;

    @JsonIgnore
    @OneToMany(mappedBy = "universityProject",targetEntity = GraduateProject.class)
    private List<GraduateProject> graduateProjects;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        var universityProject = (UniversityProject) o;
        return Objects.equals(super.getName(), universityProject.getName()) &&
                Objects.equals(faculty, universityProject.getFaculty());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), super.getName(), faculty);
    }

    @Override
    public String toString() {
        return String.format("UniversityProject[id='%d', name='%s',faculty='%s']"
                , super.getId(), super.getName(),faculty);
    }
}
