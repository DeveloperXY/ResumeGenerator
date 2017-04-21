package com.developerxy.resume.util.formatter;

/**
 * Created by Mohammed Aouf ZOUAG on 19/04/2017.
 */
public class HeaderFormatter implements HTMLFormatter<String> {

    @Override
    public String format(String model) {
        return String.format("<head>\n" +
                "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "        <link href='http://fonts.googleapis.com/css?family=Rokkitt:400,700|Lato:400,300' rel='stylesheet'\n" +
                "              type='text/css'>\n" +
                "        <link rel=\"stylesheet\" href=\"%s\">\n" +
                "    </head>", model);
    }
}
