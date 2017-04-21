package com.developerxy.resume.model;

import com.developerxy.resume.section.acc.Account;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class AccountModel {
    private String icon;
    private String nickname;

    public AccountModel(Account account) {
        icon = account.icon();
        nickname = account.nickname();
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public String getNickname() {
        return nickname;
    }
}
