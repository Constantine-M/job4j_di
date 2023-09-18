package ru.job4j_di.annotation;

import org.springframework.stereotype.Component;

public class Dog implements Pet<Dog> {

    private String name = "Dog";

    public Dog() {

    }

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String print() {
        return "Dog name = %s".formatted(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
