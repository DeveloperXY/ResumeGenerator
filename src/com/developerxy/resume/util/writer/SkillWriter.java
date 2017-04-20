package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.skill.Skill;
import com.developerxy.resume.section.skill.Skills;
import com.developerxy.resume.util.formatter.HTMLFormatter;
import com.developerxy.resume.util.formatter.SkillFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class SkillWriter extends SectionWriter<Skill> {

    public SkillWriter(HTMLFormatter<Skill> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        writeSectionHeader("Compétences");
        mHTMLWriter.writeOpeningTagWithClass("div", "content");

        Skill[] skills = mSourceClass.getAnnotation(Skills.class).value();
        Arrays.asList(skills).forEach(s ->
                mHTMLWriter.writeContent(mFormatter.format(s)));

        mHTMLWriter.writeClosingTag("div")
                .writeClosingTag("div")
                .writeClosingTag("div");
    }
}
