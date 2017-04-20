package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.personal.PersonalInfo;
import com.developerxy.resume.util.formatter.HTMLFormatter;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class PersonalInfoWriter extends SectionWriter<PersonalInfo> {

    public PersonalInfoWriter(HTMLFormatter<PersonalInfo> formatter) {
        super(formatter);
    }

    @Override
    public void writeSection() {
        mHTMLWriter.writeContent(mFormatter.format(
                mSourceClass.getAnnotation(PersonalInfo.class)));
    }
}
