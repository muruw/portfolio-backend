package com.muruw.portfolio.service;

import com.muruw.portfolio.dao.ProjectDAO;
import com.muruw.portfolio.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    private final ProjectDAO dao;

    @Autowired
    public ProjectService(@Qualifier("postgres") ProjectDAO dao) {
        this.dao = dao;
    }

    public List<Project> selectAllProjects(){
        return dao.selectAllProjects();
    }

    public Optional<Project> selectProjectById(UUID id){
        return dao.selectProjectById(id);
    }

    public int insertProject(Project project){
        return dao.insertProject(project);
    }

}
