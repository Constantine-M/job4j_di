package ru.job4j.di.aop.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Данный класс является Aspect-классом.
 *
 * Аспект — логический объект в
 * аспектно-ориентированном программировании,
 * который позволяет объединять однотипные по
 * функциональности элементы разных объектов.
 *
 * Чтобы указать Spring-у, что данный класс
 * является классом-аспектом,
 * использовали аннотацию {@link Aspect}.
 *
 * Мы выделили служебную логику (логирование
 * в данном примере) в отдельные объекты - аспекты,
 * связали эти аспекты с методами бизнес-логики
 * и указали фреймворку, когда именно применить
 * аспекты.
 *
 * С помощью аннотаций {@link Before} (а также
 * {@link AfterReturning}) сообщили фреймворку
 * Srping, когда и какие целевые методы
 * (то есть методы с бизнес-логикой) следует
 * перехватить.
 */
@Aspect
@Component
public class BeforeAndAfterLoggingAspect {

    public static final Logger LOG = LogManager.getLogger(BeforeAndAfterLoggingAspect.class.getName());

    @Before("execution(* ru.job4j.di.aop.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object[] argsObj = joinPoint.getArgs();
        String args = Arrays.toString(argsObj);
        String methodName = signature.toShortString();
        LOG.info("Вызван метод:  {}", methodName);
        LOG.info("аргументы: {}", args);
    }

    @AfterReturning(pointcut = "execution(int ru.job4j.di.aop.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, int result) {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.toShortString();
        LOG.info("Метод завершил работу: {}", methodName);
        LOG.info("с результатом: {}", result);
    }
}
