package com.developerxy.resume;

import com.developerxy.resume.sections.acc.Account;
import com.developerxy.resume.sections.acc.Accounts;
import com.developerxy.resume.sections.exp.Experience;
import com.developerxy.resume.sections.exp.Experiences;
import com.developerxy.resume.sections.formation.Formation;
import com.developerxy.resume.sections.formation.Formations;
import com.developerxy.resume.sections.personal.PersonalInfo;
import com.developerxy.resume.sections.proj.Project;
import com.developerxy.resume.sections.proj.Projects;
import com.developerxy.resume.sections.skill.Skill;
import com.developerxy.resume.sections.skill.Skills;
import com.developerxy.resume.util.HTMLWriter;
import com.developerxy.resume.util.Output;
import com.developerxy.resume.util.Stylesheets;
import com.developerxy.resume.util.format.*;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@Stylesheets({"style.css"})
public abstract class CV {

    private HTMLWriter htmlWriter;
    private String outputLocation;

    public void build() {
        Class<?> cls = getClass();
        String outputLocation = cls.getAnnotation(Output.class).value();
        Stylesheets stylesheets = cls.getAnnotation(Stylesheets.class);
        this.outputLocation = outputLocation;

        try (HTMLWriter htmlWriter = new HTMLWriter(outputLocation)) {
            this.htmlWriter = htmlWriter;
            htmlWriter.setDoctype()
                    .writeOpeningTag("html")
                    .writeContent(new HeaderFormatter(stylesheets))
                    .writeOpeningTag("body")
                    .writeOpeningTagWithClass("div", "wrapper");

            writePersonalInfo(cls);
            htmlWriter.writeOpeningTagWithClass("div", "main");
            writeSections(cls);

            htmlWriter.writeClosingTag("div")
                    .writeClosingTag("div")
                    .writeClosingTag("body")
                    .writeClosingTag("html");

            System.out.println(String.format(
                    "The resume has been successfully created in the following location: %s", outputLocation));
        } catch (Exception e) {
            System.err.println("An error occured while generating the resume.");
            e.printStackTrace();
        }
    }

    private void writePersonalInfo(Class<?> cls) {
        htmlWriter.writeContent(new PersonalInfoFormatter(
                cls.getAnnotation(PersonalInfo.class)));
    }

    private void writeSections(Class<?> cls) {
        writeExperiences(cls);
        writeFormations(cls);
        writeProjects(cls);
        writeSkills(cls);
        writeAccounts(cls);
    }

    private void writeSectionHeader(String label) {
        htmlWriter.writeOpeningTagWithClass("div", "section")
                .writeOpeningTagWithClass("div", "label")
                .writeContent(label)
                .writeClosingTag("div")
                .writeOpeningTagWithClass("div", "content-wrapper");
    }

    private void writeExperiences(Class<?> cls) {
        writeSectionHeader("Expérience");

        Experience[] experiences = cls.getAnnotation(Experiences.class).value();
        Arrays.asList(experiences).forEach(this::writeExperience);

        htmlWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }

    private void writeExperience(Experience experience) {
        htmlWriter.writeContent(new ExperienceFormatter(experience));
    }

    private void writeFormations(Class<?> cls) {
        writeSectionHeader("Formation");

        Formation[] formations = cls.getAnnotation(Formations.class).value();
        Arrays.asList(formations).forEach(this::writeFormation);

        htmlWriter.writeClosingTag("div")
                .writeClosingTag("div");
    }

    private void writeFormation(Formation formation) {
        htmlWriter.writeContent(new FormationFormatter(formation));
    }

    private void writeAccounts(Class<?> cls) {
        htmlWriter.writeOpeningTagWithClass("div", "section");
        Account[] accounts = cls.getAnnotation(Accounts.class).value();
        Arrays.asList(accounts).forEach(this::writeAccount);
        htmlWriter.writeClosingTag("div");
    }

    private void writeAccount(Account account) {
        htmlWriter.writeContent(new AccountFormatter(account));
    }

    private void writeProjects(Class<?> cls) {
        writeSectionHeader("Projets réalisés");
        htmlWriter.writeOpeningTagWithClass("div", "content");

        Project[] projects = cls.getAnnotation(Projects.class).value();
        Arrays.asList(projects).forEach(this::writeProject);

        htmlWriter.writeClosingTag("div")
                .writeClosingTag("div")
                .writeClosingTag("div");
    }

    private void writeProject(Project project) {
        htmlWriter.writeContent(new ProjectFormatter(project));
    }

    private void writeSkills(Class<?> cls) {
        writeSectionHeader("Compétences");
        htmlWriter.writeOpeningTagWithClass("div", "content");

        Skill[] skills = cls.getAnnotation(Skills.class).value();
        Arrays.asList(skills).forEach(this::writeSkill);

        htmlWriter.writeClosingTag("div")
                .writeClosingTag("div")
                .writeClosingTag("div");
    }

    private void writeSkill(Skill skill) {
        htmlWriter.writeContent(new SkillFormatter(skill));
    }

}
