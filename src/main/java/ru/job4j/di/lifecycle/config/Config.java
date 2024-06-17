package ru.job4j.di.lifecycle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.job4j.di.lifecycle.model.Product;

/**
 * Аннотация {@link Configuration} указывает
 * на то, что в этом классе содержится
 * конфигурационная информация.
 *
 * Аннотация  {@link Bean} указывает
 * на то, что метод getProduct() вернет бин.
 *
 * Свойство name = "myProduct" указывает
 * на то, что бин в контексте будет
 * иметь имя "myProduct". При отсутствии
 * такой аннотации имя бина будет совпадать
 * с именем метода, который создает этот бин.
 * В нашем случае это имя было бы "getProduct".
 *
 * Свойства initMethod = "initMethod",
 * destroyMethod = "destroyMethod"
 * указывают фреймворку, какие методы
 * применить при инициализации бина и перед
 * уничтожением бина.
 */
@Configuration
public class Config {

    @Bean(name = "muProduct",
            initMethod = "initMethod",
            destroyMethod = "destroyMethod"
    )

    public Product getProduct() {
        return new Product("Good Product", 2.5);
    }
}
