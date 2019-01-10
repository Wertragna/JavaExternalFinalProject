package com.javacourse.user.applicant.applicant_command;

import com.javacourse.shared.web.Page;
import com.javacourse.user.User;
import com.javacourse.user.applicant.period.PeriodService;
import com.javacourse.utils.PathPageManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.Mockito.when;
@Ignore
public class PeriodCommandTest {
    @Mock
    PeriodService periodService;
    @Mock
    HttpServletRequest request;
    @Mock
    HttpServletResponse response;

    @InjectMocks
    PeriodCommand periodCommand;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void execute() {
        User user = new User();
        user.setId(5);
        when(request.getSession().getAttribute("user")).thenReturn(user);
        when(periodService.getAvailablePeriodsByUserId(user.getId()));

        Assert.assertEquals( new Page(PathPageManager.getProperty("page.period")).setDispatchType(Page.DispatchType.FORWARD),periodCommand.execute(request,response));
    }
}