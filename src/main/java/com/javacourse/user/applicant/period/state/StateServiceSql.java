package com.javacourse.user.applicant.period.state;

import com.javacourse.shared.dao.AbstractDAO;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;

public class StateServiceSql extends AbstractServiceSql<Integer,State> implements StateService<Integer> {
    public StateServiceSql(Class<? extends AbstractDAO> clazz) {
        super(StateDAOSql.class);
    }
}
