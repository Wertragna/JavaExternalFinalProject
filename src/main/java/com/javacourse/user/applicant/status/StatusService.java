package com.javacourse.user.applicant.status;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;
import com.javacourse.user.applicant.ApplicantDAO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class StatusService extends AbstractServiceSql<Integer, Status> implements Service<Integer,Status> {
    private final Logger logger = Logger.getLogger(StatusService.class);
    FactoryDAO factoryDAO;

    public StatusService() {
        super(StatusDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

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
