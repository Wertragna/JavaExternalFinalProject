package com.javacourse.security.command;

import com.javacourse.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SingUpCommandPOSTTest {
    private static final String DEFAULT_PASSWORD = "PASSWORD";
    private static final String DEFAULT_NAME = "NAME";
    private static final String DEFAULT_SURNAME = "SURNAME";
    private static final String DEFAULT_MAIL = "EMAIL";
    private static final int DEFAULT_ID = 0;
    private static final int DEFAULT_ROLE = 2;
    private static final String LOGIN_PARAM = "login";
    private static final String PASSWORD_PARAM = "password";
    private static final String NAME_PARAM = "firstname";
    private static final String SURNAME_PARAM = "surname";

    SingUpCommandPOST signUpCommand = new SingUpCommandPOST();

    @Mock
    HttpServletRequest request;

    @Before
    public void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        when(request.getParameter(LOGIN_PARAM)).thenReturn(DEFAULT_MAIL);
        when(request.getParameter(PASSWORD_PARAM)).thenReturn(DEFAULT_PASSWORD);
        when(request.getParameter(NAME_PARAM)).thenReturn(DEFAULT_NAME);
        when(request.getParameter(SURNAME_PARAM)).thenReturn(DEFAULT_SURNAME);
    }

    @Test
    public void createUsingByRequest() {
        User actual = signUpCommand.createUsingByRequest(request);
        User expected = new User();
        expected.setId(DEFAULT_ID);
        expected.setFirstname(DEFAULT_NAME);
        expected.setSurname(DEFAULT_SURNAME);
        expected.setEmail(DEFAULT_MAIL);
        expected.setPassword(DEFAULT_PASSWORD);
        expected.setRole(DEFAULT_ROLE);
        assertEquals(expected,actual);
    }
}