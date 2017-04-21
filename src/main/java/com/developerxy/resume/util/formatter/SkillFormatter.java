package com.developerxy.resume.util.formatter;

import com.developerxy.resume.model.SkillModel;
import com.developerxy.resume.section.skill.Skill;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class SkillFormatter implements HTMLFormatter<Skill> {

    @Override
    public String format(Skill skill) {
        SkillModel model = new SkillModel(skill);
        StringJoiner sj = new StringJoiner(", ");
        Arrays.asList(model.getRelated())
                .forEach(item -> sj.add(String.format("<span>%s</span>\n", item)));

        return String.format("<div class=\"row\">\n<span class=\"keyword\">%s: </span>%s</div>",
                model.getName(), sj.toString());
    }
}
