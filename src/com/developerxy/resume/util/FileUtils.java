package com.developerxy.resume.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

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

    public static void checkIfOutputFileIsADirectory(String outputLocation) throws IllegalArgumentException {
        File file = new File(outputLocation);
        if (file.isDirectory())
            throw new IllegalArgumentException(
                    "The @OutputFileName must refer to a file name, not a directory's.");
    }

    public static void checkIfOutputFileHasHtmlExtension(String outputLocation) {
        String extension = outputLocation.substring(outputLocation.lastIndexOf(".") + 1);
        if (!Arrays.asList("html", "htm").contains(extension))
            throw new IllegalArgumentException(String.format(
                    "Invalid extension \".%s\" for the output file. It must have a `.html` extension.",
                    extension));
    }
}
