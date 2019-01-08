package com.javacourse.user.role;

import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;
import com.javacourse.shared.service.Service;

public class RoleServiceSql extends AbstractServiceSql<Integer, Role> implements Service<Integer, Role> {
    FactoryDAO factoryDAO;
    public RoleServiceSql() {
        super(RoleDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }
}
