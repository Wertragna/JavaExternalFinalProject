package com.javacourse.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SubjectServiceSql extends AbstractServiceSql<Integer, Subject> implements SubjectService<Integer> {
    private static final Logger logger = Logger.getLogger(SubjectServiceSql.class);
    FactoryDAO factoryDAO;

    public SubjectServiceSql() {
        super(SubjectDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }

    @Override
    public boolean addSubjectApplicant(Integer subject, Integer applicant) throws UnsuccessfulDAOException {
        try (Connection connection = factoryDAO.createConnection()) {
           return factoryDAO.createSubjectDAO(connection).addSubjectApplicant(subject,applicant);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSubjectBySubjectIdAndApplicantId(int subject, int applicant) {
        try (Connection connection = factoryDAO.createConnection()) {
            return factoryDAO.createSubjectDAO(connection).deleteSubjectBySubjectIdAndApplicantId(subject,applicant);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Subject> getByApplicantId(Integer applicantId) throws UnsuccessfulDAOException {
        List<Subject>list=null;
        try (Connection connection = factoryDAO.createConnection()) {
             list= factoryDAO.createSubjectDAO(connection).getByApplicantId(applicantId);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return list;
    }
}
