package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.formation.Formation;
import com.developerxy.resume.section.formation.Formations;
import com.developerxy.resume.util.formatter.FormationFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FormationWriter extends SectionWriter {
    @Override
    public void writeSection() {
        writeSectionHeader("Formation");

        Formation[] formations = mSourceClass.getAnnotation(Formations.class).value();
        Arrays.asList(formations).forEach(f ->
                mHTMLWriter.writeContent(new FormationFormatter(f)));

        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }
}
