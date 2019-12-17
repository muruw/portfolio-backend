package com.muruw.portfolio.api;

import com.muruw.portfolio.model.Project;
import com.muruw.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.selectAllProjects();
    }

    @GetMapping(path = "/{id}")
    public Project getProjectById(@PathVariable("id") UUID id){
        return projectService.selectProjectById(id)
                .orElse(null);
    }

    @PostMapping
    public int addProject(@Valid @NotNull @RequestBody Project project){
        return projectService.insertProject(project);
    }


}
