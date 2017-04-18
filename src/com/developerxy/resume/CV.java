package com.developerxy.resume;

import com.developerxy.resume.models.PersonalInfoModel;
import com.developerxy.resume.sections.personal.PersonalInfo;
import com.developerxy.resume.util.HTMLWriter;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
public abstract class CV {

    private HTMLWriter htmlWriter;

    public void build() {
        Class<?> cls = getClass();
        try (HTMLWriter htmlWriter = new HTMLWriter("resources/index.html")) {
            this.htmlWriter = htmlWriter;
            htmlWriter.setDoctype()
                    .writeOpeningTag("html")
                    .writeContent(getHeadRawText())
                    .writeOpeningTag("body")
                    .writeOpeningTagWithClass("div", "wrapper");

            writePersonalInfo(cls);

            htmlWriter.writeClosingTag("div")
                    .writeClosingTag("body")
                    .writeClosingTag("html");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void writePersonalInfo(Class<?> cls) {
        htmlWriter.writeContent(getFormattedHeader(
                new PersonalInfoModel(cls.getAnnotation(PersonalInfo.class))));
    }

    private String getHeadRawText() {
        return "<head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "        <link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet'\n" +
                "              type='text/css'>\n" +
                "        <link rel=\"stylesheet\" href=\"./style.css\">\n" +
                "    </head>";
    }

    private String getFormattedHeader(PersonalInfoModel model) {
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
                model.getOwnerName(), model.getOwnerDescription(), model.getEmail(),
                model.getWebsite(), model.getPhoneNumber());
    }
}
