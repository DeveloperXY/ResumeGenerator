# ResumeGenerator
A Java API that relies on annotations to generate CVs in HTML format.

# Prerequisites
You need JDK8 or above to run this API.

# Usage
1. Create a class that extends the `CV` class (located in the `com.developerxy.resume` package):

~~~~
    public class MyResume extends CV {
    
    }
~~~~

2. Use the provided `@PersonalInfo`, `@Experiences`, `@Formations`, `@Projects`, `@Skills`, `@Accounts`
to generate the sections of the resume that you want.

3. Create an instance of your class, & call the `build()` method on it to generate the resume:
~~~~
    public static void main(String[] args) {
        new MyResume().build();
    }
~~~~

# Documentation
https://github.com/DeveloperXY/ResumeGenerator/wiki
