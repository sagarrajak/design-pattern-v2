package com.fancystore.creational.abstractfactory.database.factory;

import com.fancystore.creational.abstractfactory.database.Connection;
import com.fancystore.creational.abstractfactory.database.Query;
import com.fancystore.creational.abstractfactory.database.psql.PosgresQuery;
import com.fancystore.creational.abstractfactory.database.psql.PostgresqlConnectionManager;

public class PsqlFactory implements DatabaseFactory{
    @Override
    public Query getQuery() {
        return new PosgresQuery();
    }

    @Override
    public Connection getConnection() {
        return new PostgresqlConnectionManager();
    }
}
