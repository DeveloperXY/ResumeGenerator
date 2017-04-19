package com.developerxy.resume.util.writer.builder;

import com.developerxy.resume.util.HTMLWriter;
import com.developerxy.resume.util.writer.*;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class SectionBuilder {

    public SectionBuilder(HTMLWriter htmlWriter, Class<?> cls) {
        SectionWriter.initialize(cls, htmlWriter);
    }

    public SectionBuilder buildPersonalInfoSection() {
        new PersonalInfoWriter().writeSection();
        return this;
    }

    public SectionBuilder buildExperienceSection() {
        new ExperienceWriter().writeSection();
        return this;
    }

    public SectionBuilder buildFormationSection() {
        new FormationWriter().writeSection();
        return this;
    }

    public SectionBuilder buildProjectsSection() {
        new ProjectWriter().writeSection();
        return this;
    }

    public SectionBuilder buildSkillsSection() {
        new SkillWriter().writeSection();
        return this;
    }

    public SectionBuilder buildAccountsSection() {
        new AccountWriter().writeSection();
        return this;
    }
}
