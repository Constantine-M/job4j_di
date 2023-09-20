package ru.job4j_di.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP - это парадигма программирования, основанная
 * на идее разделения основного и служебного функционала.
 *
 * При этом служебный функционал записывается в
 * так называемые Aspect-классы.
 *
 * Для реализации АОП нам понадобится
 * аннотация {@link EnableAspectJAutoProxy},
 * и дополнительная зависимость в POM.xml.
 *
 * Добавив аннотацию {@link EnableAspectJAutoProxy}
 * в конфигурационный класс, мы тем самым подключили
 * и активировали механизм аспектов.
 *
 * Задача: добавить служебный функционал.
 * Например, обеспечить запись в лог имя
 * вызываемого метода, передаваемые ему
 * аргументы и возвращаемое им значение.
 */
@Configuration
@ComponentScan(basePackages = "ru.job4j_di.aop")
@EnableAspectJAutoProxy
public class Config {


}
