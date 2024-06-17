package ru.job4j.di.annotation;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Данный класс демонстрирует варианты
 * внедрения объектов, используя
 * аннотацию {@link Autowired} и
 * не только.
 */
@Component
public class Man {

    /**
     * Внедрение объекта непосредственно в поле.
     *
     * Преимущество в отсутствии дополнительного кода.
     * Недостаток в том, что поле нельзя объявить final,
     * соответственно объект нельзя выполнить неизменяемым.
     * Плюс сложности при тестировании класса - для
     * внедрения зависимости надо поднимать контекст.
     */
    @Autowired
    @Qualifier("SecondDog")
    private Dog dog;

    /**
     * Аннотация {@link Qualifier} позволяет
     * уточнить имя бина, который надо внедрить.
     *
     * Вместо связки аннотаций @Autowired + @Qualifier
     * можно использовать аннотацию
     * {@link Resource}.
     */
    @Resource(name = "someDog")
    private Dog dog1;

    private Bird bird;

    private Cat cat;

    @Autowired
    private Set<Pet> pets;

    /**
     * При внедрении в коллекцию будут
     * добавлены все подходящие бины,
     * которые находятся в контексте.
     */
    @Autowired
    private List<Pet<Dog>> dogs;

    /**
     * При внедрении в Map в качестве
     * ключа будет использовано имя бина.
     */
    @Autowired
    private Map<String, Pet<Dog>> mapDogs;

    /**
     * Внедрение объекта через конструктор.
     *
     * Наиболее рекомендуемый способ внедрения.
     * Можно создавать неизменяемые объекты,
     * простой процесс тестирования.
     */
    @Autowired
    public Man(Cat cat) {
        this.cat = cat;
    }

    /**
     * Внедрение объекта с помощью метода.
     *
     * Главный недостаток в том, что нельзя
     * создать неизменяемый объект.
     */
    @Autowired
    public void setBird(Bird bird) {
        this.bird = bird;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public void setDog1(Dog dog1) {
        this.dog1 = dog1;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    public void setDogs(List<Pet<Dog>> dogs) {
        this.dogs = dogs;
    }

    public void setMapDogs(Map<String, Pet<Dog>> mapDogs) {
        this.mapDogs = mapDogs;
    }

    public void print() {
        String ls = System.lineSeparator();
        /*System.out.printf("My Dog: %s%n", dog.print());*/
        System.out.printf("My SecondDog: %s%n", dog1.print());
        System.out.printf("My Cat: %s%n", cat.print());
        System.out.printf("My Bird: %s%n", bird.print());

        System.out.println(ls + "pets:");
        pets.forEach(s -> System.out.println(s.print()));
        System.out.println("dogs:");
        dogs.forEach(s -> System.out.println(s.print()));
        System.out.println("mapDogs:");
        mapDogs.forEach((key, value) -> System.out.printf("%s - %s%n", key, value.print()));
    }
}
