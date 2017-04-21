package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.FormationModel;
import com.developerxy.resume.section.training.Training;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class FormationFormatter implements HTMLFormatter<Training> {

    @Override
    public String format(Training formation) {
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
