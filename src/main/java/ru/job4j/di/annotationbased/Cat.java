package ru.job4j.di.annotationbased;

public class Cat {

    private String name;

    private Cat() {
    }

    public static Cat createCat(String name) {
        Cat cat = new Cat();
        cat.name = name;
        return cat;
    }

    public String getName() {
        return name;
    }
}
