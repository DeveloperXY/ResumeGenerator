package com.developerxy.resume.sections.personal;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 17/04/2017.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PersonalInfo {
    String ownerName();
    String ownerDescription();
    String email();
    String website();
    String phoneNumber();
}
