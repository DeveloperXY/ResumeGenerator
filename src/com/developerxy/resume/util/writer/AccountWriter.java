package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.acc.Account;
import com.developerxy.resume.section.acc.Accounts;
import com.developerxy.resume.util.formatter.HTMLFormatter;

import java.util.Arrays;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class AccountWriter extends SectionWriter<Account> {

    public AccountWriter(HTMLFormatter<Account> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        mHTMLWriter.writeOpeningTagWithClass("div", "section");
        Account[] accounts = mSourceClass.getAnnotation(Accounts.class).value();
        Arrays.asList(accounts).forEach(a ->
                mHTMLWriter.writeContent(mFormatter.format(a)));
        mHTMLWriter.writeClosingTag("div");
    }
}
