package ru.job4j.di.di.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Constantine on 17.06.2024
 */
public class SpringDI {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class, StartUI.class, ConsoleInput.class);
        context.refresh();
        var input = context.getBean(ConsoleInput.class);
        var store = context.getBean(Store.class);
        StartUI ui = context.getBean(StartUI.class);
        ui.init(store, input);
    }
}
