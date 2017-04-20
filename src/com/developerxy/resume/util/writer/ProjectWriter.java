package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.proj.Project;
import com.developerxy.resume.section.proj.Projects;
import com.developerxy.resume.util.formatter.HTMLFormatter;
import com.developerxy.resume.util.formatter.ProjectFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ProjectWriter extends SectionWriter<Project> {

    public ProjectWriter(HTMLFormatter<Project> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        writeSectionHeader("Projets réalisés");
        mHTMLWriter.writeOpeningTagWithClass("div", "content");

        Project[] projects = mSourceClass.getAnnotation(Projects.class).value();
        Arrays.asList(projects).forEach(p ->
                mHTMLWriter.writeContent(mFormatter.format(p)));

        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div")
                .writeClosingTag("div");
    }
}
