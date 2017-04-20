package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.ProjectModel;
import com.developerxy.resume.section.proj.Project;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ProjectFormatter implements HTMLFormatter<Project> {

    @Override
    public String format(Project project) {
        ProjectModel model = new ProjectModel(project);
        return String.format("<div class=\"text row\"><span class=\"keyword\">%s</span>, %s</div>",
                model.getName(), model.getDescription());
    }
}
