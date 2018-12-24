package com.javacourse.user.role;

import com.javacourse.shared.dao.FactoryDAO;
import com.javacourse.shared.dao.FactoryDAOSql;
import com.javacourse.shared.service.AbstractServiceSql;

public class RoleServiceSql extends AbstractServiceSql<Integer, Role> implements RoleService<Integer>{
    FactoryDAO factoryDAO;
    public RoleServiceSql() {
        super(RoleDAOSql.class);
        factoryDAO = new FactoryDAOSql();
    }
}
