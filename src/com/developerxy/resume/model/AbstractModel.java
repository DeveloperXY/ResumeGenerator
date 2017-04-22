package com.developerxy.resume.model;

/**
 * Created by Mohammed Aouf ZOUAG on 22/04/2017.
 *
 * The base class of all section model classes.
 */
public abstract class AbstractModel {
    /**
     * @param content entry data
     * @return formatted entry data, replacing \n characters with line breaks.
     */
    protected String getLineBreakableContent(String content) {
        return content.replaceAll("\n", "<br/>");
    }
}
