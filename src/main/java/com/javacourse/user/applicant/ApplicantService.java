package com.javacourse.user.applicant;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.Service;
import com.javacourse.user.User;

import java.util.List;

public interface ApplicantService<K> extends Service<K, Applicant> {
    int getApplicantIdByUserIdAndPeriod(User user, Integer period) throws UnsuccessfulDAOException;
    List<ApplicantSubject> getByPeriodAndSubject(int period, int subject);
}
