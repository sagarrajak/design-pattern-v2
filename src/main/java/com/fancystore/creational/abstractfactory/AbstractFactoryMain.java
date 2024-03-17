package com.fancystore.creational.abstractfactory;

import com.fancystore.creational.abstractfactory.database.Connection;
import com.fancystore.creational.abstractfactory.database.Query;
import com.fancystore.creational.abstractfactory.database.factory.DatabaseFactory;
import com.fancystore.creational.abstractfactory.database.factory.PsqlFactory;
import com.fancystore.creational.abstractfactory.database.factory.SqlFactory;

enum DatabaseTypes {
    sql, psql
}
public class AbstractFactoryMain {
    Connection connection;
    Query query;
    public AbstractFactoryMain(DatabaseFactory factory) {
        connection = factory.getConnection();
        query = factory.getQuery();
    }

    public static void main(String[] args) {
        var database = DatabaseTypes.psql;
        AbstractFactoryMain factory = null;
        switch (database) {
            case sql ->  {
                factory = new AbstractFactoryMain(new SqlFactory());
            }
            case psql -> {
                factory = new AbstractFactoryMain(new PsqlFactory());
            }
            default -> {
                System.out.println("invalid choise");
            }
        }
        if (factory != null) {
            factory.connection.connect();
            factory.connection.disconnect();
            factory.query.construct();
        }
    }
}
