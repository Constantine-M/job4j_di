package ru.job4j.di.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bird implements Pet<Bird> {

    /**
     * Здесь мы используем аннотацию
     * {@link Value} так же как и в
     * классе {@link Cat}, но в данном
     * случае имя по умолчанию не содержится
     * в файле application.properties.
     *
     * Специально на случай отсутствия
     * нужного свойства в аннотации
     * Value("${bird.name:simpleBird}")
     * после двоеточия добавлено значение,
     * которое будет присвоено переменной
     * по умолчанию.
     */
    @Value("${bird.name:simpleBird}")
    private String name = "Bird";

    @Override
    public String print() {
        return "Bird name = %s".formatted(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
