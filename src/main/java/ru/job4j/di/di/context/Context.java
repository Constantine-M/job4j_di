package ru.job4j.di.di.context;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Данный класс описывает реализацию DI.
 *
 * Context в данном случае является
 * хранилищем объектов. Здесь мы будем
 * регистрировать классы, объекты которых
 * хотелось бы иметь в проекте.
 *
 * @author Constantine on 17.06.2024
 */
public class Context {

    private Map<String, Object> els = new HashMap<String, Object>();

    /**
     * Зарегистрировать класс.
     *
     * 1.Если конструкторов > 1, то мы не знаем как
     * загружать класс.
     *
     * 2.Когда мы нашли конструктор, мы собираем аргументы
     * этого конструктора и ищем уже зарегистрированные
     * объекты, чтобы внедрить их в конструктор.
     *
     * 3.Добавляем объект в карту.
     * {@link Constructor#newInstance(Object...)}.
     */
    public void reg(Class cl) {
        Constructor[] constructors = cl.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + cl.getCanonicalName());
        }
        Constructor con = constructors[0];
        List<Object> args = new ArrayList<Object>();
        for (Class arg : con.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }
        try {
            els.put(cl.getCanonicalName(), con.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of : " + cl.getCanonicalName(), e);
        }
    }

    /**
     * Получить проинициализированный объект.
     *
     * Имя класса получаем через рефлексию
     * {@link Class#getCanonicalName()}.
     */
    public <T> T get(Class<T> inst) {
        return (T) els.get(inst.getCanonicalName());
    }
}
