package com.developerxy.resume.model;

import com.developerxy.resume.section.proj.Project;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class ProjectModel extends AbstractModel {
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
        return getLineBreakableContent(description);
    }
}
