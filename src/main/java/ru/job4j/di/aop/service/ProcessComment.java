package ru.job4j.di.aop.service;

import org.springframework.stereotype.Component;
import ru.job4j.di.aop.config.Config;
import ru.job4j.di.aop.aspects.BeforeAndAfterLoggingAspect;
import ru.job4j.di.aop.model.Comment;

/**
 * Данный класс описывает сервис,
 * который работает с комментариями.
 *
 * По задаче необходимо было добавить
 * логирование. Подробнее задача поставлена
 * в классе {@link Config}.
 *
 * Фактически функционал для логирования
 * мы могли бы описать здесь, в слое
 * бизнес-логики.
 *
 * Применив АОП, мы разнесли бизнес-логику
 * и служебный функционал, к которому
 * относится логирование. Функционал логирования
 * описали в классе-аспекте
 * {@link BeforeAndAfterLoggingAspect}.
 *
 * Как только фреймворк обнаруживает вызов
 * целевого метода publishingComment(),
 * он осуществляет перехват управления,
 * выполняет логику аспекта logBefore(),
 * затем возвращает управление методу main()
 * - происходит выполнение целевого метода.
 * И точно так же со вторым методом, когда
 * происходит удаление комментария.
 */
@Component
public class ProcessComment {

    public void publishingComment(Comment comment) {
        System.out.println("Выполняем публикацию комментария : " + comment.getComment());
    }

    public int deleteComment(int commentId) {
        System.out.println("Выполняем удаление комментария : " + commentId);
        return commentId;
    }
}
