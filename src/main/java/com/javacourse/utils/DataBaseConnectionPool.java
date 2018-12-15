package com.javacourse.utils;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataBaseConnectionPool {
    private static DataSource ds;

    static {
        Context envCtx = null;
        try {
            envCtx = (Context) (new InitialContext().lookup("java:comp/env"));
            ds = (DataSource) envCtx.lookup("jdbc/enrollment_db");

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
