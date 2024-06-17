package ru.job4j.di.javacodebased;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Данный класс является конфигурационным,
 * т.е. содержит конфиг-ую инфу. Об этом
 * как раз фреймворку Spring сообщает
 * аннотация {@link Configuration}.
 *
 * Файла с XML конфигой нет совсем.
 * Аннотация {@link ComponentScan} дает
 * информацию о пакете, который фреймворк
 * должен просканировать при поиске
 * компонентов.
 *
 * Аннотация {@link PropertySource} сообщает,
 * что программе требуется информация
 * из файла свойств application.properties.
 *
 * Аннотация {@link Bean} указывает,
 * что результат вызова метода должен
 * стать бином и быть помещен в контекст.
 *
 * 1.Заметь, что здесь не сконфигурирован
 * бин класса {@link Person}, потому что
 * там используется аннотация
 * {@link Component}.
 * 2.Заметь, что у кота задано дефолтное
 * имя "simpleCat" через двоеточие.
 * Но так как у нас еще задано имя
 * в файле application.properties, то
 * будет использоваться в первую очередь имя
 * из файла. Если там будет пусто, то
 * только в таком случае мы увидим
 * имя "simpleCat".
 */
@Configuration
@ComponentScan("ru.job4j.di.javacodebased")
@PropertySource("classpath:application.properties")
public class Config {

    @Value("${parrot.name:Kesha}")
    private String parrotName;

    @Value("${canary.name:Roza}")
    private String canaryName;

    @Value("${cat.name:simpleCat}")
    private String catName;

    @Value("${dog.name:AlfaDog}")
    private String dogName;

    @Bean
    public BirdFactory birdFactory() {
        return new BirdFactory();
    }

    @Bean
    public Parrot parrot() {
        return birdFactory().getParrot(parrotName);
    }

    @Bean
    public Canary canary() {
        return birdFactory().getCanary(canaryName);
    }

    @Bean (
            name = "myDog",
            initMethod = "postConstruct"
    )
    public Dog dog() {
        return new Dog(dogName);
    }

    @Bean
    public Cat cat() {
        return Cat.createCat(catName);
    }
}
