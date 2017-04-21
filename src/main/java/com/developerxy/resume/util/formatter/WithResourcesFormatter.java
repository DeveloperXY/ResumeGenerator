package com.developerxy.resume.util.formatter;

/**
 * Created by Mohammed Aouf ZOUAG on 20/04/2017.
 *
 * An abstract formatter class that operates on a given resources repository.
 */
public abstract class WithResourcesFormatter<T> implements HTMLFormatter<T> {
    protected String mResourcesRepository;

    public WithResourcesFormatter() {
        this("");
    }

    public WithResourcesFormatter(String resourcesRepository) {
        mResourcesRepository = resourcesRepository;
    }

    public String getResourcesRepository() {
        return mResourcesRepository;
    }
}
