package com.javacourse.user.subject;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;
import com.javacourse.user.applicant.ApplicantSubject;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SubjectServiceSql extends AbstractServiceSql<Integer, Subject> implements Service<Integer,Subject> {
    private static final Logger logger = Logger.getLogger(SubjectServiceSql.class);
    FactoryDAO factoryDAO;

    public SubjectServiceSql() {
        super(SubjectDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }


    public boolean addSubjectApplicant(Integer subject, Integer applicant) throws UnsuccessfulDAOException {
        try (Connection connection = factoryDAO.createConnection()) {
           return factoryDAO.createSubjectDAO(connection).addSubjectApplicant(subject,applicant);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public boolean deleteSubjectBySubjectIdAndApplicantId(int subject, int applicant) {
        try (Connection connection = factoryDAO.createConnection()) {
            return factoryDAO.createSubjectDAO(connection).deleteSubjectBySubjectIdAndApplicantId(subject,applicant);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    public List<ApplicantSubject> getByApplicantId(int applicantId)  {
        List<ApplicantSubject>list=null;
        try (Connection connection = factoryDAO.createConnection()) {
             SubjectDAO subjectDAO= factoryDAO.createSubjectDAO(connection);
             list = subjectDAO.getByApplicantId(applicantId);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return list;
    }
    public List<Subject> getSubjectByApplicantId(int applicantId)  {
        List<Subject>list=null;
        try (Connection connection = factoryDAO.createConnection()) {
            SubjectDAO subjectDAO= factoryDAO.createSubjectDAO(connection);
            list = subjectDAO.getSubjectsByApplicantId(applicantId);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return list;
    }
}
