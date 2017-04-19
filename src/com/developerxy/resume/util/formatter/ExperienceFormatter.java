package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.ExperienceModel;
import com.developerxy.resume.section.exp.Experience;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class ExperienceFormatter extends HTMLFormatter<ExperienceModel> {
    public ExperienceFormatter(ExperienceModel model) {
        super(model);
    }

    public ExperienceFormatter(Experience experience) {
        super(new ExperienceModel(experience));
    }

    @Override
    public String format() {
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
