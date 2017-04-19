package com.developerxy.resume.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class Utils {
    public static void openFileInBrowser(String url) {
        int delaySeconds = 3;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                try {
                    File htmlFile = new File(url);
                    Desktop.getDesktop().browse(htmlFile.toURI());
                    timer.cancel();
                    timer.purge();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        timer.schedule(task, delaySeconds * 1000);
        System.out.println(String.format("Your browser will open in %d seconds...", delaySeconds));
    }
}
