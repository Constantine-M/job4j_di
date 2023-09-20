package ru.job4j_di.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j_di.aop.config.Config;
import ru.job4j_di.aop.model.Comment;
import ru.job4j_di.aop.service.ProcessComment;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ProcessComment process = context.getBean("processComment", ProcessComment.class);
        process.publishingComment(new Comment("this is a comment", "Petr"));
        process.deleteComment(1);
        context.close();
    }
}
