package com.goth3l.teste.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.goth3l.teste.entities.Project;
import com.goth3l.teste.repositories.ProjectRepository;


public class ProjectService {
	
private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}
	
	public Project getProjectByid(Long id) {
		return projectRepository.findById(id).orElse(null);
	}
	
	public List<Project> getAllProject(){
		return projectRepository.findAll();
	}
	
	public Project saveProject(Project project) {
		return projectRepository.save(project);
	}

}