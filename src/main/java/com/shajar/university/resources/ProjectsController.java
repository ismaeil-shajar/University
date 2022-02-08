package com.shajar.university.resources;

import com.shajar.university.services.GraduateProjectsServiceImp;
import com.shajar.university.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/projects")
public class ProjectsController {
    @Autowired
    private ProjectsService universityProjectsServiceImp;
    @Autowired
    private ProjectsService graduateProjectsServiceImp;

    @GetMapping("/university")
    public Set getAll(){
      return  this.universityProjectsServiceImp.findAll();
    }

    @GetMapping("/graduate/{year}")
    public Set getAllGraduate(@PathVariable String year){
      return  ((GraduateProjectsServiceImp)this.graduateProjectsServiceImp).findAll(year);
    }
}
