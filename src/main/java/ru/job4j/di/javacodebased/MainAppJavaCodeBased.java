package ru.job4j.di.javacodebased;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAppJavaCodeBased {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Person person = context.getBean("myPerson", Person.class);
        person.printNamesPets();
        context.close();
    }
}
