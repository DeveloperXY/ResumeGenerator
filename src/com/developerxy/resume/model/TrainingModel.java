package com.developerxy.resume.model;

import com.developerxy.resume.section.training.Training;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class TrainingModel extends AbstractModel {
    private String when;
    private String description;

    public TrainingModel(Training formation) {
        when = formation.when();
        description = formation.description();
    }

    public String getWhen() {
        return when;
    }

    public String getDescription() {
        return getLineBreakableContent(description);
    }
}
