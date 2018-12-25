package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.user.User;

public interface ApplicantDAO<K> extends AbstractDAO<K,Applicant> {
    int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException;
}
