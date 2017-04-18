package com.developerxy.resume.models;

import com.developerxy.resume.sections.personal.PersonalInfo;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class PersonalInfoModel {
    private String ownerName;
    private String ownerDescription;
    private String email;
    private String website;
    private String phoneNumber;

    public PersonalInfoModel(PersonalInfo personalInfo) {
        ownerName = personalInfo.ownerName();
        ownerDescription = personalInfo.ownerDescription();
        email = personalInfo.email();
        website = personalInfo.website();
        phoneNumber = personalInfo.phoneNumber();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerDescription() {
        return ownerDescription;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
