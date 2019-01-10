package com.javacourse.shared.dao;

import com.javacourse.user.speciality.SpecialityDAO;
import com.javacourse.user.subject.SubjectDAO;
import com.javacourse.user.UserDAO;
import com.javacourse.user.applicant.ApplicantDAO;
import com.javacourse.user.applicant.period.PeriodDAO;
import com.javacourse.user.applicant.period.state.StateDAO;
import com.javacourse.user.applicant.status.StatusDAO;
import com.javacourse.user.role.RoleDAO;

import java.sql.Connection;

public interface FactoryDAO {
    UserDAO createUserDAO(Connection connection);
    RoleDAO createUserRoleDAO(Connection connection);
    SubjectDAO createSubjectDAO(Connection connection);
    ApplicantDAO createApplicantDAO(Connection connection);
    PeriodDAO createPeriodDAO(Connection connection);
    StateDAO createStateDAO(Connection connection);
    StatusDAO createStatusDAO(Connection connection);
    SpecialityDAO createSpecialityDAO(Connection connection);
    Connection createConnection();
}
