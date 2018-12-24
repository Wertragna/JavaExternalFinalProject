package com.javacourse.user.role;

import com.javacourse.shared.service.AbstractServiceSql;

public class RoleServiceSql extends AbstractServiceSql<Integer, Role> {
    public RoleServiceSql() {
        super(RoleDAOSql.class);
    }
}
