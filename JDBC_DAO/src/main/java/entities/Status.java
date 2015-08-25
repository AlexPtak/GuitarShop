package entities;

import dao.Entity;

import java.sql.JDBCType;

public class Status implements Entity {

    private static final String TABLE = "guitar_shop.status";

    private static final int ID = 0;
    private static final int STATUS = 1;
    private static final int DESC = 2;
    public static final int COLUMNS_COUNT = 3;

    private static final String[] COLUMNS = {"id_status", "status", "desc"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.CHAR, JDBCType.VARCHAR};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public Character getStatus() {
        return (Character) values[STATUS];
    }

    public void setStatus(String status) {
        values[STATUS] = status;
    }

    public String getDesc() {
        return (String) values[DESC];
    }

    public void setDesc(String desc) {
        values[DESC] = desc;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getId() + " " + getStatus() + " " + getDesc());
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
        return new Status();
    }
}
