package ru.job4j.di.xmlbased;

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
