package com.developerxy.resume.model;

import com.developerxy.resume.section.formation.Formation;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
public class FormationModel {
    private String when;
    private String description;

    public FormationModel(Formation formation) {
        when = formation.when();
        description = formation.description();
    }

    public String getWhen() {
        return when;
    }

    public String getDescription() {
        return description;
    }
}
