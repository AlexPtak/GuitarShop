package entity;

import java.sql.JDBCType;

public interface Entity {
    public String getTable();
    public String[] getCulums();
    public Object[] getValues();
    public JDBCType[] getTypes();
    public Entity getEmptyEntity();
}