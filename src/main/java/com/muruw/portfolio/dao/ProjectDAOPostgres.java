package com.muruw.portfolio.dao;

import com.muruw.portfolio.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class ProjectDAOPostgres implements ProjectDAO{

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDAOPostgres(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Project> selectAllProjects() {
        final String sql = "SELECT id, name, stack, description, link FROM project";

        List<Project> projects = jdbcTemplate.query(sql, (resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String stack = resultSet.getString("stack");
            String description = resultSet.getString("description");
            String link = resultSet.getString("link");

            return new Project(id, name, stack, description, link);
        });

        return projects;
    }

    @Override
    public Optional<Project> selectProjectById(UUID id) {
        String sql = "SELECT id, name, stack, description, link FROM project WHERE id = ?";

        Project project = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID projectId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String stack = resultSet.getString("stack");
            String description = resultSet.getString("description");
            String link = resultSet.getString("link");

            return new Project(projectId, name, stack, description, link);
        });

        return Optional.ofNullable(project);
    }

    @Override
    public int insertProject(UUID id, Project project) {
        return 0;
    }
}
