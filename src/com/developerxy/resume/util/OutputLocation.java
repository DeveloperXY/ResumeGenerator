package com.developerxy.resume.util;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 20/04/2017.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface OutputLocation {
    String directory() default "generated/";
    String fileName() default "index.html";
}
