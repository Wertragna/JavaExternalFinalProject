package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.user.User;

import java.util.List;

public interface ApplicantDAO<K> extends AbstractDAO<K, Applicant> {
    int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException;

    List<ApplicantSubject> getByPeriodAndSubject(int period, int subject) throws UnsuccessfulDAOException;

    boolean updateApplicantSubjectMarks(ApplicantSubject a) throws UnsuccessfulDAOException;

    int calculateRatingForSubjectSpeciality(int idApplicant, int idSpeciality) throws UnsuccessfulDAOException;

    boolean updateRatingByApplicantId(int applicantId, Integer rating) throws UnsuccessfulDAOException;

    List<Applicant> getBySpecialityIdAndPeriodIdWithUserEntity(int specialityID, int periodId) throws UnsuccessfulDAOException;
}
