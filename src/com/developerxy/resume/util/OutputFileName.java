package com.developerxy.resume.util;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 *
 * Determines the output location of the generated HTML resume.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OutputFileName {
    String value();
}
