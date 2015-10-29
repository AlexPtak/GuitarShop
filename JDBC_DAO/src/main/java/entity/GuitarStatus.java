package entity;

import dto.GuitarStatusDto;

import java.sql.JDBCType;

public class GuitarStatus implements Entity {

    private static final String TABLE = "guitar_shop.guitar_status";

    private static final int ID = 0;
    private static final int STATUS = 1;
    private static final int DESC = 2;
    private static final int COLUMNS_COUNT = 3;

    private static final String[] COLUMNS = {"id_status", "status", "description"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.CHAR, JDBCType.VARCHAR};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public String getStatus() {
        return (String) values[STATUS];
    }

    public void setStatus(Character status) {
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
        for (int i = 0; i < getColumns().length; i++) {
            builder.append(getColumns()[i] + " - " + getValues()[i] + ";");
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
    public String[] getColumns() {
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
        return new GuitarStatus();
    }

    @Override
    public GuitarStatusDto createDto() {
        GuitarStatusDto guitarStatusDto = new GuitarStatusDto();
        guitarStatusDto.setStatusId((Integer) values[ID]);
        guitarStatusDto.setStatus((Character) values[STATUS]);
        guitarStatusDto.setDesc((String) values[DESC]);
        return guitarStatusDto;
    }
}
