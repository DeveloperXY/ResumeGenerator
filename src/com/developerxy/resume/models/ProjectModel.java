package com.developerxy.resume.models;

import com.developerxy.resume.sections.proj.Project;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class ProjectModel {
    private String name;
    private String description;

    public ProjectModel(Project project) {
        name = project.name();
        description = project.description();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
