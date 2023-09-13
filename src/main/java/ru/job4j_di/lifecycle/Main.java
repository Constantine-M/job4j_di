package ru.job4j_di.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Для иллюстрации жизненного цикла Spring Bean
 * мы создали пакет lifecycle, который
 * разбили логически еще на несколько
 * пакетов.
 *
 * При создании контекста в конструктор
 * передаем имя пакета, в котором
 * располагаются все компоненты.
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.job4j_di.lifecycle");
        context.close();
    }
}
