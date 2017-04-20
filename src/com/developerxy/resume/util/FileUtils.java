package com.developerxy.resume.util;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FileUtils {
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
            File resourceStylesheet = new File("style.css");
            File generatedStylesheet = new File(cssFileLocation);

            FileChannel src = new FileInputStream(resourceStylesheet).getChannel();
            FileChannel dest = new FileOutputStream(generatedStylesheet).getChannel();
            dest.transferFrom(src, 0, src.size());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
