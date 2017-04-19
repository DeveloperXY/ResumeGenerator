package com.developerxy.resume.util.format;

import com.developerxy.resume.util.Stylesheets;

import java.util.Arrays;
import java.util.StringJoiner;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class HeaderFormatter extends HTMLFormatter<Stylesheets> {
    public HeaderFormatter(Stylesheets stylesheets) {
        super(stylesheets);
    }

    @Override
    public String format() {
        String[] stylesheets = model.value();
        StringJoiner sj = new StringJoiner("\n");
        Arrays.asList(stylesheets)
                .forEach(stylesheet -> sj.add(String.format("<link rel=\"stylesheet\" href=\"%s\">", stylesheet)));

        return String.format("<head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "        <link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet'\n" +
                "              type='text/css'>\n" +
                "        %s\n" +
                "    </head>", sj.toString());
    }
}
