package com.muruw.portfolio.dao;

import com.muruw.portfolio.model.Project;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProjectDAO {

    List<Project> selectAllProjects();

    Optional<Project> selectProjectById(UUID id);

    int insertProject(UUID id, Project project);

    default int insertProject(Project project){
        UUID randomId = UUID.randomUUID();
        return insertProject(randomId, project);
    }

}
