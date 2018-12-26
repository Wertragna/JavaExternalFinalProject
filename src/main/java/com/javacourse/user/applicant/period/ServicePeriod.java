package com.javacourse.user.applicant.period;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.Service;

import java.util.List;

public interface ServicePeriod <K> extends Service<K,Period> {
    boolean checkAllPeriodIsEnded() throws UnsuccessfulDAOException;

    boolean checkPeriodsChoiceSubjects() throws UnsuccessfulDAOException;

    List<Period> selectPeriodsChoiceSubject() throws UnsuccessfulDAOException;

}
