package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.exp.Experience;
import com.developerxy.resume.section.exp.Experiences;
import com.developerxy.resume.util.formatter.ExperienceFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ExperienceWriter extends SectionWriter {
    @Override
    public void writeSection() {
        writeSectionHeader("Expérience");

        Experience[] experiences = mSourceClass.getAnnotation(Experiences.class).value();
        Arrays.asList(experiences).forEach(e ->
                mHTMLWriter.writeContent(new ExperienceFormatter(e)));

        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }
}
