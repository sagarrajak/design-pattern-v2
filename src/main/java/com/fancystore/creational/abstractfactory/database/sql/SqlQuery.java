package com.fancystore.creational.abstractfactory.database.sql;

import com.fancystore.creational.abstractfactory.database.Query;

public class SqlQuery implements Query {
    @Override
    public String construct() {
        return "This is sql query";
    }
}
