package ru.job4j.di.di.context;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Spring поддерживает 6 режимов создания
 * объектов:
 * 1. singleton - объект создает один раз на всю
 * виртуальную машину.
 * 2. prototype - каждый раз создается новый объект.
 * 3. session - объект существует, пока существует
 * сессия пользователя.
 * 4. request - объект существует, пока существует
 * запрос.
 * 5. application - объект существует, пока существует
 * ServletContext.
 * 6. websocket - объект существует, пока есть активная
 * сессия для web-сокета.
 */
@Component
@Scope("prototype")
public class Store {

    private List<String> data = new ArrayList<>();

    public void add(String value) {
        data.add(value);
    }

    public List<String> getAll() {
        return data;
    }
}
