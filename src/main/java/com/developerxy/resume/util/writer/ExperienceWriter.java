package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.exp.Experience;
import com.developerxy.resume.section.exp.Experiences;
import com.developerxy.resume.util.formatter.HTMLFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ExperienceWriter extends SectionWriter<Experience> {

    public ExperienceWriter(HTMLFormatter<Experience> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        writeSectionHeader(sectionLabel);
        Experience[] experiences = mSourceClass.getAnnotation(Experiences.class).value();
        Arrays.asList(experiences).forEach(e ->
                mHTMLWriter.writeContent(mFormatter.format(e)));
        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }
}
