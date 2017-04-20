package com.developerxy.resume.util.writer;

import com.developerxy.resume.util.formatter.HTMLFormatter;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public abstract class SectionWriter<T> {

    protected static HTMLWriter mHTMLWriter;
    protected static Class<?> mSourceClass;
    protected HTMLFormatter<T> mFormatter;

    public static void initialize(Class<?> cls, HTMLWriter htmlWriter) {
        mSourceClass = cls;
        mHTMLWriter = htmlWriter;
    }

    public SectionWriter(HTMLFormatter<T> formatter) {
        mFormatter = formatter;
    }

    protected void writeSectionHeader(String label) {
        mHTMLWriter.writeOpeningTagWithClass("div", "section")
                .writeOpeningTagWithClass("div", "label")
                .writeContent(label)
                .writeClosingTag("div")
                .writeOpeningTagWithClass("div", "content-wrapper");
    }

    public abstract void writeSection();
}
