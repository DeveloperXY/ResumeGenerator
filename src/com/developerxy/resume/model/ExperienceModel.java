package com.developerxy.resume.model;

import com.developerxy.resume.section.exp.Experience;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class ExperienceModel extends AbstractModel {
    private String title;
    private String when;
    private String description;

    public ExperienceModel(Experience experience) {
        title = experience.title();
        when = experience.when();
        description = experience.description();
    }

    public String getTitle() {
        return title;
    }

    public String getWhen() {
        return when;
    }

    public String getDescription() {
        return getLineBreakableContent(description);
    }
}
