package com.developerxy.resume;

import com.developerxy.resume.sections.personal.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
public abstract class CV {
    public void build() {
        Class<?> cls = getClass();
        PrintWriter out;
        try {
            out = new PrintWriter("resources/index.html");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println(getHead());
            out.println("<body>");
            out.println("<div class=\"wrapper\">");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        PersonalInfo personalInfo = cls.getAnnotation(PersonalInfo.class);
        OwnerName ownerName = personalInfo.ownerName();
        OwnerDescription ownerDescription = personalInfo.ownerDescription();
        Email email = personalInfo.email();
        Website website = personalInfo.website();
        PhoneNumber phoneNumber = personalInfo.phoneNumber();
        out.println(getFormattedHeader(
                ownerName.value(),
                ownerDescription.value(),
                email.value(),
                website.value(),
                phoneNumber.value()
        ));

        out.println("</div>"); // end of wrapper div
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    private String getHead() {
        return "<head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "        <link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet'\n" +
                "              type='text/css'>\n" +
                "        <link rel=\"stylesheet\" href=\"./style.css\">\n" +
                "    </head>";
    }

    private String getFormattedHeader(String ownerName, String ownerDescription,
                                      String email, String website, String phoneNumber) {
        return String.format("<div class=\"header\">\n" +
                        "                <div class=\"profile_image\"></div>\n" +
                        "                <div class=\"name\">\n" +
                        "                    <span>%s</span>\n" +
                        "                    <span>%s</span>\n" +
                        "                </div>\n" +
                        "                <div class=\"details\">\n" +
                        "                    <span>e: %s</span>\n" +
                        "                    <span>w: %s</span>\n" +
                        "                    <span>m: %s</span>\n" +
                        "                </div>\n" +
                        "            </div>",
                ownerName, ownerDescription, email, website, phoneNumber);
    }
}
