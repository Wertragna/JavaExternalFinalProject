package com.javacourse.security.command;

import com.javacourse.shared.service.ServiceLoader;
import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.UserService;
import com.javacourse.utils.PathPageManager;
import org.junit.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@Ignore
public class SingInCommandPOSTTest {
    HttpServletResponse response;
    HttpServletRequest request;
    SingInCommandPOST signInCommand;
    ServiceLoader serviceLoader;
    UserService userService;

    @Before
    public void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        signInCommand = new SingInCommandPOST();
        serviceLoader = mock(ServiceLoader.class);
        userService = mock(UserService.class);
        when(serviceLoader.userService()).thenReturn(userService);
        when(request.getParameter("login")).thenReturn("login");
        when(request.getParameter("password")).thenReturn("password");
    }

    @Test
    public void executeWithServiceLoader_whenFindUserReturnedNull() {
        when(userService.findByLoginAndPassword(anyString(),anyString())).thenReturn(null);
        Assert.assertEquals(new Page(PathPageManager.getProperty("page.sign-in")).setDispatchType(Page.DispatchType.FORWARD),signInCommand.executeWithServiceLoader(request,response,serviceLoader));
    }

    @Test
    public void executeWithServiceLoader() {
        when(userService.findByLoginAndPassword(anyString(),anyString())).thenReturn(new User());
        HttpSession httpSession = mock(HttpSession.class);
        when(request.getSession()).thenReturn(httpSession);
        Assert.assertEquals(new Page(Page.WebPath.HOME.getPath()).setDispatchType(Page.DispatchType.REDIRECT),signInCommand.executeWithServiceLoader(request,response,serviceLoader));
    }

    @After
    public void tearDown() throws Exception {
        response= null;
        request = null;
        signInCommand = null;
    }
}