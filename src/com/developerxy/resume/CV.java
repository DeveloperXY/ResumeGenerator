package com.developerxy.resume;

import com.developerxy.resume.section.personal.PersonalInfo;
import com.developerxy.resume.util.FileUtils;
import com.developerxy.resume.util.OutputLocation;
import com.developerxy.resume.util.ResourceRepository;
import com.developerxy.resume.util.formatter.HeaderFormatter;
import com.developerxy.resume.util.writer.HTMLWriter;
import com.developerxy.resume.util.writer.builder.SectionBuilder;

import static com.developerxy.resume.util.FileUtils.DEFAULT_RESOURCES_DIRECTORY;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@OutputLocation
@ResourceRepository(DEFAULT_RESOURCES_DIRECTORY)
public abstract class CV {

    private static final String STYLESHEET_FILE = "styles.css";
    private String outputFileName;

    public CV build() {
        Class<?> cls = getClass();
        OutputLocation outputLocation = cls.getAnnotation(OutputLocation.class);
        outputFileName = FileUtils.getOutputFileName(outputLocation);

        checkOutputFileRequiredCriteria();

        try (HTMLWriter htmlWriter = new HTMLWriter(outputFileName)) {
            String resourcesRepository = cls.getAnnotation(ResourceRepository.class).value();
            SectionBuilder sectionBuilder = new SectionBuilder(htmlWriter, cls, resourcesRepository);

            htmlWriter.setDoctype()
                    .writeOpeningTag("html")
                    .writeContent(new HeaderFormatter().format(STYLESHEET_FILE))
                    .writeOpeningTag("body")
                    .writeOpeningTagWithClass("div", "wrapper");

            // Check that the resume class is @PersonalInfo annotated
            PersonalInfo personalInfo = cls.getAnnotation(PersonalInfo.class);
            if (personalInfo == null)
                throw new IllegalArgumentException("You must annotate your resume class with the @PersonalInfo annotation to provide personal information data.");

            sectionBuilder.buildPersonalInfoSection();
            htmlWriter.writeOpeningTagWithClass("div", "main");
            sectionBuilder.buildResumeSections(this);

            htmlWriter.writeClosingTag("div")
                    .writeClosingTag("div")
                    .writeClosingTag("body")
                    .writeClosingTag("html");

            System.out.println(String.format(
                    "The resume has been successfully created in the following location: %s", outputFileName));
            return this;

        } catch (Exception e) {
            System.err.println("An error occur while generating the resume.");
            e.printStackTrace();
        }

        return null;
    }

    public void openInBrowser() {
        FileUtils.openFileInBrowser(outputFileName);
    }

    /**
     * This method checks if the output file name has a .html extension,
     * creates its necessary parent directories, & generates the stylesheet file to be associated with the resume.
     */
    private void checkOutputFileRequiredCriteria() {
        FileUtils.checkIfOutputFileHasHtmlExtension(outputFileName);
        FileUtils.createOutputPath(outputFileName);
        FileUtils.generateStylesheetFile(outputFileName, STYLESHEET_FILE);
    }
}
