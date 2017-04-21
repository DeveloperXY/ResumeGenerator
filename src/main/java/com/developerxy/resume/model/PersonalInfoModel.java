package com.developerxy.resume.model;

import com.developerxy.resume.section.personal.PersonalInfo;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class PersonalInfoModel {
    private String ownerName;
    private String avatar;
    private String ownerDescription;
    private String email;
    private String website;
    private String phoneNumber;

    public PersonalInfoModel(PersonalInfo personalInfo) {
        ownerName = personalInfo.ownerName();
        avatar = personalInfo.avatar();
        ownerDescription = personalInfo.ownerDescription();
        email = personalInfo.email();
        website = personalInfo.website();
        phoneNumber = personalInfo.phoneNumber();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getAvatar() {
        return avatar;
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

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setOwnerDescription(String ownerDescription) {
        this.ownerDescription = ownerDescription;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
