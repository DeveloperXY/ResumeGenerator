package com.developerxy.resume.models;

import com.developerxy.resume.sections.acc.Account;

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

    public String getIcon() {
        return icon;
    }

    public String getNickname() {
        return nickname;
    }
}
