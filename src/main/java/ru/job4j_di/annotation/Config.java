package ru.job4j_di.annotation;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;

/**
 * В данном классе находится конфигурационная
 * информация.
 *
 * Аннотация {@link ComponentScan} указывает
 * Spring'у пакет, в котором находятся
 * классы компонентов.
 *
 * Наименование бинов.
 * 1.Если бин создан с помощью аннотации @Component,
 * то имя бина будет именем класса с заменой первой
 * буквы с прописной на строчную (например,
 * имя бина из класса Cat будет "cat")
 *
 * 2.Если бин создан с помощью аннотации @Bean,
 * то он получит в качестве имени наименование метода,
 * в котором он создан (например, первый бин
 * из класса Config получит имя "getAlfaDog")
 *
 * Чтобы контекст знал, что в приложении
 * есть файл свойств, воспользуемся
 * аннотацией {@link PropertySource} и
 * укажем путь к файлу со свойствами.
 * Обрати внимание, что путь
 * src/main/resources заменяется
 * указанием "classpath".
 */
@Configuration
@ComponentScan(basePackages = "ru.job4j_di.annotation")
@PropertySource("classpath:application.properties")
public class Config {

    /**
     * Аннотация {@link Bean} указывает на то,
     * что возвращаемый методом объект будет
     * помещен в контекст.
     *
     * Аннотация {@link Primary} используется
     * для указания Spring'у, какой именно бин
     * использовать при внедрении при наличии
     * нескольких подходящих бинов-кандидатов.
     *
     * Аннотация {@link Order} используется
     * для указания порядка внедрения бинов.
     * После запуска программы бины в коллекции
     * будут расположены в порядке
     * возрастания номеров. Если будете проверять,
     * то для наглядности берите номера с 1 -
     * так вы точно увидите, что нужный бин
     * внедрился самым первым.
     */
    @Bean
    @Primary
    @Order(11)
    public Dog getAlfaDog() {
        return new Dog("AlfaDog");
    }

    /**
     * Данному бину мы сами назначили имя
     * "SecondDog".
     */
    @Bean(name = "SecondDog")
    @Order(3)
    public Dog getDog() {
        return new Dog("SecondDog");
    }

    @Bean
    @Order(5)
    public Dog someDog() {
        return new Dog("Dog");
    }
}
