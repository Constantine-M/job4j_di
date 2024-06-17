package ru.job4j.di.di.context;

/**
 * В данном классе демонстрируется
 * работа приложения, в которой
 * мы используем свою реализацию DI.
 *
 * @author Constantine on 17.06.2024
 */
public class Main {

    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);

        Store store = context.get(Store.class);
        ConsoleInput input = context.get(ConsoleInput.class);
        StartUI ui = context.get(StartUI.class);

        ui.init(store, input);
    }
}
