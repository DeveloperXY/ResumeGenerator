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
        this.ownerName = personalInfo.ownerName().value();
        this.ownerDescription = personalInfo.ownerDescription().value();
        this.email = personalInfo.email().value();
        this.website = personalInfo.website().value();
        this.phoneNumber = personalInfo.phoneNumber().value();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerDescription() {
        return ownerDescription;
    }

    public void setOwnerDescription(String ownerDescription) {
        this.ownerDescription = ownerDescription;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
