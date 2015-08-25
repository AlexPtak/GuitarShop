package mysql;

import dao.Entity;

import java.sql.*;
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
        for (int i = 0; i < entity.getCulums().length; i++) {
            builder.append(entity.getCulums()[i]);
            if (i != entity.getCulums().length - 1) builder.append(", ");
        }
        builder.append(" FROM " + entity.getTable());
        builder.append(" WHERE ");
        for (int i = 0; i < entity.getValues().length; i++) {
            Object value = entity.getValues()[i];
            if (value == null) continue;
            builder.append(entity.getCulums()[i] + " = " + prepareValue(value, entity.getTypes()[i]) + ";");
        }
        String sql = builder.toString();
        System.out.println(sql);
        ResultSet resultSet;
        return entity.getEmptyEntity();
    }

    public List<Entity> select(Entity entity, String addToWhere) throws SQLException {
        return Collections.EMPTY_LIST;
    }

    public void insert(Entity entity) {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO " + entity.getTable() + " (");
        for (int i = 0; i < entity.getCulums().length; i++) {
            builder.append(entity.getCulums()[i]);
            if (i != entity.getCulums().length - 1) builder.append(", ");
        }
        builder.append(") VALUES(");
        for (int i = 0; i < entity.getValues().length; i++) {
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
        for (int i = 0; i < entity.getCulums().length - 1; i++) {
            switch (entity.getTypes()[i]) {
                case INTEGER:
                case SMALLINT:
                case DOUBLE:
                    entity.getValues()[i] = resultSet.getInt(i + 1);
                case VARCHAR:
                case CHAR:
                    entity.getValues()[i] = resultSet.getString(i + 1);
            }
        }
    }
}
