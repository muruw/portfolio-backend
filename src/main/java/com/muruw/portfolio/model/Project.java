package com.muruw.portfolio.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Project {

    private final UUID id;
    @NotBlank
    private String projectName;
    private String projectStack;
    private String projectDescription;
    private String projectLink;


    public Project(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String projectName,
                   @JsonProperty("stack") String projectStack,
                   @JsonProperty("description") String projectDescription,
                   @JsonProperty("link") String projectLink){
        this.id = id;
        this.projectName = projectName;
        this.projectStack = projectStack;
        this.projectDescription = projectDescription;
        this.projectLink = projectLink;
    }

    public UUID getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectStack(){ return projectStack;}

    public String getProjectDescription() {
        return projectDescription;
    }

    public String getProjectLink() {
        return projectLink;
    }
}
