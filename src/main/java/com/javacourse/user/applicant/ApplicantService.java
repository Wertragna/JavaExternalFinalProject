package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;
import com.javacourse.user.speciality.Speciality;
import com.javacourse.user.speciality.SpecialityDAO;
import com.javacourse.user.User;
import com.javacourse.user.applicant.status.StatusDAO;
import com.javacourse.user.applicant.status.StatusName;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ApplicantService extends AbstractServiceSql<Integer, Applicant> implements Service<Integer, Applicant> {
    private static final Logger logger = Logger.getLogger(ApplicantDAOSql.class);

    private final FactoryDAO factoryDAO;

    public ApplicantService( ) {
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
            applicants = applicantDAO.getBySpecialityIdAndPeriodIdWithUserEntity(specialityId, periodId);
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

    public int getApplicantIdByUserIdAndPeriod(User user, Integer period) {
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO applicantDAOrDAO = factoryDAO.createApplicantDAO(connection);
            return applicantDAOrDAO.getApplicantIdByUserIdAndPeriod(user, period);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return -1;
    }

    public boolean createNewByPeriodIdUserId(int periodId, int userId) {
        try (Connection connection = factoryDAO.createConnection()) {
            ApplicantDAO applicantDAO = factoryDAO.createApplicantDAO(connection);
            StatusDAO statusDAO = factoryDAO.createStatusDAO(connection);
            Applicant applicant = new Applicant();
            applicant.setUser(userId);
            applicant.setPeriod(periodId);
            applicant.setStatus(statusDAO.getByName(StatusName.getNames().get(StatusName.UNDER_CONSIDERATION)).getId());
            return applicantDAO.create(applicant);
        } catch (SQLException | UnsuccessfulDAOException e) {
            logger.error(e.getMessage());
        }
        return false;
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

    public boolean updatePeriod(int periodId) {
        try (Connection connection = factoryDAO.createConnection()) {
            connection.setAutoCommit(false);
            SpecialityDAO specialityDAO = factoryDAO.createSpecialityDAO(connection);
            ApplicantDAO<Integer> applicantDAO = factoryDAO.createApplicantDAO(connection);
            try {
                List<Speciality> specialities = specialityDAO.getAll();
                for (Speciality speciality : specialities) {
                    List<Applicant> applicants = applicantDAO.getBySpecialityIdAndPeriodId(speciality.getId(), periodId);
                    setStatusForApplicantsWithSpecialityLimit(applicants, speciality.getLimit(), 2, 3);
                    if (applicants.size() > 0)
                        applicantDAO.updateList(applicants);
                }
                connection.commit();
            } catch (SQLException | UnsuccessfulDAOException e) {
                connection.rollback();
                logger.error(e.getMessage());
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return false;
    }


    void setStatusForApplicantsWithSpecialityLimit(List<Applicant> applicants, int specialityLimit, int idAccept, int idDenied) {
        Integer currentRating = -1;
        for (int i = applicants.size() - 1; i >= 0; i--) {
            Applicant applicant = applicants.get(i);
            if (i > specialityLimit - 1 || currentRating.equals(applicant.getRating())) {
                currentRating = applicant.getRating();
                applicant.setStatus(idDenied);
            } else
                applicant.setStatus(idAccept);
        }
    }
}
