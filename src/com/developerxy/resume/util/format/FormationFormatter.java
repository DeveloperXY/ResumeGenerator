package com.developerxy.resume.util.format;

import com.developerxy.resume.models.FormationModel;
import com.developerxy.resume.sections.formation.Formation;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FormationFormatter extends HTMLFormatter<FormationModel> {
    public FormationFormatter(FormationModel model) {
        super(model);
    }

    public FormationFormatter(Formation formation) {
        super(new FormationModel(formation));
    }

    @Override
    public String format() {
        return String.format("<div class=\"content row\">\n" +
                        "                            <span class=\"title keyword\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                            <br/>\n" +
                        "                            <span class=\"text\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                        </div>",
                model.getWhen(), model.getDescription());
    }
}
