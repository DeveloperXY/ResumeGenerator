package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.AccountModel;
import com.developerxy.resume.section.acc.Account;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class AccountFormatter implements HTMLFormatter<Account> {

    @Override
    public String format(Account account) {
        AccountModel model = new AccountModel(account);
        return String.format("<div class=\"social\">\n" +
                        "                        <img class=\"social-icon\" src=\"%s\">\n" +
                        "                        <span class=\"social-nickname\">@%s</span>\n" +
                        "                    </div>",
                model.getIcon(), model.getNickname());
    }
}
