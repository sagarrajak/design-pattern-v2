package com.fancystore.creational.abstractfactory.database.psql;

import com.fancystore.creational.abstractfactory.database.Connection;

public class PostgresqlConnectionManager implements Connection {
    @Override
    public void connect() {
        System.out.println("Connected to postgresql - !");
    }

    @Override
    public void disconnect() {
        System.out.println("Disconnect to postgresql - !");
    }
}
