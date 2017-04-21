package com.developerxy.resume.util;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 20/04/2017.
 *
 * This annotation specifies a custom home directory, & the name of the generated HTML file.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OutputLocation {
    String directory() default FileUtils.DEFAULT_TOP_LEVEL_DIRECTORY_NAME;
    String fileName() default "index.html";
}
