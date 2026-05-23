package com.practice.designPatterns.creational.AbstractFactory;

import javax.sql.DataSource;

public class DatabaseFactory implements DataSourceAbstractFactory {
    @Override
    public Service createService() {
        return new DatabaseService();
    }

    @Override
    public Response createResponse() {
        return new DatabaseResponse();
    }
}
