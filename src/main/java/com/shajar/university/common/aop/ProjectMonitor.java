package com.shajar.university.common.aop;

import com.shajar.university.services.ProjectsService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Set;

@Aspect
@Component
@Slf4j
public class ProjectMonitor {


    private static void accept(Object e) {
        log.info(e.toString());
    }

    @Pointcut("execution(*  com.shajar.university.services.*Service+.findAll*(..)) && target(projectsService)")
    public void onGet( ProjectsService projectsService){}

    @Before("onGet(projectsService)")
    public void preFind(ProjectsService projectsService){
        log.info("&&&&&&&&&&&&&&&&&&& Before AOP Start &&&&&&&&&&&&&&&&&&");
        log.info("before service {}",projectsService.getClass());
        log.info("&&&&&&&&&&&&&&&&&&& Before AOP End   &&&&&&&&&&&&&&&&&&");
    }

    @AfterReturning(value="onGet(projectsService)",returning = "result")
    public void postFind(ProjectsService projectsService, Set result){
        log.info("&&&&&&&&&&&&&&&&&  After AOP Start &&&&&&&&&&&&&&&&&&&&");
        result.forEach(ProjectMonitor::accept);
        log.info("&&&&&&&&&&&&&&&&&  After AOP End   &&&&&&&&&&&&&&&&&&&&");
    }
}
