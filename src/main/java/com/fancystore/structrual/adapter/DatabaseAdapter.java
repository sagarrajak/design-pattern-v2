package com.fancystore.structrual.adapter;

interface MySQLDriver {
    void connectToMySQL();
    void executeQuery();
}

interface PostgreSQLDriver {
    void connectToPostgreSQL();
    void executeQuery();
}

// Unified interface
interface DatabaseDriver {
    void connect();
    void executeQuery();
}



public class DatabaseAdapter {
    public static void main(String[] args) {

    }
}


class MySqlAdapter implements DatabaseDriver {
    MySQLDriver driver;
    public MySqlAdapter(MySQLDriver driver) {
        this.driver = driver;
    }

    @Override
    public void connect() {
        driver.connectToMySQL();
    }

    @Override
    public void executeQuery() {
        driver.executeQuery();
    }
}


class PostgresAdapter implements DatabaseDriver {

    PostgreSQLDriver postgreSQLDriver;
    public PostgresAdapter(PostgreSQLDriver driver) {
        this.postgreSQLDriver = driver;
    }

    @Override
    public void connect() {
        postgreSQLDriver.connectToPostgreSQL();
    }

    @Override
    public void executeQuery() {
    postgreSQLDriver.executeQuery();
    }
}
