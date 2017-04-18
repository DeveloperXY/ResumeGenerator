package com.developerxy.resume;

import com.developerxy.resume.sections.personal.*;
import com.developerxy.resume.util.HTMLWriter;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
public abstract class CV {
    public void build() {
        Class<?> cls = getClass();
        try (HTMLWriter htmlWriter = new HTMLWriter("resources/index.html")) {
            htmlWriter.setDoctype()
                    .writeOpeningTag("html")
                    .writeContent(getHead())
                    .writeOpeningTag("body")
                    .writeOpeningTagWithClass("div", "wrapper");

            PersonalInfo personalInfo = cls.getAnnotation(PersonalInfo.class);
            OwnerName ownerName = personalInfo.ownerName();
            OwnerDescription ownerDescription = personalInfo.ownerDescription();
            Email email = personalInfo.email();
            Website website = personalInfo.website();
            PhoneNumber phoneNumber = personalInfo.phoneNumber();
            htmlWriter.writeContent(getFormattedHeader(
                    ownerName.value(),
                    ownerDescription.value(),
                    email.value(),
                    website.value(),
                    phoneNumber.value()
            ));

            htmlWriter.writeClosingTag("div")
                    .writeClosingTag("body")
                    .writeClosingTag("html");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
