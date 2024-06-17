package ru.job4j.di.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainXmlApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app-context-xml.xml");
        Man man = context.getBean(Man.class);
        man.print();
    }
}
