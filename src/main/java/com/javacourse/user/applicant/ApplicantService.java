package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.Service;
import com.javacourse.user.User;

public interface ApplicantService<K> extends Service<K, Applicant> {
    int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException;

}
