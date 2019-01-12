package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.user.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ApplicantServiceTest {

    @Mock
    FactoryDAO factoryDAO;

    @InjectMocks
    ApplicantService applicantService;

    @Before
    public void init_mocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getByPeriodAndSubject() {

    }

    @Test
    public void getBySpecialityIdAndPeriodId() {
    }

    @Test
    public void updateMarks() {
    }

    @Test
    public void getApplicantIdByUserIdAndPeriod() {
        Connection connection = mock(Connection.class);
        ApplicantDAO applicantDAO = mock(ApplicantDAOSql.class);
        when(factoryDAO.createConnection()).thenReturn(connection);
        when(factoryDAO.createApplicantDAO(connection)).thenReturn(applicantDAO);
        try {
            when(applicantDAO.getApplicantIdByUserIdAndPeriod(new User(), 4)).thenThrow(UnsuccessfulDAOException.class);
        } catch (UnsuccessfulDAOException e) {
            e.printStackTrace();
        }
        assertEquals(-1, applicantService.getApplicantIdByUserIdAndPeriod(new User(), 4));

    }

    @Test
    public void createNewByPeriodIdUserId() {
    }

    @Test
    public void calculateRatingForSubjectSpeciality() {
    }

    @Test
    public void updatePeriod() {
    }

    @Test
    public void setStatusForApplicantsWithSpecialityLimit() {
    }
}