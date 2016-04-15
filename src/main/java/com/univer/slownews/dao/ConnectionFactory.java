package com.univer.slownews.dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    protected Connection getConnection() throws DaoException{
        Connection connection = null;

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            DataSource source = (DataSource) envContext.lookup("jdbc/slownews");
            connection = source.getConnection();
        }
        catch (NamingException | SQLException e) {
            throw new DaoException("Cannot get Connection", e);
        }
        return connection;
    }
}
