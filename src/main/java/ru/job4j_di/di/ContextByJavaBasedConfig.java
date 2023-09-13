package ru.job4j_di.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import ru.job4j_di.di.model.StartUI;

/**
 * Данный класс описывает создание и
 * получение бина через ApplicationContext
 * при использовании аннотаций.
 *
 * Для этого мы уже добавили над
 * нашими моделями аннотации
 * {@link Component}
 *
 * 1.Теперь мы создаем контекст и всего лишь
 * передаем ему адрес пакета, где находятся классы,
 * предназначенные для помещения в контекст.
 *
 * - ApplicationContext загружает
 * все компоненты при запуске.
 * - ApplicationContext обладает
 * гораздо более широким функционалом,
 * чем {@link BeanFactory}.
 */
public class ContextByJavaBasedConfig {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext("ru.job4j_di.model");
        var ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
