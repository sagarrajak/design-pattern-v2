package com.fancystore.creational.abstractfactory.database.factory;

import com.fancystore.creational.abstractfactory.database.Connection;
import com.fancystore.creational.abstractfactory.database.Query;
import com.fancystore.creational.abstractfactory.database.sql.SqlConnectionManager;
import com.fancystore.creational.abstractfactory.database.sql.SqlQuery;

public class SqlFactory implements DatabaseFactory{
    @Override
    public Query getQuery() {
        return new SqlQuery();
    }

    @Override
    public Connection getConnection() {
        return new SqlConnectionManager();
    }
}
