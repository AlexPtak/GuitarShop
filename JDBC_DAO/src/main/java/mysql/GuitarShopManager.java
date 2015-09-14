package mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.Entity;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuitarShopManager {

    private static GuitarShopManager dataSource;
    private ComboPooledDataSource comboPooledDataSource;

    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.jdbc.Driver";

    public GuitarShopManager() throws IOException, SQLException, PropertyVetoException {
        comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(20);
        comboPooledDataSource.setMaxStatements(150);
    }

    public static GuitarShopManager getInstance() throws IOException, SQLException, PropertyVetoException {
        if (dataSource == null) {
            dataSource = new GuitarShopManager();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws SQLException {
        return this.comboPooledDataSource.getConnection();
    }

    public Entity singleSelect(Entity entity, String addToWhere) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        for (int i = 0; i < entity.getCulums().length; i++) builder.append(entity.getCulums()[i] + ", ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append(" FROM " + entity.getTable());
        builder.append(" WHERE ");
        for (int i = 0; i < entity.getValues().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(entity.getCulums()[i] + " = " + prepareValue(value, entity.getTypes()[i]) + ";");
            break;
        }
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = builder.toString();
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();
            fillEntity(entity, resultSet);
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return entity;
    }


    public List<Entity> select(Entity entity, String addToWhere) throws SQLException {
        StringBuilder builder = new StringBuilder();
        ArrayList<Entity> entities = new ArrayList<Entity>();
        builder.append("SELECT ");
        for (int i = 0; i < entity.getCulums().length; i++) builder.append(entity.getCulums()[i] + ", ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append(" FROM " + entity.getTable());
        builder.append(" WHERE ");
        for (int i = 0; i < entity.getValues().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(entity.getCulums()[i] + " = " + prepareValue(value, entity.getTypes()[i]) + " AND ");
        }
        builder.delete(builder.length() - 5, builder.length());
        builder.append(";");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(entity, sql, entities);
        /*Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = builder.toString();
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Entity emptyEntity = entity.getEmptyEntity();
                fillEntity(emptyEntity, resultSet);
                entity.add(emptyEntity);
            }
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }*/
        return entities;
    }

    public void insert(Entity entity) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO " + entity.getTable() + " (");
        for (int i = 0; i < entity.getCulums().length; i++) {
            builder.append(entity.getCulums()[i] + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(") VALUES(");
        for (int i = 0; i < entity.getCulums().length; i++) {
            Object value = entity.getValues()[i];
            builder.append(prepareValue(value, entity.getTypes()[i]) + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(");");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(null, sql, null);
        /*Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = builder.toString();
            System.out.println(sql);
            statement.execute(sql);
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }*/
    }

    public void update(Entity oldEntity, Entity editedEntity) throws SQLException {
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE " + oldEntity.getTable() + " SET ");
        for (int i = 0; i < editedEntity.getCulums().length; i++) {
            Object value = editedEntity.getValues()[i];
            if (value == null) continue;
            builder.append(editedEntity.getCulums()[i] + " = " + prepareValue(value, editedEntity.getTypes()[i]) + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        final int primeryKey = 0;
        builder.append(" WHERE " + oldEntity.getCulums()[primeryKey] + " = " + editedEntity.getValues()[primeryKey] + ";");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(null, sql, null);
        /*Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = builder.toString();
            System.out.println(sql);
            statement.executeUpdate(sql);
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }*/
    }

    private void databaseExecution(Entity entity, String sql, List entities) throws SQLException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            /*if (sql.contains("SELECT")) {
                ResultSet resultSet = statement.executeQuery(sql);
                resultSet.next();
                fillEntity(entity, resultSet);
            }*/
            if (sql.contains("SELECT")) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    Entity emptyEntity = entity.getEmptyEntity();
                    fillEntity(emptyEntity, resultSet);
                    entities.add(emptyEntity);
                }
            }
            if (sql.contains("INSERT")) statement.execute(sql);
            if (sql.contains("UPDATE")) statement.executeUpdate(sql);
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
    }

    private String prepareValue(Object value, JDBCType type) {
        if (value == null) return null;
        switch (type) {
            case INTEGER:
            case SMALLINT:
            case DOUBLE:
                return value.toString();
            case VARCHAR:
            case CHAR:
                return "'" + value.toString() + "'";
        }
        return null;
    }

    private void fillEntity(Entity entity, ResultSet resultSet) throws SQLException {
        for (int i = 0; i < entity.getCulums().length; i++) {
            switch (entity.getTypes()[i]) {
                case INTEGER:
                case SMALLINT:
                    entity.getValues()[i] = resultSet.getInt(i + 1);
                    break;
                case DOUBLE:
                    entity.getValues()[i] = resultSet.getDouble(i + 1);
                    break;
                case VARCHAR:
                case CHAR:
                case NVARCHAR:
                    entity.getValues()[i] = resultSet.getString(i + 1);
                    break;
            }
        }
    }
}
