package ru.job4j_di.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j_di.di.context.StartUI;
import ru.job4j_di.di.context.Store;

/**
 * Данный класс описывает создание бина
 * через ApplicationContext.
 *
 * ApplicationContext - это расширенный
 * интерфейс {@link BeanFactory}.
 *
 * 1.Создаем контекст.
 * 2.Регистрируем в контексте классы,
 * которые должны стать бинами и обновляем контекст.
 * 3.Получаем готовый бин и в дальнейшем
 * его используем.
 */
public class ContextByListOfClasses {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class, StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
