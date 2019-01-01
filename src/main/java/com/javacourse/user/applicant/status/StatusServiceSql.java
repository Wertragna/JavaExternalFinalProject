package com.javacourse.user.applicant.status;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.user.applicant.ApplicantDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class StatusServiceSql extends AbstractServiceSql<Integer, Status> implements StatusService {
    private final Logger logger = Logger.getLogger(StatusServiceSql.class);
    FactoryDAO factoryDAO;

    public StatusServiceSql() {
        super(StatusDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

    @Override
    public Status getByApplicantId(int applicantId) {
        Status status = null;
        try (Connection connection = factoryDAO.createConnection()) {
            StatusDAO statusDAO = factoryDAO.createStatusDAO(connection);
            ApplicantDAO<Integer> applicantDAO = factoryDAO.createApplicantDAO(connection);
            int id = applicantDAO.getById(applicantId).getStatus();
            status = statusDAO.getById(id);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return status;
    }
}
