package ru.job4j.di.di.context;

import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @author Constantine on 17.06.2024
 */
@Component
public class ConsoleInput {

    private Scanner scanner = new Scanner(System.in);

    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
