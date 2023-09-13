package ru.job4j_di.di;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import ru.job4j_di.di.model.StartUI;
import ru.job4j_di.di.model.Store;

/**
 * Данный класс описывает процесс
 * внедрения зависимостей при использовании
 * Spring Framework.
 *
 * 1.Создаем фабрику бинов.
 * 2.Получаем метаданные о каждом бине, используя его java-код.
 * 3.Передаем метаданные о бинах в фабрику
 * (регистрация BeanDefinition).
 * 4.Фабрика по запросу создает нам нужный бин
 * и мы можем его использовать. То есть, на
 * основе BeanDefinition создается наш bean.
 *
 * - BeanFactory содержит только методы получения бинов.
 * - BeanFactory загружает компоненты по запросу.
 */
public class BeanFactoryDI {

    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        BeanDefinition storeDefinition = BeanDefinitionBuilder.rootBeanDefinition(Store.class).getBeanDefinition();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.rootBeanDefinition(StartUI.class).getBeanDefinition();
        defaultListableBeanFactory.registerBeanDefinition("store", storeDefinition);
        defaultListableBeanFactory.registerBeanDefinition("ui", beanDefinition);
        StartUI ui = defaultListableBeanFactory.createBean(StartUI.class);
        ui.add("Petr Arsentev");
        ui.add("Ivan ivanov");
        ui.print();
    }
}
