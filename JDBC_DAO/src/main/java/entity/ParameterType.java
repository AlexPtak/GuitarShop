package entity;

import dto.ParameterTypeDto;

import java.sql.JDBCType;

public class ParameterType implements Entity {

    private static final String TABLE = "guitar_shop.parameter_type";

    private static final int ID = 0;
    private static final int TYPE = 1;
    private static final int COLUMNS_COUNT = 2;

    private static final String[] COLUMNS = {"id_parameter_type", "type"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.VARCHAR};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public String getType() {
        return (String) values[TYPE];
    }

    public void setType(String type) {
        values[TYPE] = type;
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
        return new ParameterType();
    }

    @Override
    public ParameterTypeDto createDto() {
        ParameterTypeDto parameterTypeDto = new ParameterTypeDto();
        parameterTypeDto.setParameterTypeId((Integer) values[ID]);
        parameterTypeDto.setType((String) values[TYPE]);
        return parameterTypeDto;
    }
}
