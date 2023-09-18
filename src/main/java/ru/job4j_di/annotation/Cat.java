package ru.job4j_di.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat implements Pet<Cat> {

    /**
     * Аннотация {@link Value} используется
     * на уровне параметра поля или
     * метода / конструктора и указывает
     * значение по умолчанию для затронутого
     * аргумента.
     *
     * В данном случае значение по умолчанию
     * мы можем хранить в файле
     * application.properties.
     *
     * Это позволяет нам менять значение
     * поля без перекомпилирования.
     */
    @Value("${cat.name}")
    private String name;

    @Override
    public String print() {
        return "Cat name = %s".formatted(name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
