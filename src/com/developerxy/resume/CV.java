package com.developerxy.resume;

import com.developerxy.resume.section.personal.PersonalInfo;
import com.developerxy.resume.util.FileUtils;
import com.developerxy.resume.util.OutputLocation;
import com.developerxy.resume.util.Stylesheets;
import com.developerxy.resume.util.formatter.HeaderFormatter;
import com.developerxy.resume.util.writer.HTMLWriter;
import com.developerxy.resume.util.writer.builder.SectionBuilder;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@OutputLocation
@Stylesheets({"style.css"})
public abstract class CV {
    public void build() {
        Class<?> cls = getClass();
        Stylesheets stylesheets = cls.getAnnotation(Stylesheets.class);
        OutputLocation outputLocation = cls.getAnnotation(OutputLocation.class);
        String outputFileName = FileUtils.getOutputFileName(outputLocation);

        checkOutputFileRequiredCriteria(outputFileName);

        try (HTMLWriter htmlWriter = new HTMLWriter(outputFileName)) {
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
                    "The resume has been successfully created in the following location: %s", outputFileName));
            FileUtils.openFileInBrowser(outputFileName);

        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Error while generating resume: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occur while generating the resume.");
            e.printStackTrace();
        }
    }

    /**
     * @param outputLocation the path of the output file to be created.
     *                       This method checks if the output file name has a .html extension
     *                       & creates its necessary parent directories.
     */
    private void checkOutputFileRequiredCriteria(String outputLocation) {
        FileUtils.checkIfOutputFileHasHtmlExtension(outputLocation);
        FileUtils.createOutputPath(outputLocation);
    }
}
