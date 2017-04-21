package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.training.Training;
import com.developerxy.resume.section.training.Trainings;
import com.developerxy.resume.util.formatter.HTMLFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FormationWriter extends SectionWriter<Training> {

    public FormationWriter(HTMLFormatter<Training> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        writeSectionHeader("Formation");
        Training[] formations = mSourceClass.getAnnotation(Trainings.class).value();
        Arrays.asList(formations).forEach(f ->
                mHTMLWriter.writeContent(mFormatter.format(f)));
        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }
}
