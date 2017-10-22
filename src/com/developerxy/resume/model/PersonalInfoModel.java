package com.developerxy.resume.model;

import com.developerxy.resume.section.personal.PersonalInfo;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class PersonalInfoModel extends AbstractModel {
    private String ownerName;
    private String avatar;
    private String ownerDescription;
    private String email;
    private String phoneNumber;
    private String address;

    public PersonalInfoModel(PersonalInfo personalInfo) {
        ownerName = personalInfo.ownerName();
        avatar = personalInfo.avatar();
        ownerDescription = personalInfo.ownerDescription();
        email = personalInfo.email();
        phoneNumber = personalInfo.phoneNumber();
        address = personalInfo.address();
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

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
