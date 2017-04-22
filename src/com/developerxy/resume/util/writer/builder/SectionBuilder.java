package com.developerxy.resume.util.writer.builder;

import com.developerxy.resume.Resume;
import com.developerxy.resume.section.acc.Accounts;
import com.developerxy.resume.section.exp.Experiences;
import com.developerxy.resume.section.training.Trainings;
import com.developerxy.resume.section.proj.Projects;
import com.developerxy.resume.section.skill.Skills;
import com.developerxy.resume.util.formatter.*;
import com.developerxy.resume.util.writer.*;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class SectionBuilder {

    private String resourcesRepository;

    public SectionBuilder(HTMLWriter htmlWriter, Class<?> cls, String resourcesRepository) {
        SectionWriter.initialize(cls, htmlWriter);
        this.resourcesRepository = resourcesRepository;
    }

    /**
     * @param resume source resume instance
     *               This method checks for annotations that are present on the resume class
     *               & builds its sections accordingly.
     */
    public void buildResumeSections(Resume resume) {
        Class<?> cls = resume.getClass();

        Experiences experiences = cls.getAnnotation(Experiences.class);
        Trainings trainings = cls.getAnnotation(Trainings.class);
        Projects projects = cls.getAnnotation(Projects.class);
        Skills skills = cls.getAnnotation(Skills.class);
        Accounts accounts = cls.getAnnotation(Accounts.class);

        if (experiences != null)
            buildExperienceSection(experiences.label());
        if (trainings != null)
            buildTrainingSection(trainings.label());
        if (projects != null)
            buildProjectsSection(projects.label());
        if (skills != null)
            buildSkillsSection(skills.label());
        if (accounts != null)
            buildAccountsSection();
    }

    public SectionBuilder buildPersonalInfoSection() {
        new PersonalInfoWriter(new PersonalInfoFormatter(resourcesRepository)).writeSection();
        return this;
    }

    public SectionBuilder buildExperienceSection(String sectionLabel) {
        new ExperienceWriter(new ExperienceFormatter())
                .labeled(sectionLabel)
                .writeSection();
        return this;
    }

    public SectionBuilder buildTrainingSection(String sectionLabel) {
        new TrainingWriter(new FormationFormatter())
                .labeled(sectionLabel)
                .writeSection();
        return this;
    }

    public SectionBuilder buildProjectsSection(String sectionLabel) {
        new ProjectWriter(new ProjectFormatter())
                .labeled(sectionLabel)
                .writeSection();
        return this;
    }

    public SectionBuilder buildSkillsSection(String sectionLabel) {
        new SkillWriter(new SkillFormatter())
                .labeled(sectionLabel)
                .writeSection();
        return this;
    }

    public SectionBuilder buildAccountsSection() {
        new AccountWriter(new AccountFormatter(resourcesRepository)).writeSection();
        return this;
    }
}
