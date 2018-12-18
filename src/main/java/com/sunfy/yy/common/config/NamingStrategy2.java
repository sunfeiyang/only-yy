package com.sunfy.yy.common.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class NamingStrategy2 implements PhysicalNamingStrategy {

    @Override
    public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if(identifier != null){
            return Identifier.toIdentifier(identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if(identifier != null){
            return Identifier.toIdentifier(identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if(identifier != null){
            return Identifier.toIdentifier(identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if(identifier != null){
            return Identifier.toIdentifier(identifier.toString().toUpperCase());
        }
        return null;
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        if(identifier != null){
            return Identifier.toIdentifier(identifier.toString().toUpperCase());
        }
        return null;
    }
}
