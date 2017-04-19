package com.developerxy.resume.util.writer;

import com.developerxy.resume.section.personal.PersonalInfo;
import com.developerxy.resume.util.formatter.PersonalInfoFormatter;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class PersonalInfoWriter extends SectionWriter {
    @Override
    public void writeSection() {
        mHTMLWriter.writeContent(new PersonalInfoFormatter(
                mSourceClass.getAnnotation(PersonalInfo.class)));
    }
}
