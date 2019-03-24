package ru.vsu.amm.queries.Factory;

import javax.sql.DataSource;

public abstract class QueryFactory {
    private static final String POSTGRE_SQL = "PostgreSQL";

    public abstract String createUser();
    public abstract String findByIdUser();
    public abstract String findByEmailUser();
    public abstract String getAllUsers();
    public abstract String deleteUsers();
    public abstract String updateUsers();

    public abstract String createParking();
    public abstract String findByIdParking();
    public abstract String findByAddressParking();
    public abstract String getAllParking();
    public abstract String deleteParking();
    public abstract String updateParking();

    public abstract String getRole();
    public abstract String getFavPlaces();

    public static QueryFactory getFactory(String factoryType){
        switch (factoryType){
            case POSTGRE_SQL: {
                return new PostgreSQLQueryFactory();
            }
            default: return null;
        }
    }
}
