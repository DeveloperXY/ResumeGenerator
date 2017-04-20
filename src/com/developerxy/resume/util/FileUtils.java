package com.developerxy.resume.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FileUtils {

    public static final String DEFAULT_TOP_LEVEL_DIRECTORY_NAME = "generated/";
    public static final String DEFAULT_RESOURCES_DIRECTORY = "resources";

    public static void openFileInBrowser(String url) {
        try {
            File htmlFile = new File(url);
            Desktop.getDesktop().browse(htmlFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Opening browser...");
    }

    public static void checkIfOutputFileHasHtmlExtension(String outputLocation) {
        String extension = outputLocation.substring(outputLocation.lastIndexOf(".") + 1);
        if (!Arrays.asList("html", "htm").contains(extension))
            throw new IllegalArgumentException(String.format(
                    "Invalid extension \".%s\" for the output file. It must have a `.html` extension.",
                    extension));
    }

    /**
     * @param outputLocation the annotation object
     * @return the path of the output file name
     */
    public static String getOutputFileName(OutputLocation outputLocation) {
        String outputDirectory = outputLocation.directory();
        String outputFileName = outputLocation.fileName();

        // Remove all slashes from the start of the output directory's name
        while (outputDirectory.startsWith("/"))
            outputDirectory = outputDirectory.substring(1);
        // Add a trailing slash to the output file name
        if (!outputDirectory.endsWith("/"))
            outputDirectory += "/";
        // Remove all slashes from the start of the output file's name
        while (outputFileName.startsWith("/"))
            outputFileName = outputFileName.substring(1);

        return outputDirectory + outputFileName;
    }

    public static void createOutputPath(String outputLocation) throws IllegalStateException {
        File file = new File(outputLocation);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            if (!parentFile.mkdirs()) {
                throw new IllegalStateException("Unable to create output directory.");
            }
        }
    }

    public static void generateStylesheetFile(String htmlFileLocation, String cssFileName) {
        try {
            File outputDirectory = new File(htmlFileLocation).getParentFile();
            String cssFileLocation = outputDirectory + "/" + cssFileName;
            File generatedStylesheet = new File(cssFileLocation);
            PrintWriter printWriter = new PrintWriter(generatedStylesheet);
            printWriter.write("* {\n" +
                    "    padding: 0;\n" +
                    "    margin: 0;\n" +
                    "    box-sizing: border-box;\n" +
                    "}\n" +
                    "\n" +
                    "body {\n" +
                    "    background-color: #181818;\n" +
                    "    font-family: 'Lato', helvetica, arial, sans-serif;\n" +
                    "    font-size: 16px;\n" +
                    "    color: #222;\n" +
                    "}\n" +
                    "\n" +
                    "div.wrapper {\n" +
                    "    background-color: #ededed;\n" +
                    "    width: 90%;\n" +
                    "    max-width: 800px;\n" +
                    "    margin: 30px auto;\n" +
                    "}\n" +
                    "\n" +
                    "div.header {\n" +
                    "    display: flex;\n" +
                    "    align-items: center;\n" +
                    "    justify-content: space-around;\n" +
                    "    padding: 25px 35px;\n" +
                    "    border-bottom: 2px solid #cf8a05;\n" +
                    "}\n" +
                    "\n" +
                    "div.details {\n" +
                    "    margin-left: auto;\n" +
                    "}\n" +
                    "\n" +
                    ".profile_image {\n" +
                    "    width: 90px;\n" +
                    "    height: 90px;\n" +
                    "    border-radius: 50px;\n" +
                    "}\n" +
                    "\n" +
                    "div.name {\n" +
                    "    padding: 0px 15px;\n" +
                    "    display: flex;\n" +
                    "    flex-direction: column;\n" +
                    "    justify-content: space-between;\n" +
                    "}\n" +
                    "\n" +
                    "div.name span:first-child {\n" +
                    "    font-size: 2em;\n" +
                    "    font-weight: 700;\n" +
                    "    font-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "}\n" +
                    "\n" +
                    "div.name span:last-child {\n" +
                    "    font-size: 1.5em;\n" +
                    "    font-family: 'Rokkitt', Helvetica, Arial, sans-serif\n" +
                    "}\n" +
                    "\n" +
                    "div.details {\n" +
                    "    display: flex;\n" +
                    "    flex-direction: column;\n" +
                    "    font-size: 0.9em;\n" +
                    "    align-self: flex-start;\n" +
                    "    color: #444;\n" +
                    "}\n" +
                    "\n" +
                    "div.main {\n" +
                    "    padding: 0 40px;\n" +
                    "}\n" +
                    "\n" +
                    "div.section {\n" +
                    "    display: flex;\n" +
                    "    padding: 20px 0;\n" +
                    "    border-bottom: 1px solid #dedede;\n" +
                    "}\n" +
                    "\n" +
                    "div.section .label {\n" +
                    "    width: 25%;\n" +
                    "    font-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "    font-style: italic;\n" +
                    "    font-size: 1.5em;\n" +
                    "    color: #cf8a05;\n" +
                    "}\n" +
                    "\n" +
                    "div.section .content-wrapper {\n" +
                    "    width: 75%;\n" +
                    "}\n" +
                    "\n" +
                    "div.section .content span.text {\n" +
                    "    font-size: 1em;\n" +
                    "    line-height: 1.4em;\n" +
                    "    margin-bottom: 20px;\n" +
                    "    color: #444;\n" +
                    "}\n" +
                    "\n" +
                    "div.section .content span.title {\n" +
                    "    font-family: 'Rokkitt', Helvetica, Arial, sans-serif;\n" +
                    "    font-size: 1.5em;\n" +
                    "    margin-bottom: -2px;\n" +
                    "}\n" +
                    "\n" +
                    "div.section .content span.date {\n" +
                    "    font-size: 0.8em;\n" +
                    "    font-style: italic;\n" +
                    "    margin-bottom: 3px;\n" +
                    "}\n" +
                    "\n" +
                    "div.skills {\n" +
                    "    display: flex;\n" +
                    "    justify-content: space-between;\n" +
                    "}\n" +
                    "\n" +
                    "span.keyword {\n" +
                    "    font-weight: bold;\n" +
                    "}\n" +
                    "\n" +
                    "div.row {\n" +
                    "    margin-bottom: 10px;\n" +
                    "}\n" +
                    "\n" +
                    "div.social {\n" +
                    "    margin-left: 10px;\n" +
                    "    width: 33%;\n" +
                    "    display: inline-flex;\n" +
                    "}\n" +
                    "\n" +
                    ".social-icon {\n" +
                    "    width: 60px;\n" +
                    "    height: 60px;\n" +
                    "}\n" +
                    "\n" +
                    ".social-nickname {\n" +
                    "    margin-left: 6px;\n" +
                    "    font-weight: bold;\n" +
                    "    position: relative;\n" +
                    "    transform: translateY(30%);\n" +
                    "}");
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}