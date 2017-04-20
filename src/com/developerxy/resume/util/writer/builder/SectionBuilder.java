package com.developerxy.resume.util.writer.builder;

import com.developerxy.resume.CV;
import com.developerxy.resume.section.acc.Accounts;
import com.developerxy.resume.section.exp.Experiences;
import com.developerxy.resume.section.formation.Formations;
import com.developerxy.resume.section.proj.Projects;
import com.developerxy.resume.section.skill.Skills;
import com.developerxy.resume.util.writer.*;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class SectionBuilder {

    public SectionBuilder(HTMLWriter htmlWriter, Class<?> cls) {
        SectionWriter.initialize(cls, htmlWriter);
    }

    /**
     * @param resume source resume instance
     *               This method checks for annotations that are present on the resume class
     *               & builds its sections accordingly.
     */
    public void buildResumeSections(CV resume) {
        Class<?> cls = resume.getClass();
        Experiences experiences = cls.getAnnotation(Experiences.class);
        Formations formations = cls.getAnnotation(Formations.class);
        Projects projects = cls.getAnnotation(Projects.class);
        Skills skills = cls.getAnnotation(Skills.class);
        Accounts accounts = cls.getAnnotation(Accounts.class);

        if (experiences != null)
            buildExperienceSection();
        if (formations != null)
            buildFormationSection();
        if (projects != null)
            buildProjectsSection();
        if (skills != null)
            buildSkillsSection();
        if (accounts != null)
            buildAccountsSection();
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
