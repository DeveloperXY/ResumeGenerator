package com.developerxy.resume;

import com.developerxy.resume.section.personal.PersonalInfo;
import com.developerxy.resume.util.Utils;
import com.developerxy.resume.util.writer.HTMLWriter;
import com.developerxy.resume.util.Output;
import com.developerxy.resume.util.Stylesheets;
import com.developerxy.resume.util.formatter.HeaderFormatter;
import com.developerxy.resume.util.writer.builder.SectionBuilder;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@Stylesheets({"style.css"})
public abstract class CV {
    public void build() {
        Class<?> cls = getClass();
        String outputLocation = cls.getAnnotation(Output.class).value();
        Stylesheets stylesheets = cls.getAnnotation(Stylesheets.class);

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

        } catch (Exception e) {
            System.err.println("An error occured while generating the resume.");
            e.printStackTrace();
        }
    }

}
