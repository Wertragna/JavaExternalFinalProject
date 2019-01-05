package com.javacourse.user.applicant.period.state;

import com.javacourse.shared.service.Service;

public interface StateService<K> extends Service<K,State> {
    StateName getByPeriodId(int id);
}
