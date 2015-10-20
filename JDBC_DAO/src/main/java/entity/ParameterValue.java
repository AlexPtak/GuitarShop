package entity;

import dto.ParameterValueDto;

import java.sql.JDBCType;

public class ParameterValue implements Entity {

    private static final String TABLE = "guitar_shop.parameter_value";

    private static final int ID = 0;
    private static final int VALUE = 2;
    private static final int PARAMETER_TYPE_ID = 2;
    public static final int COLUMNS_COUNT = 3;

    private static final String[] COLUMNS = {"id_parameter_value", "value", "parameter_type_id"};
    private static final JDBCType[] TYPES = {JDBCType.INTEGER, JDBCType.VARCHAR, JDBCType.INTEGER};
    private Object[] values = new Object[COLUMNS_COUNT];

    public Integer getId() {
        return (Integer) values[ID];
    }

    public void setId(Integer id) {
        values[ID] = id;
    }

    public String getValue() {
        return (String) values[VALUE];
    }

    public void setValue(String value) {
        values[VALUE] = value;
    }

    public Integer getParameterTypeId() {
        return (Integer) values[PARAMETER_TYPE_ID];
    }

    public void setParameterTypeId(Integer parameterTypeId) {
        values[PARAMETER_TYPE_ID] = parameterTypeId;
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
        return new ParameterValue();
    }

    @Override
    public ParameterValueDto createDto() {
        ParameterValueDto parameterValueDto = new ParameterValueDto();
        parameterValueDto.setParameterValueId((Integer) values[ID]);
        parameterValueDto.setValue((String) values[VALUE]);
        parameterValueDto.setParameterTypeId((Integer) values[PARAMETER_TYPE_ID]);
        return parameterValueDto;
    }
}
