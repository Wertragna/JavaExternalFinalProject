package com.javacourse.shared;

import com.javacourse.exception.NotFoundCommandException;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class CommandFactory {
    private HttpServletRequest request;

    public CommandFactory(HttpServletRequest request) {
        this.request = request;
    }

    public ActionCommand getCommand(){
//todo error when command dont exist
        return ActionCommandEnum.valueOf(getCommandName(ActionCommandEnum.class)).getCurrentCommand();
    }

     String getCommandName(Class enumCommand) {
        String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        for (Field field : enumCommand.getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof Action) {
                    if (((Action) annotation).url().equals(url) && ((Action) annotation).method().equals(request.getMethod())) {
                        //todo delete this after tests
                        System.out.println(field.getName());
                        return field.getName();
                    }
                }
            }
        }
        throw new NotFoundCommandException();
    }
}
