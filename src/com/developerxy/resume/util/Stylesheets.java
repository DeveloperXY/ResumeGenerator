package com.developerxy.resume.util;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 *
 * A utility annotation that specifies the location of the CSS stylesheets to be associated with the generated resume.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Stylesheets {
    String[] value();
}
