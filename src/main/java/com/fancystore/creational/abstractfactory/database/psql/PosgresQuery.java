package com.fancystore.creational.abstractfactory.database.psql;

import com.fancystore.creational.abstractfactory.database.Query;

public class PosgresQuery implements Query {
    @Override
    public String construct() {
        return "This is psql query";
    }
}
