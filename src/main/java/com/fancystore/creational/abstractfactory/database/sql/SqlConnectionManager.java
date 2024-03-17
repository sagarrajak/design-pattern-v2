package com.fancystore.creational.abstractfactory.database.sql;

import com.fancystore.creational.abstractfactory.database.Connection;

public class SqlConnectionManager implements Connection {
    @Override
    public void connect() {
        System.out.println("Connect to mysql - ");
    }

    @Override
    public void disconnect() {
        System.out.println("Dis-connect to mysql - ");
    }
}
