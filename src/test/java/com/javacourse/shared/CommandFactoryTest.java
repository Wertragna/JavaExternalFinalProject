package com.javacourse.shared;

import com.javacourse.admindashboard.command.AdminHomeCommand;
import com.javacourse.exception.NotFoundCommandException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CommandFactoryTest {

    HttpServletRequest request;

    CommandFactory commandFactory;
    String actual;

    @Before
    public   void setUp() throws Exception {
        request =mock(HttpServletRequest.class);
        when(request.getRequestURI()).thenReturn("example.com/admin");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        commandFactory = new CommandFactory(request);

    }

    @Test
    public void getCommand_correct() {
        when(request.getRequestURI()).thenReturn("example.com/admin");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        actual = commandFactory.getCommandName(ActionCommandEnum.class);
        ActionCommand actionCommand = commandFactory.getCommand();
        Assert.assertTrue(actionCommand instanceof AdminHomeCommand);

    }

    @Test
    public void getCommandName_correct() {
        when(request.getRequestURI()).thenReturn("example.com/admin");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        actual = commandFactory.getCommandName(ActionCommandEnum.class);
        String actual = commandFactory.getCommandName(ActionCommandEnum.class);
        Assert.assertEquals("ADMIN_HOME",actual);
    }

    @Test(expected = NotFoundCommandException.class)
    public void getCommandName_wrongRequest_exception() {
        when(request.getRequestURI()).thenReturn("example.com/wrong");
        when(request.getContextPath()).thenReturn("example.com");
        when(request.getMethod()).thenReturn("GET");
        actual = commandFactory.getCommandName(ActionCommandEnum.class);
        String actual = commandFactory.getCommandName(ActionCommandEnum.class);
        Assert.assertEquals("ADMIN_HOME",actual);
    }
}