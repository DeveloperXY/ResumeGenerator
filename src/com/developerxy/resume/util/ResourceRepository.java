package com.developerxy.resume.util;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 20/04/2017.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ResourceRepository {
    /**
     * @return the location of the resources directory to be used.
     * This path is relative to the location of the resume's HTML file,
     * as indicated via the @OutputLocation parameters.
     */
    String value();
}
