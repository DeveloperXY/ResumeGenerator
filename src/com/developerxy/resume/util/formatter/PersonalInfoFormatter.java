package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.PersonalInfoModel;
import com.developerxy.resume.section.personal.PersonalInfo;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class PersonalInfoFormatter extends WithResourcesFormatter<PersonalInfo> {

    public PersonalInfoFormatter(String resourcesRepository) {
        super(resourcesRepository);
    }

    @Override
    public String format(PersonalInfo personalInfo) {
        PersonalInfoModel model = new PersonalInfoModel(personalInfo);
        if (!mResourcesRepository.isEmpty()) {
            model.setAvatar(mResourcesRepository + "/" + model.getAvatar());
        }
        return String.format("<div class=\"header\">\n" +
                        "                <img class=\"profile_image\" src=\"%s\"/>\n" +
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
                model.getAvatar(), model.getOwnerName(), model.getOwnerDescription(),
                model.getEmail(), model.getWebsite(), model.getPhoneNumber());
    }
}
