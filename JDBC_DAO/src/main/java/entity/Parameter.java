package entity;

import dto.ParameterDto;

import java.sql.JDBCType;

public class Parameter implements Entity {

    private static final String TABLE = "guitar_shop.parameter";

    private static final int ID = 0;
    private static final int PARAMETER_TYPE_ID = 1;
    private static final int VALUE = 2;
    private static final int COLUMNS_COUNT = 3;

    private static final String[] COLUMNS = {"id_guitar", "id_parameter_type", "value"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.INTEGER, JDBCType.VARCHAR};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public Integer getParameterTypeId() {
        return (Integer) values[PARAMETER_TYPE_ID];
    }

    public void setParameterTypeId(Integer parameterTypeId) {
        values[PARAMETER_TYPE_ID] = parameterTypeId;
    }

    public String getValue() {
        return (String) values[VALUE];
    }

    public void setValue(String value) {
        values[VALUE] = value;
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
        return new Parameter();
    }

    @Override
    public ParameterDto createDto() {
        ParameterDto parameterDto = new ParameterDto();
        parameterDto.setGuitarId((Integer) values[ID]);
        parameterDto.setParameterTypeId((Integer) values[PARAMETER_TYPE_ID]);
        parameterDto.setValue((String) values[VALUE]);
        return parameterDto;
    }
}
