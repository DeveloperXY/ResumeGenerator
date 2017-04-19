package com.developerxy.resume.util;

import com.developerxy.resume.util.formatter.HTMLFormatter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class HTMLWriter implements AutoCloseable {
    private PrintWriter out;

    public HTMLWriter(String outputLocation) {
        try {
            out = new PrintWriter(outputLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public HTMLWriter setDoctype() {
        out.println("<!DOCTYPE html>");
        return this;
    }

    public HTMLWriter writeOpeningTag(String tag) {
        out.println(String.format("<%s>", tag));
        return this;
    }

    public HTMLWriter writeOpeningTagWithClass(String tag, String clazz) {
        out.println(String.format("<%s class=\"%s\">", tag, clazz));
        return this;
    }

    public HTMLWriter writeClosingTag(String tag) {
        out.println(String.format("</%s>", tag));
        return this;
    }

    public HTMLWriter writeContent(String content) {
        out.println(content);
        return this;
    }

    public HTMLWriter writeContent(HTMLFormatter htmlFormatter) {
        out.println(htmlFormatter.format());
        return this;
    }

    @Override
    public void close() throws Exception {
        out.close();
    }
}
