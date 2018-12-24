package com.javacourse.user.role;

import com.javacourse.shared.service.AbstractServiceSql;

public class RoleServiceSql extends AbstractServiceSql<Integer, Role> implements RoleService<Integer>{
    public RoleServiceSql() {
        super(RoleDAOSql.class);
    }
}
