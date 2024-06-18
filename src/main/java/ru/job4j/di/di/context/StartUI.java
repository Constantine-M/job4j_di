package ru.job4j.di.di.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUI {

    @Autowired
    private Store store;

    @Autowired
    private ConsoleInput input;

    public void init(Store store, ConsoleInput input) {
        boolean run = true;
        System.out.println("Enter 'exit' to quit.");
        while (run) {
            String word = input.askStr("Enter something: ");
            if (!word.equals("exit")) {
                add(word);
                print();
            } else {
                run = false;
            }
        }
    }

    public void add(String value) {
        store.add(value);
    }

    public void print() {
        store.getAll().forEach(System.out::println);
    }
}
