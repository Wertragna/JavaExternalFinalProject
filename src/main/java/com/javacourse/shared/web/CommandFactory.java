package com.javacourse.shared.web;

import com.javacourse.exception.NotFoundCommandException;
import com.javacourse.shared.annotations.Action;
import com.javacourse.shared.command.ActionCommand;
import com.javacourse.shared.web.ActionCommandEnum;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


public class CommandFactory {

    private static final Logger logger = Logger.getLogger(CommandFactory.class);
    private HttpServletRequest request;

    public CommandFactory(HttpServletRequest request) {
        this.request = request;
    }

    public ActionCommand getCommand(){
//todo error when command dont exist

        try{
        return ActionCommandEnum.valueOf(getCommandName(ActionCommandEnum.class)).getCurrentCommand();
        }
        catch (NotFoundCommandException e){
            logger.error(e.getMessage());
            return null;
        }
    }

     String getCommandName(Class enumCommand) {
        System.out.println("getCommandName");
        String url = request.getRequestURI().replaceFirst(request.getContextPath(), "");
        for (Field field : enumCommand.getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof Action) {
                    System.out.println(field.getName());
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
