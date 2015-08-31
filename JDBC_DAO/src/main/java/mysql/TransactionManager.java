package mysql;

import dao.Entity;
import entities.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TransactionManager {

    private String user = "root";
    private String password = "root";
    private String url = "jdbc:mysql://localhost:3306/";
    private String driver = "com.mysql.jdbc.Driver";

    public TransactionManager() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
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
        String sql = builder.toString();
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
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
        System.out.println(entity.toString());
        for (int i = 0; i < entity.getValues().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(entity.getCulums()[i] + " = " + prepareValue(value, entity.getTypes()[i]) + " AND ");
        }
        builder.delete(builder.length() - 5, builder.length());
        builder.append(";");
        System.out.println(builder.toString());
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            String sql = builder.toString();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Entity emptyEntity = entity.getEmptyEntity();
                fillEntity(emptyEntity, resultSet);
                entities.add(emptyEntity);
            }
        } finally {
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        return entities;
    }

    public void insert(Entity entity) {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO " + entity.getTable() + " (");
        for (int i = 0; i < entity.getCulums().length; i++) {
            builder.append(entity.getCulums()[i]);
            if (i != entity.getCulums().length - 1) builder.append(", ");
        }
        builder.append(") VALUES(");
        for (int i = 0; i < entity.getCulums().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(prepareValue(value, entity.getTypes()[i]));
            if (i != entity.getValues().length - 1) builder.append(", ");
        }
        builder.append(");");
        String sql = builder.toString();
        System.out.println(sql);
    }

    public void update(Entity oldEntity, Entity editedEntity) {
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE " + oldEntity.getTable() + " SET ");
        for (int i = 0; i < oldEntity.getCulums().length; i++) {
            builder.append(oldEntity.getCulums()[i]);
            builder.append(" = " + editedEntity.getCulums()[i]);
            if (i != oldEntity.getCulums().length - 1) builder.append(", ");
        }
        String sql = builder.toString();
        System.out.println(sql);
    }

    private String prepareValue(Object value, JDBCType type) {
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
