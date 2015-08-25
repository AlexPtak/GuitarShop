package dao;

import java.sql.JDBCType;
import java.util.List;

public interface Entity {
    public String getTable();
    public String[] getCulums();
    public Object[] getValues();
    public JDBCType[] getTypes();
    public Entity getEmptyEntity();
}