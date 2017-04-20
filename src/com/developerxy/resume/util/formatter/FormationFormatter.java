package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.FormationModel;
import com.developerxy.resume.section.formation.Formation;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FormationFormatter implements HTMLFormatter<Formation> {

    @Override
    public String format(Formation formation) {
        FormationModel model = new FormationModel(formation);
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
