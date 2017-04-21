package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.ExperienceModel;
import com.developerxy.resume.section.exp.Experience;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ExperienceFormatter implements HTMLFormatter<Experience> {

    @Override
    public String format(Experience experience) {
        ExperienceModel model = new ExperienceModel(experience);
        return String.format("<div class=\"content row\">\n" +
                        "                            <span class=\"title\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                            <br/>\n" +
                        "                            <span class=\"date\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                            <br/>\n" +
                        "                            <span class=\"text\">\n" +
                        "                                %s\n" +
                        "                            </span>\n" +
                        "                        </div>",
                model.getTitle(), model.getWhen(), model.getDescription());
    }
}
