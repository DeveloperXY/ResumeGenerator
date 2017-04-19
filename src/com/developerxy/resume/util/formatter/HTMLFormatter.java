package com.developerxy.resume.util.formatter;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public abstract class HTMLFormatter<T> {
    protected T model;

    public HTMLFormatter(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract String format();
}
