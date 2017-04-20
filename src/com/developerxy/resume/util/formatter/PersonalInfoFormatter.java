package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.PersonalInfoModel;
import com.developerxy.resume.section.personal.PersonalInfo;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class PersonalInfoFormatter implements HTMLFormatter<PersonalInfo> {

    @Override
    public String format(PersonalInfo personalInfo) {
        PersonalInfoModel model = new PersonalInfoModel(personalInfo);
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
