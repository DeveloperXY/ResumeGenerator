package com.developerxy.resume.util.format;

import com.developerxy.resume.models.AccountModel;
import com.developerxy.resume.sections.acc.Account;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class AccountFormatter extends HTMLFormatter<AccountModel> {
    public AccountFormatter(AccountModel model) {
        super(model);
    }

    public AccountFormatter(Account account) {
        super(new AccountModel(account));
    }

    @Override
    public String format() {
        return String.format("<div class=\"social\">\n" +
                        "                        <img class=\"social-icon\" src=\"%s\">\n" +
                        "                        <span class=\"social-nickname\">@%s</span>\n" +
                        "                    </div>",
                model.getIcon(), model.getNickname());
    }
}
