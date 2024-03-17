package com.fancystore.creational.abstractfactory.database.factory;

import com.fancystore.creational.abstractfactory.database.Connection;
import com.fancystore.creational.abstractfactory.database.Query;

public interface DatabaseFactory {
    Query getQuery();
    Connection getConnection();
}
