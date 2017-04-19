package com.developerxy.resume.util.format;

import com.developerxy.resume.models.SkillsModel;
import com.developerxy.resume.sections.skill.Skill;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class SkillFormatter extends HTMLFormatter<SkillsModel> {
    public SkillFormatter(SkillsModel model) {
        super(model);
    }

    public SkillFormatter(Skill skill) {
        super(new SkillsModel(skill));
    }

    @Override
    public String format() {
        StringJoiner sj = new StringJoiner(", ");
        Arrays.asList(model.getRelated())
                .forEach(item -> sj.add(String.format("<span>%s</span>\n", item)));

        return String.format("<div class=\"row\">\n<span class=\"keyword\">%s: </span>%s</div>",
                model.getName(), sj.toString());
    }
}
