package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.ProjectModel;
import com.developerxy.resume.section.proj.Project;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ProjectFormatter extends HTMLFormatter<ProjectModel> {
    public ProjectFormatter(ProjectModel model) {
        super(model);
    }

    public ProjectFormatter(Project project) {
        super(new ProjectModel(project));
    }

    @Override
    public String format() {
        return String.format("<div class=\"text row\"><span class=\"keyword\">%s</span>, %s</div>",
                model.getName(), model.getDescription());
    }
}
