package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;
import com.javacourse.user.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ApplicantService extends AbstractServiceSql<Integer, Applicant> implements Service<Integer,Applicant> {
    private static final Logger logger = Logger.getLogger(ApplicantDAOSql.class);
    FactoryDAO factoryDAO;

    public ApplicantService() {
        super(ApplicantDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }


    public List<ApplicantSubject> getByPeriodAndSubject(int period, int subject) {
        List<ApplicantSubject> applicantSubjects = new ArrayList<>();
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO<Integer> applicantDAO = factoryDAO.createApplicantDAO(connection);
            applicantSubjects = applicantDAO.getByPeriodAndSubject(period, subject);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return applicantSubjects;
    }

    public List<Applicant> getBySpecialityIdAndPeriodId(int specialityId, int periodId) {
        List<Applicant> applicants = new ArrayList<>();
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO<Integer> applicantDAO = factoryDAO.createApplicantDAO(connection);
            applicants = applicantDAO.getBySpecialityIdAndPeriodIdWithUserEntity(specialityId,periodId);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return applicants;
    }


    public boolean updateMarks(List<ApplicantSubject> applicantSubjects) {
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO<Integer> applicantDAO = factoryDAO.createApplicantDAO(connection);
            for (ApplicantSubject a : applicantSubjects) {
                if (!applicantDAO.updateApplicantSubjectMarks(a))
                    return false;
            }

        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return true;
    }

    public int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException {
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO applicantDAOrDAO = factoryDAO.createApplicantDAO(connection);
            return applicantDAOrDAO.getApplicantIdByUserIdAndPeriod(user, period);
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return -1;
    }

    public Integer calculateRatingForSubjectSpeciality(int idApplicant, int idSpeciality) {
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO applicantDAO = factoryDAO.createApplicantDAO(connection);
            return applicantDAO.calculateRatingForSubjectSpeciality(idApplicant, idSpeciality);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
