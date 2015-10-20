package dto;

public class ParameterValueDto {

    private int parameterValueId;
    private String value;
    private int parameterTypeId;

    public int getParameterValueId() {
        return parameterValueId;
    }

    public void setParameterValueId(int parameterValueId) {
        this.parameterValueId = parameterValueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getParameterTypeId() {
        return parameterTypeId;
    }

    public void setParameterTypeId(int parameterTypeId) {
        this.parameterTypeId = parameterTypeId;
    }
}
