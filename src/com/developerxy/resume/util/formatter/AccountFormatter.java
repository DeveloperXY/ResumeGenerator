package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.AccountModel;
import com.developerxy.resume.section.acc.Account;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class AccountFormatter extends WithResourcesFormatter<Account> {

    public AccountFormatter(String resourcesRepository) {
        super(resourcesRepository);
    }

    @Override
    public String format(Account account) {
        AccountModel model = new AccountModel(account);
        if (!mResourcesRepository.isEmpty()) {
            model.setIcon(mResourcesRepository + "/" + model.getIcon());
        }
        return formatModel(model);
    }

    private String formatModel(AccountModel model) {
        return String.format("<div class=\"social\">\n" +
                        "                        <img class=\"social-icon\" src=\"%s\">\n" +
                        "                        <span class=\"social-nickname\">@%s</span>\n" +
                        "                    </div>",
                model.getIcon(), model.getNickname());
    }
}
