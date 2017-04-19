package com.developerxy.resume.util.format;

import com.developerxy.resume.models.PersonalInfoModel;
import com.developerxy.resume.sections.personal.PersonalInfo;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class PersonalInfoFormatter extends HTMLFormatter<PersonalInfoModel> {
    public PersonalInfoFormatter(PersonalInfoModel model) {
        super(model);
    }

    public PersonalInfoFormatter(PersonalInfo personalInfo) {
        super(new PersonalInfoModel(personalInfo));
    }

    @Override
    public String format() {
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
