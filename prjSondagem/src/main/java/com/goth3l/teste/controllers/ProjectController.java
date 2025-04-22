package com.goth3l.teste.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goth3l.teste.entities.Project;
import com.goth3l.teste.services.ProjectService;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<Project> createProject( @RequestBody Project project) {
        Project savedProject = projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Project project = projectService.getProjectByid(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProject();
        return ResponseEntity.ok(projects);
    }
}