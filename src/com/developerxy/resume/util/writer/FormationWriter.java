package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.formation.Formation;
import com.developerxy.resume.section.formation.Formations;
import com.developerxy.resume.util.formatter.HTMLFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FormationWriter extends SectionWriter<Formation> {

    public FormationWriter(HTMLFormatter<Formation> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        writeSectionHeader("Formation");
        Formation[] formations = mSourceClass.getAnnotation(Formations.class).value();
        Arrays.asList(formations).forEach(f ->
                mHTMLWriter.writeContent(mFormatter.format(f)));
        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }
}
