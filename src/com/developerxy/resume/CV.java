package com.developerxy.resume;

import com.developerxy.resume.section.personal.PersonalInfo;
import com.developerxy.resume.util.OutputFileName;
import com.developerxy.resume.util.Stylesheets;
import com.developerxy.resume.util.Utils;
import com.developerxy.resume.util.formatter.HeaderFormatter;
import com.developerxy.resume.util.writer.HTMLWriter;
import com.developerxy.resume.util.writer.builder.SectionBuilder;

import java.io.File;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@OutputFileName("generated/index.html")
@Stylesheets({"style.css"})
public abstract class CV {
    public void build() {
        Class<?> cls = getClass();
        String outputLocation = cls.getAnnotation(OutputFileName.class).value();
        Stylesheets stylesheets = cls.getAnnotation(Stylesheets.class);

        if (isOutputFileADirectory(outputLocation))
            throw new IllegalArgumentException(
                    "The @OutputFileName must refer to a file name, not a directory's.");

        try (HTMLWriter htmlWriter = new HTMLWriter(outputLocation)) {
            SectionBuilder sectionBuilder = new SectionBuilder(htmlWriter, cls);

            htmlWriter.setDoctype()
                    .writeOpeningTag("html")
                    .writeContent(new HeaderFormatter(stylesheets))
                    .writeOpeningTag("body")
                    .writeOpeningTagWithClass("div", "wrapper");

            // Check that the resume class is @PersonalInfo annotated
            PersonalInfo personalInfo = cls.getAnnotation(PersonalInfo.class);
            if (personalInfo == null) {
                System.err.println("You must annotate your resume class with the @PersonalInfo annotation to provide personal information data.");
                System.exit(0);
            }

            sectionBuilder.buildPersonalInfoSection();
            htmlWriter.writeOpeningTagWithClass("div", "main");
            sectionBuilder.buildResumeSections(this);

            htmlWriter.writeClosingTag("div")
                    .writeClosingTag("div")
                    .writeClosingTag("body")
                    .writeClosingTag("html");

            System.out.println(String.format(
                    "The resume has been successfully created in the following location: %s", outputLocation));
            Utils.openFileInBrowser(outputLocation);

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Error while generating resume: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occur while generating the resume.");
            e.printStackTrace();
        }
    }

    private boolean isOutputFileADirectory(String outputLocation) {
        File file = new File(outputLocation);
        return file.isDirectory();
    }
}
