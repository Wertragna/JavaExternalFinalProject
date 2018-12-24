package com.javacourse.shared.service;

import com.javacourse.utils.DataBaseConnectionPool;
import org.apache.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class SQLConnection implements Closeable {
    private static final Logger logger = Logger.getLogger(SQLConnection.class);
    Connection connection;

    public SQLConnection() {
        try {
            this.connection = DataBaseConnectionPool.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void close() throws IOException {
        if (connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }
}
