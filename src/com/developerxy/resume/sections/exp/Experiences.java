package com.developerxy.resume.sections.exp;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Experiences {
    Experience[] value();
}
