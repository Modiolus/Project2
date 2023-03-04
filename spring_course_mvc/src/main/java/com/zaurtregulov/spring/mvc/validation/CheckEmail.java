package com.zaurtregulov.spring.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // создаётся аннотация для полей
@Retention(RetentionPolicy.RUNTIME)
// информация о анотации должна сохраняться вплоть до выполнения кода(т.е. до RUNTIME)
@Constraint(validatedBy = CheckEmailValidator.class) // CheckEmailValidator будет обрабатывать нашу аннотацию
public @interface CheckEmail {
    // CheckEmail будет просто флагом, а сама валидация будет происходить в классе CheckEmailValidator
    // value и message прописанные здесь это элементы, которые вылетят по умолчанию.
    // Если же мы их пропишем в скобках над полем String email в классе Employee, то они затрут дефолтные
    public String value() default "xyz.com"; // xyz.com это окончание адреса(мы хотим проверять заканивается ли адрес так xyz.com)

    public String message() default "email must ands with xyz.com";

    // две строки ниже нужно просто скопировать для правильной работы и запоминать не нужно
    public Class<?>[] groups() default {}; // позволяет разбивать аннотации по группам

    public Class<? extends Payload>[] payload() default {}; // перенос информаци  оо метаданных клиента


}
