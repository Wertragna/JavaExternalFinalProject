package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.user.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;


public class ApplicantServiceSql extends AbstractServiceSql<Integer, Applicant> implements ApplicantService<Integer> {
    private static final Logger logger = Logger.getLogger(ApplicantDAOSql.class);
    FactoryDAO factoryDAO;

    public ApplicantServiceSql() {
        super(ApplicantDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

    @Override
    public int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException {
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO applicantDAOrDAO = factoryDAO.createApplicantDAO(connection);
            return applicantDAOrDAO.getApplicantIdByUserIdAndPeriod(user, period);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return -1;
    }
}
