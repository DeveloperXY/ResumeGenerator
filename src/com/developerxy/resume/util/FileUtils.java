package com.developerxy.resume.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
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

    public static boolean isFileADirectory(String fileName) {
        File file = new File(fileName);
        return file.isDirectory();
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
}
