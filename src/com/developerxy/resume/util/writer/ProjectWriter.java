package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.proj.Project;
import com.developerxy.resume.section.proj.Projects;
import com.developerxy.resume.util.formatter.ProjectFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ProjectWriter extends SectionWriter {
    @Override
    public void writeSection() {
        writeSectionHeader("Projets réalisés");
        mHTMLWriter.writeOpeningTagWithClass("div", "content");

        Project[] projects = mSourceClass.getAnnotation(Projects.class).value();
        Arrays.asList(projects).forEach(p ->
                mHTMLWriter.writeContent(new ProjectFormatter(p)));

        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div")
                .writeClosingTag("div");
    }
}
