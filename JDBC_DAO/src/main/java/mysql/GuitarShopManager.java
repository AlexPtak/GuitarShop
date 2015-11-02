package mysql;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import entity.Entity;
import myUtils.GuitarShopException;

import java.beans.PropertyVetoException;
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

    private GuitarShopManager() throws GuitarShopException {
        comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);

        comboPooledDataSource.setMinPoolSize(5);
        comboPooledDataSource.setAcquireIncrement(5);
        comboPooledDataSource.setMaxPoolSize(20);
        comboPooledDataSource.setMaxStatements(150);
    }

    public static GuitarShopManager getInstance() throws GuitarShopException {
        if (dataSource == null) {
            dataSource = new GuitarShopManager();
            return dataSource;
        } else {
            return dataSource;
        }
    }

    public Connection getConnection() throws GuitarShopException {
        try {
            return this.comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Entity singleSelect(Entity entity) throws GuitarShopException {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT ");
        for (int i = 0; i < entity.getColumns().length; i++) builder.append(entity.getColumns()[i] + ", ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append(" FROM " + entity.getTable());
        builder.append(" WHERE ");
        for (int i = 0; i < entity.getValues().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(entity.getColumns()[i] + " = " + prepareValue(value, entity.getTypes()[i]) + ";");
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
            if (resultSet.next()) {
                fillEntity(entity, resultSet);
                return entity;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public List<Entity> select(Entity entity) throws GuitarShopException {
        StringBuilder builder = new StringBuilder();
        ArrayList<Entity> entities = new ArrayList<Entity>();
        builder.append("SELECT ");
        for (int i = 0; i < entity.getColumns().length; i++) builder.append(entity.getColumns()[i] + ", ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append(" FROM " + entity.getTable());
        builder.append(" WHERE ");
        for (int i = 0; i < entity.getValues().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(entity.getColumns()[i] + " = " + prepareValue(value, entity.getTypes()[i]) + " AND ");
        }
        builder.delete(builder.length() - 5, builder.length());
        builder.append(";");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(entity, sql, entities);
        return entities;
    }

    public List<Entity> selectAll(Entity entity) throws GuitarShopException {
        StringBuilder builder = new StringBuilder();
        ArrayList<Entity> entities = new ArrayList<Entity>();
        builder.append("SELECT ");
        for (int i = 0; i < entity.getColumns().length; i++) builder.append(entity.getColumns()[i] + ", ");
        builder.delete(builder.length() - 2, builder.length());
        builder.append(" FROM " + entity.getTable());
        builder.append(";");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(entity, sql, entities);
        return entities;
    }

    public void insert(Entity entity) throws GuitarShopException {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO " + entity.getTable() + " (");
        for (int i = 0; i < entity.getColumns().length; i++) {
            builder.append(entity.getColumns()[i] + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(") VALUES(");
        for (int i = 0; i < entity.getColumns().length; i++) {
            Object value = entity.getValues()[i];
            builder.append(prepareValue(value, entity.getTypes()[i]) + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        builder.append(");");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(null, sql, null);
    }

    public void update(Entity oldEntity, Entity editedEntity) throws GuitarShopException {
        StringBuilder builder = new StringBuilder();
        builder.append("UPDATE " + oldEntity.getTable() + " SET ");
        for (int i = 0; i < editedEntity.getColumns().length; i++) {
            Object value = editedEntity.getValues()[i];
            if (value == null) continue;
            builder.append(editedEntity.getColumns()[i] + " = " + prepareValue(value, editedEntity.getTypes()[i]) + ", ");
        }
        builder.delete(builder.length() - 2, builder.length());
        final int primeryKey = 0;
        builder.append(" WHERE " + oldEntity.getColumns()[primeryKey] + " = " + editedEntity.getValues()[primeryKey] + ";");
        String sql = builder.toString();
        System.out.println(sql);
        databaseExecution(null, sql, null);
    }

    private void databaseExecution(Entity entity, String sql, List entities) throws GuitarShopException {
        Statement statement = null;
        Connection connection = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (connection != null) try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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

    private void fillEntity(Entity entity, ResultSet resultSet) throws GuitarShopException {
        for (int i = 0; i < entity.getColumns().length; i++) {
            switch (entity.getTypes()[i]) {
                case INTEGER:
                case SMALLINT:
                    try {
                        entity.getValues()[i] = resultSet.getInt(i + 1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case DOUBLE:
                    try {
                        entity.getValues()[i] = resultSet.getDouble(i + 1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case VARCHAR:
                case CHAR:
                case NVARCHAR:
                    try {
                        entity.getValues()[i] = resultSet.getString(i + 1);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }
}
