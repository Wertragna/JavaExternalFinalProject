package com.javacourse.user.applicant.period;

import com.javacourse.exception.UnsuccessfulDAOException;
import com.javacourse.shared.service.Service;

import java.util.List;

public interface PeriodService<K> extends Service<K,Period> {
    boolean checkAllPeriodIsEnded() throws UnsuccessfulDAOException;

    boolean checkPeriodsChoiceSubjects() throws UnsuccessfulDAOException;

    List<Period> selectPeriodsChoiceSubject() throws UnsuccessfulDAOException;

    Period getByIdWithState(int id );
    boolean  setNextState(Period period);


}
