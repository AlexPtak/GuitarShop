package entities;

import dao.Entity;

import java.sql.JDBCType;

public class Customer implements Entity {

    private static final String TABLE = "guitar_shop.customer";

    private static final int ID = 0;
    private static final int FIRST_NAME = 1;
    private static final int LAST_NAME = 2;
    private static final int EMAIL = 3;
    private static final int PHONE = 4;
    private static final int LOGIN = 5;
    private static final int PASS = 6;
    private static final int STATUS_ID = 7;
    public static final int COLUMNS_COUNT = 8;

    private static final String[] COLUMNS = {"id_customer", "first_name", "last_name", "email", "phone", "login", "pass", "id_status"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.VARCHAR, JDBCType.INTEGER};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public String getFirstName() {
        return (String) values[FIRST_NAME];
    }

    public void setFirstName(String firstName) {
        values[FIRST_NAME] = firstName;
    }

    public String getLastName() {
        return (String) values[LAST_NAME];
    }

    public void setLastName(String lastName) {
        values[LAST_NAME] = lastName;
    }

    public String getEmail() {
        return (String) values[EMAIL];
    }

    public void setEmail(String email) {
        values[EMAIL] = email;
    }

    public String getPhone() {
        return (String) values[PHONE];
    }

    public void setPhone(String phone) {
        values[PHONE] = phone;
    }

    public String getLogin() {
        return (String) values[LOGIN];
    }

    public void setLogin(String login) {
        values[LOGIN] = login;
    }

    public String getPass() {
        return (String) values[PASS];
    }

    public void setPass(String pass) {
        values[PASS] = pass;
    }

    public Integer getStatusId() {
        return (Integer) values[STATUS_ID];
    }

    public void setStatusId(Integer id) {
        values[STATUS_ID] = id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < getCulums().length; i++) {
            builder.append(getCulums()[i] + " - " + getValues()[i] + ";");
            builder.append("\n");
        }
        builder.append("------------------");
        return builder.toString();
    }

    @Override
    public String getTable() {
        return TABLE;
    }

    @Override
    public String[] getCulums() {
        return COLUMNS;
    }

    @Override
    public Object[] getValues() {
        return values;
    }

    @Override
    public JDBCType[] getTypes() {
        return TYPES;
    }

    @Override
    public Entity getEmptyEntity() {
        return new Customer();
    }
}
